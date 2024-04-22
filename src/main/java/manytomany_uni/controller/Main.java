package manytomany_uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_uni.dao.ApplicationDao;
import manytomany_uni.dto.Application;
import manytomany_uni.dto.User;

public class Main {
	static int id=5;

	public static void main(String[] args) {
		ApplicationDao dao=new ApplicationDao();
		
		Scanner scanner=new Scanner(System.in);
		Application ap1=new Application();
		ap1.setId(101);
		ap1.setName("Facebook");
		ap1.setCompany("Meta");
		
		Application ap2=new Application();
		ap2.setId(102);
		ap2.setName("Instagram");
		ap2.setCompany("Meta");
		
		Application ap3=new Application();
		ap3.setId(103);
		ap3.setName("Whatsapp");
		ap3.setCompany("Meta");
		
		Application ap4=new Application();
		ap4.setId(104);
		ap4.setName("Snapchat");
		ap4.setCompany("Nilesh");
		
		
		System.out.println("Press \n1.Add User \n2.Get User \n3.Delete User");
		switch (scanner.nextInt()) {
		case 1:{
			User u5=new User();
			u5.setId(id);
			u5.setName("Omkar");
			u5.setPhone(9874589696l);
			u5.setAddress("Nilanga");
			List<Application>app=new ArrayList<Application>();
			app.add(ap2);
			app.add(ap3);
			u5.setApp(app);
			dao.addUser(u5);
			id++;	
		}break;
		case 2:{
			System.out.println("Enter User id");
			User user=dao.getUser(scanner.nextInt());
			if(user!=null)
			{
				System.out.println(user);
			}
			else
			{
				System.out.println("User not found");
			}
		}break;

		default:
			break;
		}
		
				

	}

}
