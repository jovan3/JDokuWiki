package pw.h3o.jdokuwiki.model.requests;

public class AppendPage extends DokuWikiXmlRpcRequest<Boolean> {

	private String pageName;
	private String rawText;
	private String summary;
	private boolean minor;

	public AppendPage() {
		super("dokuwiki.appendPage");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] { pageName, rawText, new Object[] { summary, minor } };
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getRawText() {
		return rawText;
	}

	public void setRawText(String rawText) {
		this.rawText = rawText;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public boolean isMinor() {
		return minor;
	}

	public void setMinor(boolean minor) {
		this.minor = minor;
	}

}
