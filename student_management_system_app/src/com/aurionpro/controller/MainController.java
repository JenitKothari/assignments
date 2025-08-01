package com.aurionpro.controller;

import java.util.Scanner;

public class MainController {

	static Scanner scanner = new Scanner(System.in);
	public static void start() {
		int choice = 0;
		while(true)
		{
			System.out.println("1. Student Managenent");
			System.out.println("2. Teacher Managenent");
			System.out.println("3. Course Managenent");
			System.out.println("4. Exit");
			choice = scanner.nextInt();
			switch(choice)
			{
			case 1:
				StudentController.studentMenu();
				break;
			case 2:
				TeacherController.teacherMenu();
				break;
			case 3:
				CourseController.courseMenu();
				break;
			case 4:
				System.out.println("Exiting.");
				return;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

}
