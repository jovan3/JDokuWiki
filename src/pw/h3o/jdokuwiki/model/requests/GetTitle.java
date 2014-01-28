package pw.h3o.jdokuwiki.model.requests;

public class GetTitle extends DokuWikiXmlRpcRequest<String> {

	public GetTitle() {
		super("dokuwiki.getTitle");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] {};
	}

}
