package pw.h3o.jdokuwiki.model.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPageVersionsResponse extends DokuWikiXmlRpcResponse {

	private List<PageVersion> pageVersions;

	public GetPageVersionsResponse() {
		pageVersions = new ArrayList<GetPageVersionsResponse.PageVersion>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(Object responseObject) throws DokuWikiResponseException {
		Object[] map = ((Object[]) responseObject);
		for (Object object : map) {
			HashMap<String, Object> pageVersionMap = (HashMap<String, Object>) object;
			PageVersion pageVersion = new PageVersion(pageVersionMap);
			pageVersions.add(pageVersion);
		}
	}

	public List<PageVersion> getPageVersions() {
		return pageVersions;
	}

	public void setPageVersions(List<PageVersion> pageVersions) {
		this.pageVersions = pageVersions;
	}

	public static class PageVersion {

		private static final String KEY_USER = "user";
		private static final String KEY_IP = "ip";
		private static final String KEY_TYPE = "type";
		private static final String KEY_SUM = "sum";
		private static final String KEY_MODIFIED = "modified";
		private static final String KEY_VERSION = "version";

		private String user;
		private String ip;
		private String type;
		private String sum;
		private Date modified;
		private Integer version;

		public PageVersion(Map<String, Object> pageVersionMap) {
			initFromMap(pageVersionMap);
		}

		public void initFromMap(Map<String, Object> valuesMap) {
			this.user = (String) valuesMap.get(KEY_USER);
			this.ip = (String) valuesMap.get(KEY_IP);
			this.type = (String) valuesMap.get(KEY_TYPE);
			this.sum = (String) valuesMap.get(KEY_SUM);
			this.modified = (Date) valuesMap.get(KEY_MODIFIED);
			this.version = (Integer) valuesMap.get(KEY_VERSION);
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getSum() {
			return sum;
		}

		public void setSum(String sum) {
			this.sum = sum;
		}

		public Date getModified() {
			return modified;
		}

		public void setModified(Date modified) {
			this.modified = modified;
		}

		public Integer getVersion() {
			return version;
		}

		public void setVersion(Integer version) {
			this.version = version;
		}

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
