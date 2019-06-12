package com.coll.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.ProfilePicture;
@Repository
public class ProfilePictureDAOImpl implements ProfilePictureDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void save(ProfilePicture profilePicture) {
		System.out.println("I am in save method-profile picture");
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		System.out.println("Iimage saved to database");
	}

	@Override
	public ProfilePicture getProfilePicture(String username) {
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class,username);
		return profilePicture;
	}
	

}
