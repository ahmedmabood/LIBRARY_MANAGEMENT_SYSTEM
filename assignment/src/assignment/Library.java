// file Library.java
package assignment;

// importing java classes for inputs and file handling
import java.io.*;
import java.util.regex.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

	public class Library {
	Scanner input = new Scanner(System.in);
		// declaring array for  storing book
	   Book book_info[]= new Book[50]; 
	   public static int count1;
	   // declaring array for storing user
	   User user_info[]=new User[50];
		public static int count;
		
		// method  for adding books
	   public void add_book( ) {
 	   // creating object of book
		   Book b = new Book();
		   // taking inputs for BOOK attributes
		   
		   System.out.print("Enter the book ID: ");
	        while (!input.hasNextInt()) {
	        	System.out.println("\nInvalid input\n");
	            System.out.print("Enter the book ID: ");
	            input.next(); 
	        }
	        b.book_id = input.nextInt();
	        input.nextLine();	    
		   
			
		    System.out.print("Enter the title of book  ");
		    b.title =input.nextLine();
		    
		    boolean flag=true;
			while(flag) {
				
		    System.out.print("Enter the author name  ");
		    b.author =input.nextLine();
		    if(Pattern.matches("^[a-zA-Z ]*$", b.author))
		    	flag=false;
		    else
		    	System.out.println("\nInvalid input\n");
			}
				
		    
		    System.out.print("Enter the genre of book  ");
		    b.genre =input.nextLine();
		    
		    System.out.print("Enter the book quantity ");
		    while (!input.hasNextInt()) {
		    	System.out.println("\nInvalid input\n");
	            System.out.print("Enter the book quantity ");
	            input.next();}
		    b.available_books =input.nextInt();
		    input.nextLine();
		    // add to book array
		   if(count1<50){
			   book_info[count1]=b;
			   count1++;} 
		   else
			   System.out.println("There is no more space");
		   System.out.print("\nNow click save_book to save data\n");
	   }
	     
	   // method to save the book
	   public void save_book() throws IOException {
		   
		   String filePath = "book.txt";
	        
	        // Use Paths.get() to obtain a Path object
	        Path path = Paths.get(filePath);

	        // Delete the existing file
	        Files.deleteIfExists(path);

	        // Create a new file
	        Files.createFile(path);
	        
            // saving data into file        
	        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
	            for (int i = 0; i < count1; i++) {
	                writer.println(book_info[i].book_id + "\t\t" +
	                        book_info[i].title +
	                        "\t\t" + book_info[i].author +
	                        "\t\t" + book_info[i].genre +
	                        "\t\t" +
	                        book_info[i].available_books + "\n");
	            }
	        }
	
	   }
	  
	   // method to show books
	   public void show_book()  throws IOException {
		   System.out.println("ID\t\tTITLE\t\tAUTHOR\t\tGENRE\t\tAVAILABLE-BOOKS");
		        try (BufferedReader reader = new BufferedReader(new FileReader("book.txt"))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                // Process each line as needed
		                System.out.println(line);
		            }
		        }
		    }
	   
		// method to add user
		public void add_user( ) {
			// creating user object
			User u = new User();
			// taking inputs
			System.out.print("The user id will be ");
			while (!input.hasNextInt()) {
				System.out.println("\nInvalid input\n");
	        	System.out.print("The user id will be ");
	            input.next();}
	        u.user_id=input.nextInt();
	        input.nextLine();
		      
			boolean flag=true;
			while(flag) {
		    System.out.print("Enter the your name  ");
		    u.name =input.nextLine();
		    if(Pattern.matches("^[a-zA-Z ]*$", u.name))
		    	flag=false;
		    else
		    	System.out.println("\nInvalid input\n");
			}
		    
		    System.out.print("Enter the phone number  ");
		    u.phone_no =input.nextLine();
		    
		   u.borrow_books=0;
			
			if (count<50) {
				user_info[count]=u;
				count++;
			}else
				System.out.println("There is no more space");
			System.out.print("\nNow click save_user to save data\n");
		}
		

			// method to save the user	
			public void save_user() throws IOException {
				
				 String filePath = "user.txt";
			        
			        // Use Paths.get() to obtain a Path object
			        Path path = Paths.get(filePath);

			        // Delete the existing file
			        Files.deleteIfExists(path);

			        // Create a new file
			        Files.createFile(path);
			        
                     // saving data into user
				try (PrintWriter writer = new PrintWriter(new FileWriter("user.txt", true))) {
		            for (int i = 0; i < count; i++) {
		                writer.println( user_info[i].user_id + "\t\t" +
		                        user_info[i].name +
		                        "\t\t" + user_info[i].phone_no +
		                        "\t\t" + user_info[i].borrow_books);
		            }
		        }
		    }
		
	         // show student data
		public void show_user()   throws IOException {
			System.out.println("ID\t\tNAME\t\tPHONE-NO\t\tBORROWED-BOOKS\n");
			
	        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                // Process each line as needed
	                System.out.println(line);
	            }
	        }
	    } 
			
		public void check_out() throws IOException {
		    System.out.print("Enter your ID: ");
		    int s_id = input.nextInt();

		    // check user id
		    boolean userFound = false;
		    for (int i = 0; i < count; i++) {
		        if (s_id == user_info[i].user_id) {
		            System.out.print("Enter the book ID you want to purchase: ");
		            int b_id = input.nextInt();

		            // check book id
		            for (int j = 0; j < count1; j++) {
		                if (b_id == book_info[j].book_id) {

		                    // check available books
		                    if (book_info[j].available_books > 0) {
		                        System.out.println("You have purchased the book.");
		                        book_info[j].available_books--;
		                        user_info[i].borrow_books++;
		                        System.out.println("\nNow click save_book and save_user to save data.\n");
		                        return;  // Exit the method after a successful purchase
		                    } else {
		                        System.out.println("The book is not available.");
		                        return;  // Exit the method if the book is not available
		                    }
		                }
		            }

		            // Display an error if the book ID was not found
		            System.out.println("Invalid book ID.");
		            userFound = true;  // Mark the user as found
		        }
		    }

		    // Display an error if the user ID was not found
		    if (!userFound) {
		        System.out.println("Invalid user ID.");
		    }
		}
		 
		 
		// method to return the book
		public void return_book() {
		    System.out.print("Enter your ID: ");
		    int s_id = input.nextInt();

		    // check user id
		    boolean userFound = false;
		    for (int i = 0; i < count; i++) {
		        if (s_id == user_info[i].user_id) {
		            if (user_info[i].borrow_books > 0) { // Check if the user has borrowed books
		                System.out.print("Enter the book ID you want to return: ");
		                int b_id = input.nextInt();

		                // check book id
		                for (int j = 0; j < count1; j++) {
		                    if (b_id == book_info[j].book_id) {
		                        System.out.println("You have returned the book.");
		                        book_info[j].available_books++;
		                        user_info[i].borrow_books--;
		                        System.out.println("\nNow click save_book and save_user to save data.\n");
		                        return;  // Exit the method after a successful return
		                    }
		                }

		                // Display an error if the book ID was not found
		                System.out.println("Invalid book ID.");
		            } else {
		                System.out.println("You don't have any books to return.");
		            }
		            userFound = true;  // Mark the user as found
		        }
		    }

		    // Display an error if the user ID was not found
		    if (!userFound) {
		        System.out.println("Invalid user ID.");
		    }
		}


		// method to search book
		public void search_book() throws IOException {
		    // Check user id
		    System.out.print("Enter your ID: ");
		    int s_id = input.nextInt();
		    boolean userFound = false;

		    // Iterate through users
		    for (int i = 0; i < count; i++) {
		        if (s_id == user_info[i].user_id) {
		            System.out.print("Enter the book ID you want to search: ");
		            int b_id = input.nextInt();
		            boolean bookFound = false;

		            // Iterate through books
		            for (int j = 0; j < count1; j++) {
		                if (b_id == book_info[j].book_id) {
		                    // Check available books
		                    if (book_info[j].available_books > 0) {
		                        System.out.println("The book has been found.");
		                    } else {
		                        System.out.println("The book is not available.");
		                    }
		                    bookFound = true;
		                    break;  // Exit the book loop
		                }
		            }

		            // Display an error if the book ID was not found
		            if (!bookFound) {
		                System.out.println("Invalid book ID.");
		            }

		            userFound = true;
		            break;  // Exit the user loop
		        }
		    }

		    // Display an error if the user ID was not found
		    if (!userFound) {
		        System.out.println("Invalid user ID.");
		    }
		}

		
		// method to load data in books and in user
		   public void loadData() throws IOException {
		        loadBooks("book.txt");
		        loadUsers("user.txt");
		        }
		   
		   
		   // method to load data from file into book array
		   private void loadBooks(String filePath) throws IOException {
			   try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			        String line;
			        while ((line = reader.readLine()) != null) {
			            
			            String[] parts = line.split("\t\t"); // tabs are used as separators

			            
			            if (parts.length >= 5) {
			                Book b = new Book();
			                
			                // getting data from file
			                if (!parts[0].trim().isEmpty()) {
			                    b.book_id = Integer.parseInt(parts[0].trim());
			                }
		                    b.title = parts[1];
			                b.author = parts[2];
			                b.genre = parts[3];
			                if (!parts[4].trim().isEmpty()) {
			                    b.available_books = Integer.parseInt(parts[4].trim());
			                }
			                // Add the book to the array
			                if (count1 < 50) {
			                    book_info[count1++] = b;
			                }else
			                	System.out.println("There is no more space");
			            }
			        }
			    }
		   
		   }
		   
		// method to load users
			private void loadUsers(String filePath) throws IOException {
			    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			        String line;
			        while ((line = reader.readLine()) != null) {
			           
			            String[] parts = line.split("\t\t"); //  tabs are used as separators

			            // getting data from file
			            if (parts.length >= 4) {
			                User u = new User();
			                if (!parts[0].trim().isEmpty()) {
			                    u.user_id = Integer.parseInt(parts[0].trim());
			                }
			                u.name = parts[1];
			                u.phone_no = parts[2];
			                if (!parts[3].trim().isEmpty()) {
			                    u.borrow_books = Integer.parseInt(parts[3].trim());
			                }

			                // Add the user to the array
			                if (count < 50) {
			                    user_info[count++] = u;
			                }else
			                	System.out.println("There is no more space");
			            }
			        }
			    }
			}

	}


