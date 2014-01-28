package pw.h3o.jdokuwiki.model.requests;

public class GetTime extends DokuWikiXmlRpcRequest<Long> {

	public GetTime(String methodName) {
		super("getTime");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] {};
	}
}
