package com.main;

import java.sql.Connection;
import java.util.Scanner;
import com.DAO.StudentDao;
import com.conn.DBConnect;
import com.entity.Student;

public class InsertMain {

	public static void main(String[] args) {

		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your name");
		String name = sc.nextLine();
		System.out.println("Please enter your phno");
		String phno = sc.nextLine();
		System.out.println("Please enter your address");
		String address = sc.nextLine();

		student.setSname(name);
		student.setPhno(phno);
		student.setAddress(address);

		Connection conn = DBConnect.getConnection();

		StudentDao studentDao = new StudentDao(conn);

//		StudentDao studentDao = new StudentDao(DBConnect.getConnection());
		
		boolean ins1 = studentDao.insertStudent(student);
		
		if(ins1) {
			System.out.println("Data inserted successfully..");
		}else {
			System.out.println("Something bad happens on server..");
			
			
		}
	}

}