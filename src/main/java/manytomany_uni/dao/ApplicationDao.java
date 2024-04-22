package manytomany_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_uni.dto.User;

public class ApplicationDao {
	
	public EntityManager getManager()
	{
		return Persistence.createEntityManagerFactory("kishor").createEntityManager();
	}
	public void addUser(User user)
	{
		EntityTransaction transaction=getManager().getTransaction();
		transaction.begin();
		getManager().persist(user);
		transaction.commit();
	}
	public User getUser(int id)
	{
		EntityTransaction transaction=getManager().getTransaction();
		User user=getManager().find(User.class,id);
		if(user!=null)
		{
			return user;
		}
		else
		{
			return null;
		}
	}
	public void deleteUser(int id)
	{
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		User user=manager.find(User.class,id);
		if(user!=null)
		{
			transaction.begin();
			manager.remove(user);
			transaction.commit();	
		}
		else
		{
			System.out.println("User not found");
		}
	}

}
