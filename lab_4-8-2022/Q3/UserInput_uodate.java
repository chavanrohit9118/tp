/*
 * Q3.JDBC :Create a jdbc project to delete and update a row data as per user input request.
 */

package Q3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserInput_uodate {

	public void toUpdate() {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/lab_4aug";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String update_qry ="UPDATE employee SET salary=? where id=?";
		String update_qry1="UPDATE employee SET name=? where id=?";
		
		
		Connection con=null;
		PreparedStatement pstmt1 = null;
		boolean quit =false;
		
		do {
		
			System.out.println("1.for Update salary  2.for update name   3.exit");
			int a=sc1.nextInt();
			sc1.nextLine();
			
			
			if(a==1) {
				try {
					Class.forName(driver);
					System.out.println("Driver loaded ");
					
					con=DriverManager.getConnection(url,"root","Rohit@111ch");
					System.out.println("Connection established");
					
					
						pstmt1=con.prepareStatement(update_qry);	
						System.out.println("Enter updated salary");
						int salary=sc1.nextInt();
						pstmt1.setInt(1, salary);
						
						
						System.out.println("Enter id of that employee");
						int id =sc1.nextInt();
						pstmt1.setInt(2,id);
						
						pstmt1.executeUpdate();
						
						System.out.println("done");
					
				}
						
				catch (Exception e) {		
					e.printStackTrace();
				}
			}
			else if(a==2) {
				try {
					Class.forName(driver);
					System.out.println("Driver loaded ");
					
					con=DriverManager.getConnection(url,"root","Rohit@111ch");
					System.out.println("Connection established");
					
					
						pstmt1=con.prepareStatement(update_qry1);	
						System.out.println("Enter name you want to update");
						String name=sc2.nextLine();
						pstmt1.setString(1, name);
						
						
						System.out.println("Enter id of that employee you want to update");
						int id =sc1.nextInt();
						pstmt1.setInt(2,id);
						
						pstmt1.executeUpdate();
						
						System.out.println("done");
					
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