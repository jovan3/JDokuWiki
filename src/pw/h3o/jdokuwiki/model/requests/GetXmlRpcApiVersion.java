package pw.h3o.jdokuwiki.model.requests;

public class GetXmlRpcApiVersion extends DokuWikiXmlRpcRequest<Integer> {

	public GetXmlRpcApiVersion() {
		super("dokuwiki.getXMLRPCAPIVersion");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] {};
	}

}
