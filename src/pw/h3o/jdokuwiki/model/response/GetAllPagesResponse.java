package pw.h3o.jdokuwiki.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetAllPagesResponse extends DokuWikiXmlRpcResponse {

	private List<Page> pages;

	@Override
	public void init(Object responseObject) throws DokuWikiResponseException {
		Object[] responsePagesArray = (Object[]) responseObject;
		pages = new ArrayList<Page>();
		for (Object object : responsePagesArray) {
			pages.add(new Page((Map<String, Object>) object));
		}
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

}
