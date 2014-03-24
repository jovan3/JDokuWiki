package pw.h3o.jdokuwiki.model.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SetLocksResponse extends DokuWikiXmlRpcResponse {

	private static final String KEY_LOCKED = "locked";
	private static final String KEY_LOCK_FAILED = "lockfailed";
	private static final String KEY_UNLOCKED = "unlocked";
	private static final String KEY_UNLOCK_FAIL = "unlockfailed";

	private List<String> locked;
	private List<String> lockFailed;
	private List<String> unlocked;
	private List<String> unlockFailed;

	public SetLocksResponse() {
		locked = new ArrayList<String>();
		lockFailed = new ArrayList<String>();
		unlocked = new ArrayList<String>();
		unlockFailed = new ArrayList<String>();
	}

	public List<String> getLocked() {
		return locked;
	}

	public void setLocked(List<String> locked) {
		this.locked = locked;
	}

	public List<String> getLockFailed() {
		return lockFailed;
	}

	public void setLockFailed(List<String> lockFailed) {
		this.lockFailed = lockFailed;
	}

	public List<String> getUnlocked() {
		return unlocked;
	}

	public void setUnlocked(List<String> unlocked) {
		this.unlocked = unlocked;
	}

	public List<String> getUnlockFailed() {
		return unlockFailed;
	}

	public void setUnlockFailed(List<String> unlockFailed) {
		this.unlockFailed = unlockFailed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(Object responseObject) throws DokuWikiResponseException {
		HashMap<String, Object[]> setLockResponse = null;
		try {
			setLockResponse = (HashMap<String, Object[]>) responseObject;
		} catch (ClassCastException e) {
			throw new DokuWikiResponseException(e);
		}

		try {
			locked = getIdsForLockType(setLockResponse, KEY_LOCKED);
			lockFailed = getIdsForLockType(setLockResponse, KEY_LOCK_FAILED);
			unlocked = getIdsForLockType(setLockResponse, KEY_UNLOCKED);
			unlockFailed = getIdsForLockType(setLockResponse, KEY_UNLOCK_FAIL);
		} catch (ClassCastException e) {
			throw new DokuWikiResponseException(e);
		}
	}

	private ArrayList<String> getIdsForLockType(
			HashMap<String, Object[]> pagesObjects, String lockType) {
		Object[] objArray = (Object[]) pagesObjects.get(lockType);
		return getStringList(objArray);
	}

	private ArrayList<String> getStringList(Object[] objectArray) {
		ArrayList<String> list = new ArrayList<String>();

		if (objectArray != null) {
			for (Object obj : objectArray) {
				if (obj != null) {
					list.add(obj.toString());
				}
			}
		}

		return list;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("locked: ").append(locked.size()).append("\n");
		builder.append("lock failed: ").append(lockFailed.size()).append("\n");
		builder.append("unlocked: ").append(unlocked.size()).append("\n");
		builder.append("unlock failed: ").append(unlockFailed.size())
				.append("\n");
		return builder.toString();
	}
}
