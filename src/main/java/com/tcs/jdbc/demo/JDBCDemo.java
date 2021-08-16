package com.tcs.jdbc.demo;
import java.sql.*;
import java.util.Iterator;
public class JDBCDemo {
	public static void main(String[] args) {
		String DB_URL="jdbc:mysql://localhost/practice";
		String DB_USER="root";
		String DB_PASSWORD="Nuvelabs123$";
		
		try(Connection connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
				Statement statement = connection.createStatement();){
			create(statement);//create operation 
			retrieve(statement);
			
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}

	private static void retrieve(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM REGIONS");
		while(resultSet.next()) {
			System.out.print(resultSet.getInt(1)+" ");
			System.out.println(resultSet.getNString("REGION_NAME"));
		}
	}
	private static void create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO REGIONS VALUES(5,'Canada')");
	}
}
