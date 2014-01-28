package pw.h3o.jdokuwiki.model.response;

public abstract class DokuWikiXmlRpcResponse {

	public abstract void init(Object responseObject) throws DokuWikiResponseException;

}
