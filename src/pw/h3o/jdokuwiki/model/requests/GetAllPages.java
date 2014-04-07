package pw.h3o.jdokuwiki.model.requests;

import org.apache.xmlrpc.XmlRpcException;

import pw.h3o.jdokuwiki.model.response.DokuWikiResponseException;
import pw.h3o.jdokuwiki.model.response.GetAllPagesResponse;
import pw.h3o.jdokuwiki.net.DokuWikiClient;

public class GetAllPages extends DokuWikiXmlRpcRequest<GetAllPagesResponse > {

	public GetAllPages() {
		super("wiki.getAllPages");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] {};
	}

	@Override
	public GetAllPagesResponse execute(DokuWikiClient client) throws XmlRpcException {
		GetAllPagesResponse response = new GetAllPagesResponse();
		try {
			response.init(super.execute(client));
		} catch (DokuWikiResponseException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}

}
