package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;
@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<User> suggestedUsers(String email) 
	{
		
		Session session=sessionFactory.getCurrentSession();
		String queryString=("select * from USER_table where email in " 
							 					+"(select email from USER_table where email!=? "
												+"minus "
												+"(select toId_email from friends where fromId_email=?"
												+"union "
												+"select fromId_email from friends where toId_email=? ))");
		SQLQuery query=session.createSQLQuery(queryString);
		
		query.setString(0,email);
		query.setString(1,email);
		query.setString(2, email);
		query.addEntity(User.class);
		
		List<User> suggestedUsers=query.list();
		
		return suggestedUsers;
		
	}
	
	/*public void friendRequest(String fromUsername, String toUsername){
		Session session=sessionFactory.openSession();
		Friend friend=new Friend();
		friend.setFromId(fromUsername);
		friend.setToId(toUsername);
		friend.setStatus('p');
		session.save(friend);
		session.flush();
		session.close();
	}

	
	public List<Friend> listOfPendingRequest(String toUsername)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where toId=? and status=?");
		query.setString(0, toUsername);
		query.setCharacter(1, 'p');
		List<Friend> pendingRequests=query.list();
		session.close();
		return pendingRequests;
	}

 public void updatePendingRequest(String fromId, String toId, char status) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update Friend set status=? where fromId = ? and toId=? ");
		query.setCharacter(0, status);
		query.setString(1, fromId);
		query.setString(2, toId);
		query.executeUpdate();
		session.flush();
		session.close();
	}
    
	public List<Friend> listOfFriends(String Username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where(fromId=? or toId=?) and status=?");
		query.setString(0, Username);
		query.setString(1, Username);
		query.setCharacter(2, 'A');
		List<Friend> friends=query.list();
		session.close();
		return friends;
	}
*/	
}