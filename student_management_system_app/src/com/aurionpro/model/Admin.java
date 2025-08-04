package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	private static List<Course> courses = new ArrayList<Course>();
	private static List<Student> students = new ArrayList<Student>();
	private static List<Teacher> teachers = new ArrayList<Teacher>();

	public Admin() {

	}

	// To initialise teachers
	static {
		
		// Teachers
		Teacher t1 = new Teacher(1, "Amit Verma", 1, "Mumbai", "9876543210", "M.Sc, B.Ed", 5);
		t1.addSubject(1);
		t1.addSubject(2);
		t1.addSubject(3);
		teachers.add(t1);

		Teacher t2 = new Teacher(2, "Neha Sharma", 1, "Pune", "9123456780", "Ph.D", 10);
		t2.addSubject(4);
		t2.addSubject(5);
		t2.addSubject(6);
		teachers.add(t2);

		Teacher t3 = new Teacher(3, "Ravi Kumar", 1, "Delhi", "9988776655", "M.A, B.Ed", 7);
		t3.addSubject(7);
		t3.addSubject(8);
		t3.addSubject(9);
		teachers.add(t3);

		Teacher t4 = new Teacher(4, "Sneha Joshi", 1, "Bangalore", "9012345678", "M.Tech", 6);
		t4.addSubject(10);
		t4.addSubject(11);
		t4.addSubject(12);
		teachers.add(t4);

		Teacher t5 = new Teacher(5, "Anil Mehta", 1, "Hyderabad", "9090909090", "M.Com, B.Ed", 8);
		t5.addSubject(13);
		t5.addSubject(14);
		t5.addSubject(15);
		t5.addSubject(16);
		teachers.add(t5);

		Teacher t6 = new Teacher(6, "Priya Singh", 1, "Chennai", "9112233445", "M.Sc", 4);
		t6.addSubject(17);
		t6.addSubject(18);
		t6.addSubject(19);
		teachers.add(t6);

		Teacher t7 = new Teacher(7, "Vikram Das", 1, "Kolkata", "9321654987", "Ph.D", 12);
		t7.addSubject(20);
		t7.addSubject(21);
		t7.addSubject(22);
		teachers.add(t7);

		Teacher t8 = new Teacher(8, "Kiran Rao", 1, "Ahmedabad", "9876501234", "M.A", 5);
		t8.addSubject(23);
		t8.addSubject(24);
		t8.addSubject(25);
		teachers.add(t8);

		Teacher t9 = new Teacher(9, "Manoj Bhatia", 1, "Nagpur", "8999988888", "M.Ed", 3);
		t9.addSubject(26);
		t9.addSubject(27);
		t9.addSubject(28);
		teachers.add(t9);

		Teacher t10 = new Teacher(10, "Divya Kapoor", 1, "Jaipur", "8001234567", "M.Sc, Ph.D", 11);
		t10.addSubject(29);
		t10.addSubject(30);
		t10.addSubject(31);
		t10.addSubject(32);
		teachers.add(t10);

		Teacher t11 = new Teacher(11, "Sanjay Tiwari", 1, "Surat", "8901234560", "M.Com", 6);
		t11.addSubject(33);
		t11.addSubject(34);
		teachers.add(t11);

		Teacher t12 = new Teacher(12, "Pooja Nair", 1, "Lucknow", "9555551234", "M.A, B.Ed", 7);
		t12.addSubject(35);
		t12.addSubject(36);
		t12.addSubject(37);
		teachers.add(t12);

		Teacher t13 = new Teacher(13, "Rahul Khanna", 1, "Patna", "9666666666", "Ph.D", 9);
		t13.addSubject(38);
		t13.addSubject(39);
		teachers.add(t13);

		Teacher t14 = new Teacher(14, "Meena Desai", 1, "Indore", "9777777777", "M.Sc", 4);
		t14.addSubject(40);
		t14.addSubject(41);
		t14.addSubject(42);
		teachers.add(t14);

		Teacher t15 = new Teacher(15, "Deepak Patil", 1, "Bhopal", "9888888888", "M.A", 3);
		t15.addSubject(43);
		t15.addSubject(44);
		teachers.add(t15);

		Teacher t16 = new Teacher(16, "Sunita Yadav", 1, "Kanpur", "9999999999", "M.Ed, Ph.D", 13);
		t16.addSubject(45);
		t16.addSubject(46);
		teachers.add(t16);

		Teacher t17 = new Teacher(17, "Arjun Sethi", 1, "Thane", "9000000001", "M.Tech", 5);
		t17.addSubject(47);
		teachers.add(t17);

		Teacher t18 = new Teacher(18, "Rekha Pillai", 1, "Nashik", "9111111111", "M.Sc, B.Ed", 2);
		t18.addSubject(48);
		teachers.add(t18);

		Teacher t19 = new Teacher(19, "Harsh Vora", 1, "Amritsar", "9222222222", "M.A", 6);
		t19.addSubject(49);
		teachers.add(t19);

		Teacher t20 = new Teacher(20, "Nisha Kulkarni", 1, "Rajkot", "9333333333", "M.Com", 4);
		t20.addSubject(50);
		t20.addSubject(1);
		teachers.add(t20);

		
		//Courses
		Course c1 = new Course(1, "Computer Science", true, 85000.0);
		c1.addSubject(1);
		c1.addSubject(2);
		c1.addSubject(3);
		c1.addSubject(4);
		c1.addSubject(5);
		courses.add(c1);
		 
		Course c2 = new Course(2, "Information Tech", true, 80000.0);
		c2.addSubject(6);
		c2.addSubject(7);
		c2.addSubject(8);
		c2.addSubject(9);
		c2.addSubject(10);
		courses.add(c2);
		 
		Course c3 = new Course(3, "E&TC Engineering", true, 78000.0);
		c3.addSubject(11);
		c3.addSubject(12);
		c3.addSubject(13);
		c3.addSubject(14);
		c3.addSubject(15);
		courses.add(c3);
		 
		Course c4 = new Course(4, "Mechanical Engg", true, 76000.0);
		c4.addSubject(16);
		c4.addSubject(17);
		c4.addSubject(18);
		c4.addSubject(19);
		c4.addSubject(20);
		courses.add(c4);
		 
		Course c5 = new Course(5, "Civil Engineering", true, 75000.0);
		c5.addSubject(21);
		c5.addSubject(22);
		c5.addSubject(23);
		c5.addSubject(24);
		c5.addSubject(25);
		courses.add(c5);
		 
		Course c6 = new Course(6, "Automobile Engg", true, 72000.0);
		c6.addSubject(26);
		c6.addSubject(27);
		c6.addSubject(28);
		c6.addSubject(29);
		c6.addSubject(30);
		courses.add(c6);
		 
		Course c7 = new Course(7, "Electrical Engg", true, 70000.0);
		c7.addSubject(31);
		c7.addSubject(32);
		c7.addSubject(33);
		c7.addSubject(34);
		c7.addSubject(35);
		courses.add(c7);
		 
		Course c8 = new Course(8, "Data Science", true, 95000.0);
		c8.addSubject(36);
		c8.addSubject(37);
		c8.addSubject(38);
		c8.addSubject(39);
		c8.addSubject(40);
		courses.add(c8);
		 
		Course c9 = new Course(9, "AI & ML", true, 98000.0);
		c9.addSubject(41);
		c9.addSubject(42);
		c9.addSubject(43);
		c9.addSubject(44);
		c9.addSubject(45);
		courses.add(c9);
		 
		Course c10 = new Course(10, "Cyber Security", true, 90000.0);
		c10.addSubject(46);
		c10.addSubject(47);
		c10.addSubject(48);
		c10.addSubject(49);
		c10.addSubject(50);
		courses.add(c10);
		
		// Students
		Student s1 = new Student(1, 1001, "Aarav Mehta", 20, 0.00, true, "Mumbai", "9876543210");

		students.add(s1);

		Student s2 = new Student(2, 1002, "Isha Desai", 21, 0.00, true, "Pune", "9123456780");

		students.add(s2);

		Student s3 = new Student(3, 1003, "Rohan Sharma", 19, 0.00, true, "Delhi", "9988776655");

		students.add(s3);

		Student s4 = new Student(4, 1004, "Sneha Patil", 22, 0.00, true, "Bangalore", "9090909090");

		students.add(s4);

		Student s5 = new Student(5, 1005, "Kunal Verma", 20, 0.00, true, "Hyderabad", "9871234567");

		students.add(s5);

		Student s6 = new Student(6, 1006, "Meera Joshi", 18, 0.00, true, "Chennai", "9765432109");

		students.add(s6);

		Student s7 = new Student(7, 1007, "Aditya Rao", 23, 0.00, true, "Ahmedabad", "9654321098");

		students.add(s7);

		Student s8 = new Student(8, 1008, "Nisha Kulkarni", 21, 0.00, true, "Kolkata", "9543210987");

		students.add(s8);

		Student s9 = new Student(9, 1009, "Yash Tiwari", 20, 0.00, true, "Surat", "9432109876");

		students.add(s9);

		Student s10 = new Student(10, 1010, "Priti Salunkhe", 22, 0.00, true, "Jaipur", "9321098765");

		students.add(s10);

		Student s11 = new Student(11, 1011, "Varun Nair", 24, 0.00, true, "Lucknow", "9210987654");

		students.add(s11);

		Student s12 = new Student(12, 1012, "Divya Shetty", 19, 0.00, true, "Bhopal", "9109876543");

		students.add(s12);

		Student s13 = new Student(13, 1013, "Ritik Jain", 20, 0.00, true, "Indore", "9988776654");

		students.add(s13);

		Student s14 = new Student(14, 1014, "Shruti Bhatt", 21, 0.00, true, "Chandigarh", "9877665544");

		students.add(s14);

		Student s15 = new Student(15, 1015, "Siddharth Khanna", 22, 0.00, true, "Patna", "9766554433");

		students.add(s15);

		Student s16 = new Student(16, 1016, "Tanvi Waghmare", 20, 0.00, true, "Kanpur", "9655443322");

		students.add(s16);

		Student s17 = new Student(17, 1017, "Dev Mehta", 18, 0.00, true, "Nashik", "9544332211");

		students.add(s17);

		Student s18 = new Student(18, 1018, "Kavya Ghosh", 23, 0.00, true, "Thane", "9433221100");

		students.add(s18);

		Student s19 = new Student(19, 1019, "Aman Sheikh", 21, 0.00, true, "Vadodara", "9322110099");

		students.add(s19);

		Student s20 = new Student(20, 1020, "Simran Kaur", 22, 0.00, true, "Nagpur", "9211009988");

		students.add(s20);

		Student s21 = new Student(21, 1021, "Ishaan Pandey", 20, 0.00, true, "Amritsar", "9001234567");

		students.add(s21);

		Student s22 = new Student(22, 1022, "Riya Shah", 19, 0.00, true, "Guwahati", "9888888888");

		students.add(s22);

		Student s23 = new Student(23, 1023, "Nikhil Agrawal", 24, 0.00, true, "Ranchi", "9777777777");

		students.add(s23);

		Student s24 = new Student(24, 1024, "Ananya Rane", 18, 0.00, true, "Coimbatore", "9666666666");

		students.add(s24);

		Student s25 = new Student(25, 1025, "Parth Gokhale", 23, 0.00, true, "Mysore", "9555555555");

		students.add(s25);

		Student s26 = new Student(26, 1026, "Mitali Zaveri", 21, 0.00, true, "Raipur", "9444444444");

		students.add(s26);

		Student s27 = new Student(27, 1027, "Raghav Malhotra", 22, 0.00, true, "Noida", "9333333333");

		students.add(s27);

		Student s28 = new Student(28, 1028, "Pooja Sawant", 20, 0.00, true, "Gwalior", "9222222222");

		students.add(s28);

		Student s29 = new Student(29, 1029, "Omkar Jadhav", 18, 0.00, true, "Jodhpur", "9111111111");

		students.add(s29);

		Student s30 = new Student(30, 1030, "Neelam Dey", 21, 0.00, true, "Vijayawada", "9000000001");

		students.add(s30);

		Student s31 = new Student(31, 1031, "Tushar Banerjee", 20, 0.00, true, "Agra", "9898989898");

		students.add(s31);

		Student s32 = new Student(32, 1032, "Snehal Khedekar", 19, 0.00, true, "Meerut", "9797979797");

		students.add(s32);

		Student s33 = new Student(33, 1033, "Vikram Iyer", 22, 0.00, true, "Jabalpur", "9696969696");

		students.add(s33);

		Student s34 = new Student(34, 1034, "Kritika More", 23, 0.00, true, "Udaipur", "9595959595");

		students.add(s34);

		Student s35 = new Student(35, 1035, "Abhishek Bhonsle", 21, 0.00, true, "Ajmer", "9494949494");

		students.add(s35);

		Student s36 = new Student(36, 1036, "Disha Nambiar", 20, 0.00, true, "Solapur", "9393939393");

		students.add(s36);

		Student s37 = new Student(37, 1037, "Manav Khatri", 24, 0.00, true, "Bareilly", "9292929292");

		students.add(s37);

		Student s38 = new Student(38, 1038, "Saumya Pawar", 18, 0.00, true, "Panaji", "9191919191");

		students.add(s38);

		Student s39 = new Student(39, 1039, "Yamini Dutta", 22, 0.00, true, "Shillong", "9090909012");

		students.add(s39);

		Student s40 = new Student(40, 1040, "Jayant Lobo", 20, 0.00, true, "Aligarh", "8989898989");

		students.add(s40);

		Student s41 = new Student(41, 1041, "Trisha Kotian", 21, 0.00, true, "Hubli", "8888888888");

		students.add(s41);

		Student s42 = new Student(42, 1042, "Zaid Khan", 23, 0.00, true, "Belgaum", "8787878787");

		students.add(s42);

		Student s43 = new Student(43, 1043, "Nikita Barot", 19, 0.00, true, "Jhansi", "8686868686");

		students.add(s43);

		Student s44 = new Student(44, 1044, "Rahul Kumbhar", 22, 0.00, true, "Dhanbad", "8585858585");

		students.add(s44);

		Student s45 = new Student(45, 1045, "Sonal Kadam", 20, 0.00, true, "Bhavnagar", "8484848484");

		students.add(s45);

		Student s46 = new Student(46, 1046, "Aakash Wani", 21, 0.00, true, "Kolhapur", "8383838383");

		students.add(s46);

		Student s47 = new Student(47, 1047, "Reema Pansare", 24, 0.00, true, "Nanded", "8282828282");

		students.add(s47);

		Student s48 = new Student(48, 1048, "Kiran Bhosale", 20, 0.00, true, "Jamnagar", "8181818181");

		students.add(s48);

		Student s49 = new Student(49, 1049, "Jaya Koli", 22, 0.00, true, "Ujjain", "8080808080");

		students.add(s49);

		Student s50 = new Student(50, 1050, "Harshita Salvi", 19, 0.00, true, "Silchar", "7979797979");

		students.add(s50);

		 
	}

	// methods to get the objects by giving its id

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

	public static Teacher getTeacher(int teacherId) {
		for (Teacher teacher : teachers) {
			if (teacher.getTeacherId() == teacherId)
				return teacher;
		}
		return null;
	}

	// methods to add the objects into their list

	public static void addCourse(Course course) {
		courses.add(course);
	}

	public static void addStudent(Student student) {
		students.add(student);
	}

	public static void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
}
