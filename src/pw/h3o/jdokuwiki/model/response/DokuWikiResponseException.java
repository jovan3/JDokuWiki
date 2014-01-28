package pw.h3o.jdokuwiki.model.response;

public class DokuWikiResponseException extends Exception {

	private static final long serialVersionUID = -1628427164494833745L;

	public DokuWikiResponseException() {
		super();
	}

	public DokuWikiResponseException(Exception e) {
		super(e);
	}
}
