package pw.h3o.jdokuwiki.model.requests;

import org.apache.xmlrpc.XmlRpcException;

import pw.h3o.jdokuwiki.model.response.DokuWikiResponseException;
import pw.h3o.jdokuwiki.model.response.GetPageInfoResponse;
import pw.h3o.jdokuwiki.net.DokuWikiClient;

public class GetPageInfo extends DokuWikiXmlRpcRequest<GetPageInfoResponse> {

	private String pageName;

	public GetPageInfo() {
		super("wiki.getPageInfo");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] { pageName };
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	@Override
	public GetPageInfoResponse execute(DokuWikiClient client)
			throws XmlRpcException {
		GetPageInfoResponse response = new GetPageInfoResponse();
		try {
			response.init(super.execute(client));
		} catch (DokuWikiResponseException e) {
			System.err.println(e.getMessage());
		}

		return response;
	}

}
