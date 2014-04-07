package pw.h3o.jdokuwiki.model.response;

import java.util.Date;
import java.util.Map;

public class Page {

	private static final String KEY_ID = "id";
	private static final String KEY_PERMS = "perms";
	private static final String KEY_MOD_TIME = "lastModified";
	private static final String KEY_SIZE = "size";

	private String id;
	private long rev;
	private long size;
	private Date modifiedTime;
	private int perms;

	public Page(Map<String, Object> initMap) {
		this.id = (String) initMap.get(KEY_ID);
		this.perms = (Integer) initMap.get(KEY_PERMS);
		this.size = (Integer) initMap.get(KEY_SIZE);
		this.modifiedTime = (Date) initMap.get(KEY_MOD_TIME);
	}

	public Page() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getRev() {
		return rev;
	}

	public void setRev(long rev) {
		this.rev = rev;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public int getPerms() {
		return perms;
	}

	public void setPerms(int perms) {
		this.perms = perms;
	}

}