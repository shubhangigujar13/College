package com.main;

import java.sql.Connection;
import java.util.Scanner;

import com.DAO.StudentDao;
import com.conn.DBConnect;
import com.entity.Student;

public class UpdateMain {

	public static void main(String[] args) {
		Student student = new Student();
		Scanner sc = new  Scanner(System.in);
		System.out.println("Please Enter Your Roll No.: ");
		int rollno = sc.nextInt();
		
		
		sc.nextLine(); // for string input after integer input 1 emplty space line
		
		System.out.println("Please enter your new name");
		String name = sc.nextLine();
		System.out.println("Please enter your new phno");
		String phno = sc.nextLine();
		System.out.println("Please enter your new address");
		String address = sc.nextLine();

		student.setRollno(rollno);
		student.setSname(name);
		student.setPhno(phno);
		student.setAddress(address);
		
		Connection conn = DBConnect.getConnection();
		StudentDao studentDao = new StudentDao(conn);
		boolean up1 = studentDao.updateStudent(student);
		if(up1)
		{
			System.out.println("Data update successfully...");
		}
		else {
			System.out.println("Student doesnot exits");
		}
	}

}
