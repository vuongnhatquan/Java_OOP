package library_management ;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.util.ArrayList;												//mới dùng dc ArrayList

public class Library {
		//atts
		private String libraryName;
		private ArrayList<Book> bookList = new ArrayList<Book>();
		
		private static int numberOfBooks;
		private static final int MAX_NUMBER_OF_BOOKS = 100;
		
		public Scanner s = new Scanner(System.in);
		
		//constructors
		Library(String name) {this.libraryName = name;}
		Library() {this.libraryName = "Java"; this.numberOfBooks = 8; this.bookList = new ArrayList<Book>();
					this.bookList.add(new Book());
					this.bookList.add(new Book(3, "Python", 5));
					}
		
		//methods
		public void addNewBook() {
			if (numberOfBooks == MAX_NUMBER_OF_BOOKS)
				{System.out.println("The number of books has reached the limit"); return;}
			
			System.out.println("Enter book's ID: ");
			int iD = s.nextInt();
			if (this.findBookIndex(iD) >= 0) {System.out.println("ID has existed"); return;}
			
			System.out.println("Enter book's title: ");
			s.nextLine();									//phải có dòng này khi scanner read int then String
			String title = s.nextLine();
			
			System.out.println("Enter book's amount: ");
			int amount = s.nextInt();
			
					
			if (numberOfBooks + amount > MAX_NUMBER_OF_BOOKS) {System.out.println("The number of books has reached the limit"); return;}
			bookList.add(new Book(iD, title, amount));			//phải có new		
			
			numberOfBooks += amount;
		}
		
		private int findBookIndex(int bookID) {
			for(int i=0; i<bookList.size(); i++)
				{if (bookList.get(i).getBookID() == bookID) return i; }
			return -1;
		}
		
		public boolean findBook(int bookID) {
			int index = this.findBookIndex(bookID);
			if (index >= 0)
				{bookList.get(index).showBookInfo(); return true;}
			return false;
		}
		
		public Book getALuckyBook() {
			int max = bookList.size();
			int randomNum = ThreadLocalRandom.current().nextInt(0, max + 1);
			Book k = bookList.get(randomNum);
			
			int avlb = k.getAvailable();
			k.setAvailable(avlb-1);
			return k;
		}
		
		public void borrowBook(int bookID) {
			if (this.findBook(bookID) == true)
				{int index_br = this.findBookIndex(bookID);
				int avlb = bookList.get(index_br).getAvailable();
				if (avlb > 0)
					{bookList.get(index_br).setAvailable(avlb-1);
					System.out.println("The book is borrowed successfully!");
					bookList.get(index_br).showBookInfo();
					}
				}
		}
		
		public String[] split(String word) {
			String[] parts = word.trim().split("\\s+");
			return parts;
		}
		
		public boolean findBook(String keyword) {
			for (String part: this.split(keyword))
				{for (Book bk: bookList)
					{for (String part_bk: this.split(bk.getBookTitle()))
						{if (part.equalsIgnoreCase(part_bk))
							{bk.showBookInfo();return true;}
						}
					}
				}
			return false;
		}
		
		public void returnBook(int bookID) {
			int index_br = this.findBookIndex(bookID);
			if (index_br != -1)
			{int avlb = bookList.get(index_br).getAvailable();
			bookList.get(index_br).setAvailable(avlb+1);
			System.out.println("The book is returned successfully!");
			bookList.get(index_br).showBookInfo();}
		}
		
		public void showLibraryInfo() {
			System.out.println("Library name: "+ libraryName);
			System.out.println("Current number of books: "+ numberOfBooks);
			System.out.println("List of book titles:");
			for(Book b : bookList)
				{System.out.println("\t" + b.getBookTitle());}
			System.out.println();
		}
}

