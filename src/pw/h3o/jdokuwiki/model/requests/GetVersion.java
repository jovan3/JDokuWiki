package pw.h3o.jdokuwiki.model.requests;

public class GetVersion extends DokuWikiXmlRpcRequest<String> {

	public GetVersion() {
		super("dokuwiki.getVersion");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] {};
	}

}
