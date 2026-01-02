package com.jdbc.prepapredStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementsMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		//prepared Statement
		PreparedStatement preparedStatement = null;
		
		//Connection SetUp
		String url = "JDBC:mysql://localhost:3306/STUDENT_DETAILS";
		String user = "root";
		String password = "root";
		
		//queries
		String selectAllData = "Select * from student_data";
		String selectData = "select STUDENT_NAME from student_data where STUDENT_ID= ?";
		String insertData ="INSERT INTO STUDENT_DATA(\r\n"
				+ "STUDENT_NAME,\r\n"
				+ "STUDENT_AGE,\r\n"
				+ "STUDENT_EMAIL,\r\n"
				+ "MOBILE_NUMBER,\r\n"
				+ "GENDER,\r\n"
				+ "QUALIFICATION,\r\n"
				+ "BRANCH,\r\n"
				+ "PASSED_OUT_YEAR,\r\n"
				+ "GRADE_POINTS,\r\n"
				+ "COLLEGE_NAME,\r\n"
				+ "STUDENT_TYPE,\r\n"
				+ "CITY,\r\n"
				+ "STATE,\r\n"
				+ "ADDED_BY\r\n"
				+ ")\r\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			connection = DriverManager.getConnection(url,user,password);
			preparedStatement  = connection.prepareStatement(selectData);
			preparedStatement .setLong(1,2);
			if( preparedStatement.execute()) {
				System.out.println("Successfully Fetched");
			}
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Student_Name: "+ resultSet.getString(1));
//				System.out.println("Student_Name: "+ resultSet.getString(2));
			}
//			 System.out.println(resultSet);
			//
			preparedStatement = connection.prepareStatement(insertData);
			//Inserting Data Dynamically
			System.out.println("Enter The Student Name:");
			String name = sc.next();
			preparedStatement.setString(1,name);
			System.out.println("Enter The Student Age:");
			Long age = sc.nextLong();
			preparedStatement.setLong(2,age);
			System.out.println("Enter The Student Email:");
			String email = sc.next();
			preparedStatement.setString(3, email);
			System.out.println("Enter The Student Mobile Number:");
			Long mobileNumber = sc.nextLong();
			preparedStatement.setLong(4, mobileNumber);
			System.out.println("Enter The Student Gender:");
			String gender = sc.next();
			preparedStatement.setString(5, gender);
			System.out.println("Enter The Student Qualification:");
			String degree = sc.next();
			preparedStatement.setString(6, degree);
			System.out.println("Enter The Student branch:");
			String branch = sc.next();
			preparedStatement.setString(7, branch);
			System.out.println("Enter The Student Year of pass:");
			int year= sc.nextInt();
			preparedStatement.setInt(8, year);
			System.out.println("Enter The Student Grade:");
			Float grade = sc.nextFloat();
			preparedStatement.setFloat(9, grade);
			System.out.println("Enter The Student College Name:");
			sc.next();
			String college_name = sc.nextLine();
			preparedStatement.setString(10, college_name);
			System.out.println("Enter The Student Type:");
			String type= sc.next();
			preparedStatement.setString(11, type);
			System.out.println("Enter The Student CIty:");
			String city = sc.next();
			preparedStatement.setString(12, city);
			System.out.println("Enter The Student state:");
			sc.next();
			String state = sc.nextLine();
			preparedStatement.setString(13, state);
			System.out.println("who added:");
			String addedBy = sc.nextLine();
			preparedStatement.setString(14, addedBy);
			if(preparedStatement.execute()) {
				System.out.println("Successfully Inserted Data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
