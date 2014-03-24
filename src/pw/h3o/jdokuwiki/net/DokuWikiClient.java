package pw.h3o.jdokuwiki.net;

import java.net.CookieStore;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import pw.h3o.jdokuwiki.model.requests.DokuWikiXmlRpcRequest;

public class DokuWikiClient {

	private URL serverUrl;
	private XmlRpcClient dokuWikiRpcClient;

	public DokuWikiClient(URL serverUrl) {
		this.serverUrl = serverUrl;
		initClient();
	}

	private void initClient() {
		if (serverUrl == null) {
			throw new IllegalStateException("Server url should be set");
		}

		XmlRpcClientConfigImpl dokuWikiClientConfig = new XmlRpcClientConfigImpl();
		dokuWikiClientConfig.setServerURL(serverUrl);
		CookieStore dokuWikiCookieStore = new DokuWikiClientCookieStore();

		dokuWikiRpcClient = new XmlRpcClient();
		dokuWikiRpcClient.setTransportFactory(new DokuWikiTransportFactory(dokuWikiRpcClient, dokuWikiCookieStore));
		dokuWikiRpcClient.setConfig(dokuWikiClientConfig);
	}

	public Object execute(DokuWikiXmlRpcRequest<?> dokuWikiRequest) throws XmlRpcException {
		return dokuWikiRpcClient.execute(dokuWikiRequest.getMethodName(), dokuWikiRequest.getParameters());
	}

}
