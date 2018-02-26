package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.ProfilePicture;
@Repository
public class ProfilePictureDaoImpl implements ProfilePictureDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void saveProfilePicture(ProfilePicture profilePicture) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		session.close();
		
	}

	public ProfilePicture getProfilePicture(String email) {
		Session session=sessionFactory.openSession();
		
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, email);
		session.close();
		return profilePicture;
	}

}
