package pw.h3o.jdokuwiki.model.response;

public class GetPageVersionsResponse extends DokuWikiXmlRpcResponse {

	@Override
	public void init(Object responseObject) throws DokuWikiResponseException {
		System.out.println("OK");
		System.out.println(responseObject);

	}

	public static class PageVersion {

		private static final String KEY_USER = "user";
		private static final String KEY_IP = "ip";

		private String user;

		private String ip;

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

	}

}
