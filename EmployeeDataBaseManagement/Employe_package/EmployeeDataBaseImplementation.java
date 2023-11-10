package employe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDataBaseImplementation implements EmployeDataBase {
	Scanner sc = new Scanner(System.in);

	@Override
	public void addEmployee() {
		System.out.println("Enter the employee slno");
		int slno = sc.nextInt();
		System.out.println("Enter the employee name");
		String name = sc.next();
		System.out.println("Enter the employee age");
		int age = sc.nextInt();
		System.out.println("Enter the employee salary");
		double salary = sc.nextDouble();
		System.out.println("Enter the employee designation");
		String designation = sc.next();
		Employe employee = new Employe(slno, name, age, salary, designation);
		String id = employee.getId();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dname", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			preparedStatement.setInt(1,slno);
			preparedStatement.setString(2,id);
			preparedStatement.setString(3,name);
			preparedStatement.setInt(4,age);
			preparedStatement.setDouble(5,salary);
			preparedStatement.setString(6,designation);
			preparedStatement.execute();
			System.out.println("Employee records inserted "+ "/n Your id is "+id);
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void displayEmployee() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayAllEmployees() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEmployee() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub

	}

	@Override
	public void coundNoEmployee() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getEmployeeWithHighestSalary() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getEmployeeWithLowestSalary() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAllEmployes() {
		// TODO Auto-generated method stub

	}

}
