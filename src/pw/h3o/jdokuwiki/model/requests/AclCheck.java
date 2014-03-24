package pw.h3o.jdokuwiki.model.requests;

public class AclCheck extends DokuWikiXmlRpcRequest<Integer> {

	private String pageName;

	public AclCheck() {
		super("wiki.aclCheck");
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
