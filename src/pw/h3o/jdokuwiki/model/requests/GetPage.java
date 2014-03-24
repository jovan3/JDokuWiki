package pw.h3o.jdokuwiki.model.requests;

public class GetPage extends DokuWikiXmlRpcRequest<String> {

	private String pageName;

	public GetPage() {
		super("wiki.getPage");
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
