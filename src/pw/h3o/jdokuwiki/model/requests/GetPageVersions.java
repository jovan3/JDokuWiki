package pw.h3o.jdokuwiki.model.requests;

import org.apache.xmlrpc.XmlRpcException;

import pw.h3o.jdokuwiki.model.response.DokuWikiResponseException;
import pw.h3o.jdokuwiki.model.response.GetPageVersionsResponse;
import pw.h3o.jdokuwiki.net.DokuWikiClient;

public class GetPageVersions extends
		DokuWikiXmlRpcRequest<GetPageVersionsResponse> {

	private String pageName;

	private Integer offset;

	public GetPageVersions() {
		super("wiki.getPageVersions");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] { pageName, offset };
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	@Override
	public GetPageVersionsResponse execute(DokuWikiClient client)
			throws XmlRpcException {
		GetPageVersionsResponse response = new GetPageVersionsResponse();
		try {
			response.init(super.execute(client));
		} catch (DokuWikiResponseException e) {
			System.err.println(e.getMessage());
		}

		return response;
	}
}
