package pw.h3o.jdokuwiki.model.requests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.xmlrpc.XmlRpcException;

import pw.h3o.jdokuwiki.model.response.DokuWikiResponseException;
import pw.h3o.jdokuwiki.model.response.SetLocksResponse;
import pw.h3o.jdokuwiki.net.DokuWikiClient;

public class SetLocks extends DokuWikiXmlRpcRequest<SetLocksResponse> {

	private List<String> lockIds;
	private List<String> unlockIds;

	public SetLocks() {
		super("dokuwiki.setLocks");
		lockIds = new ArrayList<String>();
		unlockIds = new ArrayList<String>();
	}

	@Override
	public Object[] getParameters() {
		HashMap<String, List<String>> parameters = new HashMap<String, List<String>>();
		parameters.put("locked", lockIds);
		parameters.put("unlocked", unlockIds);
		return new Object[] { parameters };
	}

	public List<String> getLockIds() {
		return lockIds;
	}

	public void setLockIds(List<String> lockIds) {
		this.lockIds = lockIds;
	}

	public List<String> getUnlockIds() {
		return unlockIds;
	}

	public void setUnlockIds(List<String> unlockIds) {
		this.unlockIds = unlockIds;
	}

	public void addLockId(String lockId) {
		lockIds.add(lockId);
	}

	public void addUnlockId(String unlockId) {
		unlockIds.add(unlockId);
	}

	@Override
	public SetLocksResponse execute(DokuWikiClient client) throws XmlRpcException {
		SetLocksResponse response = new SetLocksResponse();
		try {
			response.init(super.execute(client));
		} catch (DokuWikiResponseException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}
}
