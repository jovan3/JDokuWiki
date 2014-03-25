package pw.h3o.jdokuwiki.model.response;

import java.util.Date;
import java.util.Map;

public class GetPageInfoResponse extends DokuWikiXmlRpcResponse {

	private static final String KEY_NAME = "name";
	private static final String KEY_LAST_MODIFIED = "lastModified";
	private static final String KEY_AUTHOR = "author";
	private static final String KEY_VERSION = "version";

	private String name;
	private Date lastModified;
	private String author;
	private Integer version;

	@SuppressWarnings("unchecked")
	@Override
	public void init(Object responseObject) throws DokuWikiResponseException {
		Map<String, Object> responseObjArray = (Map<String, Object>) responseObject;

		this.name = (String) responseObjArray.get(KEY_NAME);
		this.lastModified = (Date) responseObjArray.get(KEY_LAST_MODIFIED);
		this.author = (String) responseObjArray.get(KEY_AUTHOR);
		this.version = (Integer) responseObjArray.get(KEY_VERSION);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
