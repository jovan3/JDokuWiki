package pw.h3o.jdokuwiki.model.requests;

/**
 * Returns the raw Wiki text for a specific revision of a Wiki page.
 * 
 * @author yovan
 * 
 */
public class GetVersion extends DokuWikiXmlRpcRequest<String> {

	public GetVersion() {
		super("dokuwiki.getVersion");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] {};
	}

}
