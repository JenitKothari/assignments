package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	private static List<Course> courses;
	private static List<Student> students;
	private static List<Teacher> teachers;
	
	public Admin() {
		
		courses = new ArrayList<Course>();
		students = new ArrayList<Student>();
		teachers = new ArrayList<Teacher>();
		initializeTeachers();
	}
	
	private void initializeTeachers() {
		Teacher t1 = new Teacher(
	            1,
	            "Amit Verma",
	            1,
	            "Mumbai",
	            "9876543210",
	            "M.Sc, B.Ed",
	            5
	        );
	        t1.addSubject(1);
	        t1.addSubject(2);
	        t1.addSubject(3);
	        teachers.add(t1);
	        
	        Teacher t2 = new Teacher(
	            2,
	            "Neha Sharma",
	            1,
	            "Pune",
	            "9123456780",
	            "Ph.D",
	            10
	        );
	        t2.addSubject(4);
	        t2.addSubject(5);
	        t2.addSubject(6);
	        teachers.add(t2);
	        
	        Teacher t3 = new Teacher(
	            3,
	            "Ravi Kumar",
	            1,
	            "Delhi",
	            "9988776655",
	            "M.A, B.Ed",
	            7
	        );
	        t3.addSubject(7);
	        t3.addSubject(8);
	        t3.addSubject(9);
	        teachers.add(t3);
	        
	        Teacher t4 = new Teacher(
	            4,
	            "Sneha Joshi",
	            1,
	            "Bangalore",
	            "9012345678",
	            "M.Tech",
	            6
	        );
	        t4.addSubject(10);
	        t4.addSubject(11);
	        t4.addSubject(12);
	        teachers.add(t4);
	        
	        Teacher t5 = new Teacher(
	            5,
	            "Anil Mehta",
	            1,
	            "Hyderabad",
	            "9090909090",
	            "M.Com, B.Ed",
	            8
	        );
	        t5.addSubject(13);
	        t5.addSubject(14);
	        t5.addSubject(15);
	        t5.addSubject(16);
	        teachers.add(t5);
	        
	        Teacher t6 = new Teacher(
	            6,
	            "Priya Singh",
	            1,
	            "Chennai",
	            "9112233445",
	            "M.Sc",
	            4
	        );
	        t6.addSubject(17);
	        t6.addSubject(18);
	        t6.addSubject(19);
	        teachers.add(t6);
	        
	        Teacher t7 = new Teacher(
	            7,
	            "Vikram Das",
	            1,
	            "Kolkata",
	            "9321654987",
	            "Ph.D",
	            12
	        );
	        t7.addSubject(20);
	        t7.addSubject(21);
	        t7.addSubject(22);
	        teachers.add(t7);
	        
	        Teacher t8 = new Teacher(
	            8,
	            "Kiran Rao",
	            1,
	            "Ahmedabad",
	            "9876501234",
	            "M.A",
	            5
	        );
	        t8.addSubject(23);
	        t8.addSubject(24);
	        t8.addSubject(25);
	        teachers.add(t8);
	        
	        Teacher t9 = new Teacher(
	            9,
	            "Manoj Bhatia",
	            1,
	            "Nagpur",
	            "8999988888",
	            "M.Ed",
	            3
	        );
	        t9.addSubject(26);
	        t9.addSubject(27);
	        t9.addSubject(28);
	        teachers.add(t9);
	        
	        Teacher t10 = new Teacher(
	            10,
	            "Divya Kapoor",
	            1,
	            "Jaipur",
	            "8001234567",
	            "M.Sc, Ph.D",
	            11
	        );
	        t10.addSubject(29);
	        t10.addSubject(30);
	        t10.addSubject(31);
	        t10.addSubject(32);
	        teachers.add(t10);
	        
	        Teacher t11 = new Teacher(
	            11,
	            "Sanjay Tiwari",
	            1,
	            "Surat",
	            "8901234560",
	            "M.Com",
	            6
	        );
	        t11.addSubject(33);
	        t11.addSubject(34);
	        teachers.add(t11);
	        
	        Teacher t12 = new Teacher(
	            12,
	            "Pooja Nair",
	            1,
	            "Lucknow",
	            "9555551234",
	            "M.A, B.Ed",
	            7
	        );
	        t12.addSubject(35);
	        t12.addSubject(36);
	        t12.addSubject(37);
	        teachers.add(t12);
	        
	        Teacher t13 = new Teacher(
	            13,
	            "Rahul Khanna",
	            1,
	            "Patna",
	            "9666666666",
	            "Ph.D",
	            9
	        );
	        t13.addSubject(38);
	        t13.addSubject(39);
	        teachers.add(t13);
	        
	        Teacher t14 = new Teacher(
	            14,
	            "Meena Desai",
	            1,
	            "Indore",
	            "9777777777",
	            "M.Sc",
	            4
	        );
	        t14.addSubject(40);
	        t14.addSubject(41);
	        t14.addSubject(42);
	        teachers.add(t14);
	        
	        Teacher t15 = new Teacher(
	            15,
	            "Deepak Patil",
	            1,
	            "Bhopal",
	            "9888888888",
	            "M.A",
	            3
	        );
	        t15.addSubject(43);
	        t15.addSubject(44);
	        teachers.add(t15);
	        
	        Teacher t16 = new Teacher(
	            16,
	            "Sunita Yadav",
	            1,
	            "Kanpur",
	            "9999999999",
	            "M.Ed, Ph.D",
	            13
	        );
	        t16.addSubject(45);
	        t16.addSubject(46);
	        teachers.add(t16);
	        
	        Teacher t17 = new Teacher(
	            17,
	            "Arjun Sethi",
	            1,
	            "Thane",
	            "9000000001",
	            "M.Tech",
	            5
	        );
	        t17.addSubject(47);
	        teachers.add(t17);
	        
	        Teacher t18 = new Teacher(
	            18,
	            "Rekha Pillai",
	            1,
	            "Nashik",
	            "9111111111",
	            "M.Sc, B.Ed",
	            2
	        );
	        t18.addSubject(48);
	        teachers.add(t18);
	        
	        Teacher t19 = new Teacher(
	            19,
	            "Harsh Vora",
	            1,
	            "Amritsar",
	            "9222222222",
	            "M.A",
	            6
	        );
	        t19.addSubject(49);
	        teachers.add(t19);
	        
	        Teacher t20 = new Teacher(
	            20,
	            "Nisha Kulkarni",
	            1,
	            "Rajkot",
	            "9333333333",
	            "M.Com",
	            4
	        );
	        t20.addSubject(50);
	        t20.addSubject(1);
	        teachers.add(t20);
		
	}

	//methods to get the objects by giving its id
	
//	public static Course getCourse(int courseId)
//	{
//		for(Course course : courses)
//		{
//			if(course.getCourseId == courseId)
//				return course;
//		}
//		return null;
//	}
	
//	public static Student getStudent(int studentId)
//	{
//		for(Student student : students)
//		{
//			if(student.getStudentId == studentId)
//				return student;
//		}
//		return null;
//	}
	
	public static Teacher getTeacher(int teacherId)
	{
		for(Teacher teacher : teachers)
		{
			if(teacher.getTeacherId() == teacherId)
				return teacher;
		}
		return null;
	}
	
	//methods to add the objects into their list
	
	public static void addCourse(Course course)
	{
		courses.add(course);
	}
	
	public static void addStudent(Student student)
	{
		students.add(student);
	}
	
	public static void addTeacher(Teacher teacher)
	{
		teachers.add(teacher);
	}
}
