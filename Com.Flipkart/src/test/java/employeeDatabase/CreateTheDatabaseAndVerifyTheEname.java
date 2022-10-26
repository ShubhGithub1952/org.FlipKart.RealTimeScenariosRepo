package employeeDatabase;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;


public class CreateTheDatabaseAndVerifyTheEname {
	static Connection connection;
	static Driver driverRef;
	static Statement stat;
	static ResultSet result;
	@Test
	public void createTable() throws Throwable {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//driverRef = new Driver();
			//DriverManager.registerDriver(driverRef);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			stat = connection.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Entre the String Name........");
			String expectestr = sc.nextLine();
			//			int size = expectestr.length();
			if (expectestr.length()>=6) {
				result = stat.executeQuery("select * from employee;");
				boolean flag=false;
				while (result.next()) {
					if (result.getString(1).equalsIgnoreCase(expectestr)) {

						System.out.println("Data is already Present !");
						flag=true;
						break;
					}
				}
				if (flag==false) {
					System.out.println("Ename isnot Present is Database !");
					String updateQuery = "insert into employee(ename)values('"+expectestr+"');";
					stat.executeUpdate(updateQuery);
				}
			}
			else {
				System.out.println("Kindly Entre the String more than 6 Character !");
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			connection.close();
		}

	}
}
