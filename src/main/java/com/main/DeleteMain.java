package com.main;

import java.util.Scanner;

import com.DAO.StudentDao;
import com.conn.DBConnect;

public class DeleteMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter rollno ");
		int rollno = sc.nextInt();
		
		StudentDao sDao = new StudentDao(DBConnect.getConnection());
		
		boolean del1 = sDao.deleteStudent(rollno);
		
		if(del1) {
			System.out.println("Student successfully Removed");
		}else {
			System.out.println("Student doesn't exists");
		}

	}

}