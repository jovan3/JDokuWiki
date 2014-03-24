package pw.h3o.jdokuwiki.model.requests;

public class GetPageVersion extends DokuWikiXmlRpcRequest<String> {

	public GetPageVersion(String methodName) {
		super(methodName);
		// TODO Auto-generated constructor stub
	}

	private String pageName;
	private String timestamp;

	public GetPageVersion() {
		super("wiki.getPageVersion");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] { pageName, timestamp };
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
