package com.pk.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pk.Model.ProfilePicture;

@Repository ("ProfilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO
{ 
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public boolean addProfilePicture(ProfilePicture profilePicture) 
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		return true;
	}

	@Override
	public ProfilePicture getProfilePicture(String username) 
	{
		Session session=sessionFactory.openSession();
		ProfilePicture profilePic = (ProfilePicture)session.get(ProfilePicture.class, username);
		session.close();
		return profilePic;
	}
    
}
