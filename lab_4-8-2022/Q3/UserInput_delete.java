/*
 * Q3.JDBC :Create a jdbc project to delete and update a row data as per user input request.
 */


package Q3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserInput_delete {

	public void toDelete() {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/lab_4aug";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String delete_qry ="DELETE FROM employee WHERE id=?";
		String delete_qry1 ="TRUNCATE `lab_4aug`.`employee`;";
		
		Connection con=null;
		PreparedStatement pstmt1 = null;
		boolean quit =false;
	
		do {
			System.out.println("Enter 1.for delete all    2.for delete individual   3.exit");
			int a=sc1.nextInt();
			sc1.nextLine();
			
			if(a==2) {
				try {
					Class.forName(driver);
					System.out.println("Driver loaded ");
					
					con=DriverManager.getConnection(url,"root","Rohit@111ch");
					System.out.println("Connection established");
					
					pstmt1=con.prepareStatement(delete_qry);
					System.out.println("Enter id of employee you want to delete");
					int id =sc1.nextInt();
					pstmt1.setInt(1,id);
					pstmt1.executeUpdate();
					System.out.println("done");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(a==1) {
				try {
					Class.forName(driver);
					System.out.println("Driver loaded ");
					
					con=DriverManager.getConnection(url,"root","Rohit@111ch");
					System.out.println("Connection established");
				
					pstmt1=con.prepareStatement(delete_qry1);
					pstmt1.executeUpdate();
					quit=true;
					System.out.println("All data has been deleted successfully");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(a==3) {
				quit=true;
				System.out.println("Exited successfully");
				sc1.nextLine();
			}
			else {
				System.out.println("invalid!!!!");
			}
		}
		while(!quit);
		sc1.close();
		sc2.close();
	}
	}
