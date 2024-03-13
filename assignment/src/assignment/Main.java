// file Main.java
package assignment;



import java.io.File;
import java.io.IOException;
import java.util.Scanner;

	public class Main {		
		public static void main(String[] args) throws IOException {	
			 Scanner input=new Scanner(System.in);

			
			// creating file to store book
			File myfile=new File("book.txt" );
					try {
					myfile.createNewFile();
					} catch(IOException e) {
						System.out.println(" unable to create file");
						e.printStackTrace();
					}
			
				// creating file to store user	
					File myfile2=new File("user.txt" );
					try {
					myfile2.createNewFile();
					} catch(IOException e) {
						System.out.println(" unable to create file");
						e.printStackTrace();
					}
					
			System.out.println(" *****************WELOCME TO LIBRARY MANAGEMENT SYSTEM******************");
			   Library lib=new Library();
			   boolean flag=true;

			  String choice;
			  do {
				   System.out.println("\n0.exit\n"
				   		+ "1.add book\n"
				   		+ "2.add user\n"
				   		+ "3.show book\n"
				   		+ "4.show student\n"
				   		+ "5.purchase book\n"
				   		+ "6.return book\n"
				   		+ "7.save book.\n"
				   		+"8.save user\n"
				   		+"9.search book\n"
				   		+"10.load data");
				   // getting choice from user
				   System.out.print("\nEnter your choice: ");
				 				   
				  	
				   
				  choice=input.nextLine();			   
				  switch (choice) {
				   case "0":
					   flag=false;
					   System.out.println("Exiting...");
					   break;
				   case "1":
					   lib.add_book();
					   break;
				   case "2":
					   lib.add_user();
					   break;
				   case "3":
					  lib.show_book();
					   break;
				   case "4":
					   lib.show_user();
					   break;
				   case "5":
					   lib.check_out();
					   break;
				   case "6":
					   lib.return_book();
					   break;
				   case "7":
					   System.out.println("saving...");
					   lib.save_book();
					   break;
				   case "8":
					   System.out.println("saving...");
					   lib.save_user();
					   break;
				   case "9":
					   lib.search_book();
					   break;
				   case "10":
					   System.out.println("loading...");
					   lib.loadData();
					   break;
					default:
						System.out.println(" Enter the choice between 0 and 10");
				   }	   
				   
			   }
			   while(flag) ;
				  
				   
			  }
			  
		   }
	
	



