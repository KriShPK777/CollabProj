package com.pk.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pk.Model.Friend;
import com.pk.Model.UserDetail;

@Repository ("FriendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Friend> showPendingFriendRequests(String username) 
	{
		
		Session session=sessionFactory.openSession();
		Query query=(Query) session.createQuery("from friend where friendusername=:funame) and status='P'");
		query.setParameter("funame", username);
		List<Friend> pendingFriendList=(List<Friend>)query.list();
		return pendingFriendList;
	}

	@Override
	public List<Friend> showFriendList(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=(Query) session.createQuery("from friend where (username=:uname or friendusername=:funame) and status='A'");
		query.setParameter("uname", username);
		query.setParameter("funame", username);
		List<Friend> friendList=(List<Friend>)query.list();
		return friendList;
	}

	@Override
	public List<UserDetail> showSuggestedFriends(String username) 
	{
		Session session=sessionFactory.openSession();
	    Query sqlquery=(Query) session.createQuery("select username UserDetail where username not in(select friendusername from Friend where username='"+username+"') where (friendusername='john' and status='A') and (username!='sam'");
		List<String> listUsers=(List<String>)sqlquery.list();
		
		ArrayList<UserDetail> listUserDetail=new ArrayList<UserDetail>();
		int count=0;
		while(count<listUsers.size())
		{
			UserDetail user=(UserDetail) session.get(UserDetail.class, listUsers.get(count).toString().trim());
			listUserDetail.add(user);
			count++;
		} 
		session.close();		
		return listUserDetail;
	}

	@Override
	public boolean sendFriendRequest(Friend friend) 
	{
		try
		{
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
}

	@Override
	public boolean deleteFriendRequest(int friendId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=(Friend) session.get(Friend.class, friendId);
			session.close();
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
}

	@Override
	public boolean acceptFriendRequest(int friendId) 
	{
		try
		{
		Session session=sessionFactory.openSession();
		Friend friend=(Friend) session.get(Friend.class, friendId);
		session.close();
		friend.setStatus("A");
		sessionFactory.getCurrentSession().update(friend);
		return true;
	    }
	    catch(Exception e)
	    {
        return false;
	}
}
}



