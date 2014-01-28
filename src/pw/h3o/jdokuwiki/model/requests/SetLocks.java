package pw.h3o.jdokuwiki.model.requests;

import java.util.List;

import pw.h3o.jdokuwiki.model.response.SetLocksResponse;

public class SetLocks extends DokuWikiXmlRpcRequest<SetLocksResponse> {

	private List<String> lockIds;
	private List<String> unlockIds;

	public SetLocks() {
		super("dokuwiki.setLocks");
	}

	@Override
	public Object[] getParameters() {
		return null;
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

}
