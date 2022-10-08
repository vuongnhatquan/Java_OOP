package library_management;
import java.util.Scanner;

public class Program {
	public static Scanner s = new Scanner(System.in);
	private static int option;
	public static boolean cont = true;
	
	public static void showMenu() {
		System.out.println("========== Main menu ==========");
		System.out.println("1. Show library information");
		System.out.println("2. Add new book");
		System.out.println("3. Find book");
		System.out.println("4. Borrow a book");
		System.out.println("5. Return a book");
		System.out.println("6. Find book with Title");
		System.out.println("7. Get a lucky book");
		System.out.println("8. Exit");
		System.out.println("===============================");
		System.out.println("Enter menu ID (1-8):");
	}
	
	public static void askOption() {
		option = s.nextInt();
	}
	
	public static void select(Library lib, int option) {
		switch (option) {
		 case 1: System.out.println("1. Show library information");
		 		 System.out.println("---------------------");
		 		 lib.showLibraryInfo();
		 		 System.out.println("_________ end _________");
		 		 break;
		 		 
		 case 2: System.out.println("2. Add new book");
		 		 System.out.println("---------------------");
		 		 lib.addNewBook();
		 		 System.out.println("_________ end _________");
		 		 break;
		 		 
		 case 3: System.out.println("3. Find book");
		 		 System.out.println("---------------------");
		 		 lib.findBook(enterBookID());
		 		 System.out.println("_________ end _________");
		 		 break;
		 		 
		 case 4: System.out.println("4. Borrow a book");
		 		 System.out.println("---------------------");
		 		 lib.borrowBook(enterBookID());
		 		 System.out.println("_________ end _________");
		 		 break;
		 
		 case 5: System.out.println("5. Return a book");
	 		 	 System.out.println("---------------------");
	 		 	 lib.returnBook(enterBookID());
	 		 	 System.out.println("_________ end _________");
	 		 	 break;
	 		 	 
		 case 6: System.out.println("6. Find book with Title");
 	 	 		 System.out.println("---------------------");
 	 	 		 lib.findBook(enterBooTitle());
 	 	 		 System.out.println("_________ end _________");
 	 	 		 break;
	 		 	 
		 case 7: System.out.println("7. Get a lucky book");
		 	 	 System.out.println("---------------------");
		 	 	 Book b = lib.getALuckyBook();
		 	 	 b.showBookInfo();
		 	 	 System.out.println("_________ end _________");
		 	 	 break;
		 	 
		 default:
			 	 System.out.println("Good bye!");
			 	 cont = false;
			 	 break;} 
	}
	
	public static int enterBookID() {
		System.out.println("Enter book's ID: ");
		int ID = s.nextInt(); return ID;
	}
	
	public static String enterBooTitle() {
		System.out.println("Enter book's title: ");
		s.nextLine();
		String title = s.nextLine(); return title;
	}
	
	public static void main(String[] args) {
		Library lib = new Library();
			 showMenu();
			 askOption();
			 select(lib, option);
			 cont = true;
			 while (cont) {showMenu(); askOption(); select(lib, option);}
	}
}
