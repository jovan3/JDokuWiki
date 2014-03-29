package pw.h3o.jdokuwiki.model.requests;

public class GetPageHtml extends DokuWikiXmlRpcRequest<String> {

	private String pageName;

	public GetPageHtml() {
		super("wiki.getPageHTML");
	}

	@Override
	public Object[] getParameters() {
		return new Object[] { pageName };
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

}
