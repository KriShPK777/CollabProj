package CollProj.Backend.Dao;

import java.util.List;

import CollProj.Backend.Model.Friend;
import CollProj.Backend.Model.UserDetail;

public interface FriendDAO 
{
	public List<Friend> showPendingFriendRequests(String username);
	public List<Friend> showFriendList(String username);
	public List<UserDetail> showSuggestedFriends (String username);
	
	public boolean sendFriendRequest(Friend friend);
	public boolean deleteFriendRequest(int friendId);
	public boolean acceptFriendRequest(int friendId);
}
