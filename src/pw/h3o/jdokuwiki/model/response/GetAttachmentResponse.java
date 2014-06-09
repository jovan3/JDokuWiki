package pw.h3o.jdokuwiki.model.response;

import java.io.ByteArrayInputStream;

public class GetAttachmentResponse extends DokuWikiXmlRpcResponse {

	private ByteArrayInputStream attachmentData;

	@Override
	public void init(Object responseObject) throws DokuWikiResponseException {
		byte[] responseData = (byte[]) responseObject;
		setAttachmentData(new ByteArrayInputStream(responseData));
	}

	public ByteArrayInputStream getAttachmentData() {
		return attachmentData;
	}

	public void setAttachmentData(ByteArrayInputStream attachmentData) {
		this.attachmentData = attachmentData;
	}

}
