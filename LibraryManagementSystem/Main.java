	package LibraryManagement;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books
        library.addBook(new Book("Java Programming", "John Doe", "12345", 10));
        library.addBook(new Book("Data Structures", "Jane Smith", "67890", 5));

        // Add users
        library.addUser(new User("Alice", "U1"));
        library.addUser(new User("Bob", "U2"));

        // Issue a book
        library.issueBook("12345", "U1", "2024-07-01");
        library.issueBook("67890", "U2", "2024-07-05");

        // Return a book
        library.returnBook("12345", "U1", "2024-07-20");
      
        // Print book details
        library.printBookDetails();
    }
}
