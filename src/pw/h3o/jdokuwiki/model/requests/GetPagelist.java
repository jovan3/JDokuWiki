package pw.h3o.jdokuwiki.model.requests;

import org.apache.xmlrpc.XmlRpcException;

import pw.h3o.jdokuwiki.model.response.DokuWikiResponseException;
import pw.h3o.jdokuwiki.model.response.GetPagelistResponse;
import pw.h3o.jdokuwiki.net.DokuWikiClient;

public class GetPagelist extends DokuWikiXmlRpcRequest<GetPagelistResponse> {

	private String namespace;

	public GetPagelist() {
		super("dokuwiki.getPagelist");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] { namespace };
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@Override
	public GetPagelistResponse execute(DokuWikiClient client) throws XmlRpcException {
		GetPagelistResponse response = new GetPagelistResponse();
		try {
			response.init(super.execute(client));
		} catch (DokuWikiResponseException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}
}
