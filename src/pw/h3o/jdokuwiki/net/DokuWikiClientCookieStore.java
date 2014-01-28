package pw.h3o.jdokuwiki.net;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

public class DokuWikiClientCookieStore implements CookieStore {

	private final List<HttpCookie> cookieStore;

	public DokuWikiClientCookieStore() {
		cookieStore = new LinkedList<HttpCookie>();
	}

	@Override
	public void add(URI uri, HttpCookie cookie) {
		if (!cookieStore.contains(cookie)) {
			System.out.println("new cookie:" + cookie.toString());
			cookieStore.add(cookie);
		}
	}

	@Override
	public List<HttpCookie> get(URI uri) {
		return null;
	}

	@Override
	public List<HttpCookie> getCookies() {
		return cookieStore;
	}

	@Override
	public List<URI> getURIs() {
		return null;
	}

	@Override
	public boolean remove(URI uri, HttpCookie cookie) {
		return false;
	}

	@Override
	public boolean removeAll() {
		return false;
	}

}