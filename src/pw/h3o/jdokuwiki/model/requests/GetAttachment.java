package pw.h3o.jdokuwiki.model.requests;

import org.apache.xmlrpc.XmlRpcException;

import pw.h3o.jdokuwiki.model.response.DokuWikiResponseException;
import pw.h3o.jdokuwiki.model.response.GetAttachmentResponse;
import pw.h3o.jdokuwiki.net.DokuWikiClient;

public class GetAttachment extends DokuWikiXmlRpcRequest<GetAttachmentResponse> {

	private String id;

	public GetAttachment() {
		super("wiki.getAttachment");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] { id };
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public GetAttachmentResponse execute(DokuWikiClient client)
			throws XmlRpcException {
		GetAttachmentResponse response = new GetAttachmentResponse();
		try {
			response.init(super.execute(client));
		} catch (DokuWikiResponseException e) {
			System.err.println(e.getMessage());
		}

		return response;
	}

}
