//1.Create a database studentdb
//2.create a table student(id,name,age,marks,gender,grade)
//3.Insert 5 records using class Student
//4.Display all records
//5.delete student with marks less than 60
//6.update student grade based on marks
//7.get student name with marks >80 and age >22

package com.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayStudent {
public static void main(String[] args) {
	try {		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		Statement statement = connection.createStatement();
		ResultSet a= statement.executeQuery("select * from student");
		System.out.println("id name age marks gender grade");
		while(a.next())
		{
			System.out.print(a.getInt(1)+" ");
			System.out.print(a.getString(2)+" ");
			System.out.print(a.getInt(3)+" ");
			System.out.print(a.getInt(4)+" ");
			System.out.print(a.getString(5)+" ");
			System.out.println(a.getString(6));
			
		}
		connection.close();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
}
}
