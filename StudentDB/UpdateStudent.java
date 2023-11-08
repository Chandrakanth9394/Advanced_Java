package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudent {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		Statement statement = connection.createStatement();
		statement.execute("update student set grade = 'A1' where marks>=90");
		statement.execute("update student set grade = 'B1' where marks<=80");
		statement.execute("update student set grade = 'C1' where marks<=70");
		statement.execute("update student set grade = 'D1' where marks<=60");
		statement.execute("update student set grade = 'E1' where marks<=50");
		connection.close();
		System.out.println("update succesfull!");
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
