package weekop.dao;

import weekop.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long> {

	public Vote getVoteByUserIdDiscoveryId(long userid, long discoveryid);
}
