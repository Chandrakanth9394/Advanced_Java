//7.get student name with marks >80 and age >22

package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NameStudent {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		Statement statement = connection.createStatement();
		ResultSet a = statement.executeQuery("select name from student where marks>80 and age>22");
		while(a.next())
		{
			System.out.println(a.getString(1));
		}
		connection.close();		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
}
}
