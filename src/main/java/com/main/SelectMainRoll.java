package com.main;

import java.util.Scanner;

import com.DAO.StudentDao;
import com.conn.DBConnect;
import com.entity.Student;

public class SelectMainRoll {
	public static void main(String[] args) {
		
		StudentDao sDao = new StudentDao(DBConnect.getConnection());
		
//		sDao.getStudentByRollNo(3);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter rollno: ");
		int rollno = sc.nextInt();
		
		Student st = sDao.getStudentByRollNo(rollno);
		if(st == null) {
			System.out.println("Student doesn't exists");
		}else {
			System.out.println("-------------------------------------------");
			System.out.println("~~Student Information~~");
			System.out.println("-------------------------------------------");
			System.out.println("Rollno: "+ st.getRollno());
			System.out.println("Name: "+st.getSname());
			System.out.println("Phone: "+st.getPhno());
			System.out.println("Address: " + st.getAddress());
			System.out.println("Addmision Date: "+st.getAddDate());
			System.out.println("Last Update: "+st.getLastUpdate());
			System.out.println("-------------------------------------------");
		}
	}
}