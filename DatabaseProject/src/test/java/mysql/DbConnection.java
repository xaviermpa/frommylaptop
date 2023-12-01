package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "gAVINA@2011");
		
		
		Statement stmt = con.createStatement();
		
		ResultSet result = stmt.executeQuery("select * from eproduct;");
		
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the profuct " + result.getDouble("price"));
		}
		
		System.out.println("============== Insert ====================================");
		// Insert new data using execute update
		
		stmt.executeUpdate("insert into eproduct (name, price, date_added) values ('Television', 15000.00, now())");
		
		result = stmt.executeQuery("select * from eproduct;");
			
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the profuct " + result.getDouble("price"));
		}
		
		System.out.println("================ Delete ==================================");
		
		stmt.executeUpdate("delete from eproduct where name='Television';");
		
		result = stmt.executeQuery("select * from eproduct;");
		
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the profuct " + result.getDouble("price"));
		}
		
System.out.println("================ Update ==================================");
		
		stmt.executeUpdate("update eproduct set price=16000.00 where name='Mobile'");
		
		result = stmt.executeQuery("select * from eproduct;");
		
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the profuct " + result.getDouble("price"));
		}
		con.close();

	}

}
