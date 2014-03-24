package pw.h3o.jdokuwiki.model.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class GetPagelistResponse extends DokuWikiXmlRpcResponse {

	private static final String KEY_ID = "id";
	private static final String KEY_REV = "rev";
	private static final String KEY_SIZE = "size";
	private static final String KEY_MODIFIED = "mtime";

	private List<Page> pages = new ArrayList<Page>();

	public static class Page {

		private String id;
		private long rev;
		private long size;
		private Date modifiedTime;

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

	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(Object responseObject) throws DokuWikiResponseException {
		Object[] pagesObjects = null;
		try {
			pagesObjects = (Object[]) responseObject;
		} catch (ClassCastException e) {
			throw new DokuWikiResponseException(e);
		}

		for (Object object : pagesObjects) {
			HashMap<String, Object> pageProperties = ((HashMap<String, Object>) object);
			Page page = new Page();
			page.setId((String) pageProperties.get(KEY_ID));
			page.setModifiedTime(new Date((Long) Long.parseLong(pageProperties.get(KEY_MODIFIED).toString()) * 1000));
			page.setRev((Integer) pageProperties.get(KEY_REV));
			page.setSize((Integer) pageProperties.get(KEY_SIZE));

			pages.add(page);
		}
	}

	public List<Page> getPages() {
		return pages;
	}

	@Override
	public String toString() {
		StringBuilder toStringBuilder = new StringBuilder("pages: " + pages.size());
		toStringBuilder.append('\n');

		for (Page page : pages) {
			toStringBuilder.append("Page: ");
			toStringBuilder.append(page.getId());
			toStringBuilder.append(" Date: ");
			toStringBuilder.append(page.getModifiedTime().toString());
			toStringBuilder.append('\n');
		}

		return toStringBuilder.toString();
	}
}
