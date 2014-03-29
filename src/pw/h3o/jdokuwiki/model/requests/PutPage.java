package pw.h3o.jdokuwiki.model.requests;

import java.util.HashMap;
import java.util.Map;

public class PutPage extends DokuWikiXmlRpcRequest<Boolean> {

	private static final String ATTR_SUMMARY = "sum";
	private static final String ATTR_MINOR = "minor";

	private String pageName;
	private String rawText;
	private String summary;
	private Boolean minor;

	public PutPage() {
		super("wiki.putPage");
	}

	@Override
	public Object[] getParameters() {
		if (summary != null && minor != null) {
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put(ATTR_SUMMARY, summary);
			attributes.put(ATTR_MINOR, minor);
			return new Object[] { pageName, rawText, attributes };
		}

		return new Object[] { pageName, rawText };
	}

	public Boolean isMinor() {
		return minor;
	}

	public void setMinor(Boolean minor) {
		this.minor = minor;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRawText() {
		return rawText;
	}

	public void setRawText(String rawText) {
		this.rawText = rawText;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

}
