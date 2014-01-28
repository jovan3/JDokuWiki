package pw.h3o.jdokuwiki.net;

import java.io.IOException;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientException;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import org.apache.xmlrpc.client.XmlRpcSunHttpTransport;
import org.apache.xmlrpc.client.XmlRpcTransport;

public class DokuWikiTransportFactory extends XmlRpcCommonsTransportFactory {

	private XmlRpcClient client;
	private CookieStore cookieStore;

	public DokuWikiTransportFactory(XmlRpcClient client, CookieStore cookieStore) {
		super(client);
		this.client = client;
		this.cookieStore = cookieStore;
		this.setHttpClient(new HttpClient());
	}

	@Override
	public XmlRpcTransport getTransport() {
		return new DokuWikiXmlRpcTransport(client);
	}

	private class DokuWikiXmlRpcTransport extends XmlRpcSunHttpTransport {

		private URLConnection urlConnection;

		public DokuWikiXmlRpcTransport(XmlRpcClient client) {
			super(client);
		}

		@Override
		protected URLConnection newURLConnection(URL url) throws IOException {
			this.urlConnection = super.newURLConnection(url);
			return this.urlConnection;
		}

		@Override
		protected void initHttpHeaders(XmlRpcRequest pRequest) throws XmlRpcClientException {
			super.initHttpHeaders(pRequest);
			setCookies(urlConnection);
		}

		private void setCookies(URLConnection connection) {
			List<HttpCookie> cookies = cookieStore.getCookies();
			final StringBuffer rc = new StringBuffer();
			for (final HttpCookie cookie : cookies) {
				if (rc.length() > 0) {
					rc.append("; ");
				}
				rc.append(cookie.toString());
			}

			if (rc.length() > 0) {
				connection.setRequestProperty("Cookie", rc.toString());
			}
		}

		@Override
		protected void close() throws XmlRpcClientException {
			final Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
			final List<String> cookieHeaders = headerFields.get("Set-Cookie");

			if (cookieHeaders != null) {
				for (final String cookieHeader : cookieHeaders) {
					final String cleanCoockieHeader = cookieHeader.replace("; HttpOnly", "");
					final List<HttpCookie> cookieList = HttpCookie.parse("Set-Cookie: " + cleanCoockieHeader);
					for (final HttpCookie cookie : cookieList) {
						cookieStore.add(null, cookie);
					}
				}
			}

			super.close();

		}

	}

}