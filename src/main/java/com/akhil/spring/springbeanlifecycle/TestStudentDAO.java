package com.akhil.spring.springbeanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.akhil.spring.springbeanlifecycle.dao.usingannotation.Hi;
import com.akhil.spring.springbeanlifecycle.dao.usinginterface.Hello;
import com.akhil.spring.springbeanlifecycle.dao.usingxml.StudentDAO;

public class TestStudentDAO {

	public static void main(String[] args) {
//		StudentDAO studentDAO=new StudentDAO();
		
//		try {
//			studentDAO.getAllRows();
//			System.out.println("*****************");
//			studentDAO.deletStudent(2);
//			System.out.println("*****************");
//			studentDAO.getAllRows();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		StudentDAO studentDAO= context.getBean("studentDAO",StudentDAO.class);
		studentDAO.getAllRows();
		Hello hello= context.getBean("hello",Hello.class);
		Hi hi= context.getBean("hi",Hi.class);
		((ClassPathXmlApplicationContext)context).close();
		
		
	}
}
