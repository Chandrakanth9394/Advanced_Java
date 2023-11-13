package employe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Exception.DataNotFoundException;
import Exception.EmployeNotFoundException;

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
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into employedatabase values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, slno);
			preparedStatement.setString(2, id);
			preparedStatement.setString(3, name);
			preparedStatement.setInt(4, age);
			preparedStatement.setDouble(5, salary);
			preparedStatement.setString(6, designation);
			preparedStatement.execute();
			System.out.println("Employee records inserted " + "/n Your id is " + id);
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void displayEmployee() {
		System.out.println("Enter the EmployeID");
		String id = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from employedatabase where id = ?");
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("The Employe slno is " + resultSet.getInt(1));
				System.out.println("The Employe id is " + resultSet.getString(2));
				System.out.println("The Employe name is " + resultSet.getString(3));
				System.out.println("The Employe age is " + resultSet.getInt(4));
				System.out.println("The Employe salary is " + resultSet.getDouble(5));
				System.out.println("The Employe designation is " + resultSet.getString(6));
			} else {
				try {
					throw new EmployeNotFoundException("Employe Not Present");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void displayAllEmployees() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employedatabase");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				while (resultSet.next()) {
					System.out.println("The Employe slno is " + resultSet.getInt(1));
					System.out.println("The Employe id is " + resultSet.getString(2));
					System.out.println("The Employe name is " + resultSet.getString(3));
					System.out.println("The Employe age is " + resultSet.getInt(4));
					System.out.println("The Employe salary is " + resultSet.getDouble(5));
					System.out.println("The Employe designation is " + resultSet.getString(6));
				}
			} else {
				try {
					throw new DataNotFoundException("Data Not Present");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeEmployee() {
		System.out.println("Enter the EmployeID");
		String id = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from employedatabase where id = ?");
			preparedStatement.setString(1, id);
			preparedStatement.execute();
			System.out.println("employe deleted!");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee() {
		System.out.println("Enter the age to be updated");
		int age = sc.nextInt();
		System.out.println("Enter the EmployeID");
		String id = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update employedatabase set age = ? where id = ?");
			preparedStatement.setInt(1, age);
			preparedStatement.setString(2, id);
			preparedStatement.execute();
			System.out.println("employe details updated!");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void countNoEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from employedatabase ");
			ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				System.out.println("the count of employees are: " + resultset.getInt(1));
			}
			System.out.println("Task completed!");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getEmployeeWithHighestSalary() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select max(salary) from employedatabase ");
			ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				System.out.println("Maximum salary: " + resultset.getDouble(1));
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getEmployeeWithLowestSalary() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select min(salary) from employedatabase ");
			ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				System.out.println("minimum salary: " + resultset.getDouble(1));
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeAllEmployes() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("truncate table employedatabase");
			preparedStatement.executeUpdate();
			System.out.println("Removed all the employes");
			System.out.println("Task completed!");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
