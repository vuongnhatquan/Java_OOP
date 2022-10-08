package library_management;

public class Book {
		//atts
			
		private int bookID, amount, available;
		private String bookTitle;
		
		//get-set methods
		public int getBookID() {
			return bookID;
		}
		public void setBookID(int bookID) {
			this.bookID = bookID;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public int getAvailable() {
			return available;
		}
		public void setAvailable(int available) {
			this.available = available;
		}
		public String getBookTitle() {
			return bookTitle;
		}
		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}
		
		//constructors
		public Book() {this.bookID = 2; this.amount = 3; this.available = 3; this.bookTitle = "Hello Java";}
		
		public Book(int bookID, String bookTitle, int amount) {this.bookID = bookID; this.amount = amount; this.available = amount; this.bookTitle = bookTitle;}
		
		//method
		public void showBookInfo() {
			System.out.println("Book ID: "+ bookID);
			System.out.println("Book Title: "+ bookTitle);
			System.out.println("Total Amount: "+ amount);
			System.out.println("Available: "+ available);
		}
}
