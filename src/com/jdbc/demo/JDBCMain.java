package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMain {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String query = "SELECT * FROM STUDENT_DATA";
		String url = "JDBC:mysql://localhost:3306/STUDENT_DETAILS";
		String user = "root";
		String password = "root";
		
		String query2 = "SELECT * FROM STUDENT_DATA where STUDENT_ID = 18";
		String insertQuery ="INSERT INTO STUDENT_DATA(\r\n"
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
				+ "VALUES('KARTHIK SINGH',21,'KARTHIK6@GMAIL.COM',965662144,'M',"
				+ "'B.TECH','CSE',2025,8.5,'MRIET','REGULAR','HYDERABAD','TELANAGANA','ADMIN') ";
		String countQuery ="SELECT STUDENT_NAME,QUALIFICATION,COUNT(BRANCH)"
				+ "FROM STUDENT_DATA "
				+ "GROUP BY STUDENT_NAME,QUALIFICATION";
		try {
			connection = DriverManager.getConnection(url,user,password);
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(countQuery);
			while(resultSet.next()) {
				System.out.println("Student_id: "+resultSet.getString(1));
				System.out.println("Student_Name: "+resultSet.getString(2));
//				System.out.println("Student_Age: "+resultSet.getString(3));
//				System.out.println("Student_Email: "+resultSet.getString(4));
			}
//			statement.execute(insertQuery);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
