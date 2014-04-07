package pw.h3o.jdokuwiki.model.requests;

import org.apache.xmlrpc.XmlRpcException;

import pw.h3o.jdokuwiki.model.response.DokuWikiResponseException;
import pw.h3o.jdokuwiki.model.response.ListLinksResponse;
import pw.h3o.jdokuwiki.net.DokuWikiClient;

public class ListLinks extends DokuWikiXmlRpcRequest<ListLinksResponse> {

	private String pageName;

	public ListLinks() {
		super("wiki.listLinks");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] { getPageName() };
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	@Override
	public ListLinksResponse execute(DokuWikiClient client)
			throws XmlRpcException {
		ListLinksResponse response = new ListLinksResponse();
		try {
			response.init(super.execute(client));
		} catch (DokuWikiResponseException e) {
			System.err.println(e.getMessage());
		}

		return response;
	}
}
