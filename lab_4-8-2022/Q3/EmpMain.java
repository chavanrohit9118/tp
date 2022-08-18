/*
 * Q3.JDBC :Create a jdbc project to delete and update a row data as per user input request.
 */
package Q3;

import java.util.Scanner;

public class EmpMain  {
	
public static void main(String[] args) throws Exception{
	
	UserInput_uodate u =new UserInput_uodate();
	UserInput_delete d =new UserInput_delete();	
	Scanner sc = new Scanner(System.in);
	boolean quit=false;
	
	do {
		System.out.println("Enter 1.for update   2.for delete    3.exit");
		
		int a=sc.nextInt();
		sc.nextLine();
		
		
		if(a==1) {
			u.toUpdate();
		}
		else if(a==2){
			d.toDelete();
		}
		else if(a==3) {
			quit=true;
			System.out.println("Exited successfully");
		}
		else {
			System.out.println("invalid !!!!");
		}
	}
	while(!quit);
	sc.close();
}
}
