package pw.h3o.jdokuwiki.model.requests;

public class Login extends DokuWikiXmlRpcRequest<Boolean> {

	private String username;

	private String password;

	public Login() {
		super("dokuwiki.login");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Object[] getParameters() {
		return new Object[] { username, password };
	}

}
