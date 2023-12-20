package com.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.DAO.StudentDao;
import com.conn.DBConnect;
import com.entity.Student;							

public class DriverClass {
	public static void main(String[] args) {
		/*
		 * Connection conn= DBConnect.getConnection(); System.out.println(conn);
		 */

		boolean status = true;
		int rollno, choice;
		String name, phno, address;
		Scanner sc = new Scanner(System.in);
		StudentDao sDao = new StudentDao(DBConnect.getConnection());

		while (status) {

			System.out.println("\n\n-----------------------------------------------");
			System.out.println("Please press from following option: ");
			System.out.println("-----------------------------------------------");
			System.out.println("1. Insert New Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Get Student By Roll Number");
			System.out.println("5. Get All Students");
			System.out.println("6. Exit");
			System.out.println("-----------------------------------------------");
			choice = sc.nextInt();

			switch (choice) {
			case 1:

				System.out.println("Please enter your name: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println("Please enter your phone num: ");
				phno = sc.nextLine();
				System.out.println("Please enter your address: ");
				address = sc.nextLine();
				Student s1 = new Student();
				s1.setSname(name);
				s1.setPhno(phno);
				s1.setAddress(address);

				boolean c1 = sDao.insertStudent(s1);
				if (c1) {
					System.out.println("Data inserted successfully..");
				} else {
					System.out.println("Something wrong happen on server..");
				}
				break;
			case 2:
				System.out.println("Please enter your roll number");
				rollno = sc.nextInt();
				System.out.println("Please enter your new name: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println("Please enter your new phone num: ");
				phno = sc.nextLine();
				System.out.println("Please enter your new address: ");
				address = sc.nextLine();
				Student s2 = new Student();
				s2.setRollno(rollno);
				s2.setSname(name);
				s2.setPhno(phno);
				s2.setAddress(address);
				boolean c2 = sDao.updateStudent(s2);
				if (c2) {
					System.out.println("Data updated successfully..");
				} else {
					System.out.println("Student doesn't exists. Pls check your roll num..");
				}

				break;
			case 3:
				System.out.println("Please enter your roll number");
				rollno = sc.nextInt();
				boolean c3 = sDao.deleteStudent(rollno);
				if (c3) {
					System.out.println("Data deleted successfully..");
				} else {
					System.out.println("Student doesn't exists. Pls check your roll num..");
				}

				break;
			case 4:
				System.out.println("Please enter your roll number");
				rollno = sc.nextInt();
				Student st = sDao.getStudentByRollNo(rollno);
				if (st == null) {
					System.out.println("Student doesn't exists");
				} else {
					System.out.println("-----------------------------------------------");
					System.out.println("~~Student Information~~");
					System.out.println("-----------------------------------------------");
					System.out.println("Rollno: " + st.getRollno());
					System.out.println("Name: " + st.getSname());
					System.out.println("Phone: " + st.getPhno());
					System.out.println("Address: " + st.getAddress());
					System.out.println("Addmision Date: " + st.getAddDate());
					System.out.println("Last Update: " + st.getLastUpdate());
					System.out.println("-----------------------------------------------");
				}
				break;
			case 5:
				ArrayList<Student> students = sDao.getAllStudent();
				if (students.isEmpty()) {
					System.out.println("No student is available");
				} else {
					for (Student st1 : students) {
						System.out.println("-----------------------------------------------");
						System.out.println("~~Student Information~~");
						System.out.println("-----------------------------------------------");
						System.out.println("Rollno: " + st1.getRollno());
						System.out.println("Name: " + st1.getSname());
						System.out.println("Phone: " + st1.getPhno());
						System.out.println("Address: " + st1.getAddress());
						System.out.println("Addmision Date: " + st1.getAddDate());
						System.out.println("Last Update: " + st1.getLastUpdate());
						System.out.println("-----------------------------------------------");

					}
				}

				break;
			case 6:
				System.out.println("\n-----------------------------------------------");

				System.out.println("Thanks. Visit Again!!!");
				System.out.println("-----------------------------------------------");

				status = false;

				break;

			default:

			}

		}
	}

}