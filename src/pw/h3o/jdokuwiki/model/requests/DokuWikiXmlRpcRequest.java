package pw.h3o.jdokuwiki.model.requests;

import org.apache.xmlrpc.XmlRpcException;

import pw.h3o.jdokuwiki.net.DokuWikiClient;

public abstract class DokuWikiXmlRpcRequest<R> {

	private String methodName;

	public DokuWikiXmlRpcRequest(String methodName) {
		this.setMethodName(methodName);
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public abstract Object[] getParameters();

	@SuppressWarnings("unchecked")
	public R execute(DokuWikiClient client) throws XmlRpcException {
		R result = null;
		try {
			result = (R) client.execute(this);
		} catch (ClassCastException e) {

		}
		return result;

	}

}
