package pw.h3o.jdokuwiki.model.response;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListLinksResponse extends DokuWikiXmlRpcResponse {

	private List<PageLink> pageLinks = new ArrayList<PageLink>();

	@SuppressWarnings("unchecked")
	@Override
	public void init(Object responseObject) throws DokuWikiResponseException {
		Object[] linksList = ((Object[]) responseObject);
		for (Object object : linksList) {
			HashMap<String, Object> pageLinkMap = (HashMap<String, Object>) object;
			PageLink pageVersion = new PageLink(pageLinkMap);
			getPageLinks().add(pageVersion);
		}
	}

	public List<PageLink> getPageLinks() {
		return pageLinks;
	}

	public void setPageLinks(List<PageLink> pageLinks) {
		this.pageLinks = pageLinks;
	}

	public static class PageLink {

		private static final String LOCAL = "local";
		private static final String EXTERN = "extern";

		private static final String KEY_PAGE = "page";
		private static final String KEY_TYPE = "type";
		private static final String KEY_HREF = "href";

		public enum PageLinkType {
			INTERNAL, EXTERNAL
		}

		private PageLinkType type;
		private String page;
		private URL url;

		public PageLink(Map<String, Object> initMap) {
			this.page = (String) initMap.get(KEY_PAGE);
			this.type = getType((String) initMap.get(KEY_TYPE));
			try {
				this.url = new URL((String) initMap.get(KEY_HREF));
			} catch (MalformedURLException e) {
				// TODO: Use logger here
				System.out.println("invalid url:" + e.getMessage());
			}
			System.out.println(page);
		}

		public PageLinkType getType() {
			return type;
		}

		public void setType(PageLinkType type) {
			this.type = type;
		}

		public String getPage() {
			return page;
		}

		public void setPage(String page) {
			this.page = page;
		}

		public URL getUrl() {
			return url;
		}

		public void setUrl(URL url) {
			this.url = url;
		}

		private PageLinkType getType(String typeString) {
			if (typeString.equals(EXTERN)) {
				return PageLinkType.EXTERNAL;
			} else if (typeString.equals(LOCAL)) {
				return PageLinkType.INTERNAL;
			}

			throw new IllegalArgumentException();
		}

	}

}
