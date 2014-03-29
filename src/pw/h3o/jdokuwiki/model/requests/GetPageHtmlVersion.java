package pw.h3o.jdokuwiki.model.requests;

public class GetPageHtmlVersion extends DokuWikiXmlRpcRequest<String> {

	private String pageName;
	private int timestamp;

	public GetPageHtmlVersion() {
		super("wiki.getPageHTMLVersion");
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

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

}
