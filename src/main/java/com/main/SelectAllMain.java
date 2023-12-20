package com.main;

import java.util.ArrayList;

import com.DAO.StudentDao;
import com.conn.DBConnect;
import com.entity.Student;

public class SelectAllMain {

	public static void main(String[] args) {
		StudentDao sDao = new StudentDao(DBConnect.getConnection());

		ArrayList<Student> students = sDao.getAllStudent();
		if (students.isEmpty()) {
			System.out.println("No student is available");
		} else {
			for(Student st: students) {
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

}