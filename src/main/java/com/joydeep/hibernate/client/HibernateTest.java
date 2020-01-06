package com.joydeep.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.joydeep.hibernate.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        UserDetails temp=new UserDetails();
    	temp.setUserName("UserName ");
    	temp.setJoinedDate(new Date());
        temp.setAddress("Address ");
        temp.setDescription("Description ");
        //Temp is still transient
        session.save(temp);
      //Temp is now persistent and tracked by hibernate
        temp.setUserName("UserName updated");
        temp.setUserName("UserName updated new");
        session.getTransaction().commit();
        session.close();
        temp.setUserName("UserName updated new after close session");
        //Temp is now detached and not racked by hibernate since session is closed
	}

}
