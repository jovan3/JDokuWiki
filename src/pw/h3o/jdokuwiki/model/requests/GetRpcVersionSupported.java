package pw.h3o.jdokuwiki.model.requests;

public class GetRpcVersionSupported extends DokuWikiXmlRpcRequest<Integer> {

	public GetRpcVersionSupported() {
		super("wiki.getRPCVersionSupported");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] {};
	}

}
