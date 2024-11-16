package LibraryManagement;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, User> users;
    private IssueBook issueBook;

    public Library() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
        this.issueBook = new IssueBook();
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            System.out.println("Book with this ISBN already exists.");
        } else {
            books.put(book.getIsbn(), book);
            System.out.println("Book added successfully.");
        }
    }

    public void addUser(User user) {
        if (users.containsKey(user.getUserId())) {
            System.out.println("User with this ID already exists.");
        } else {
            users.put(user.getUserId(), user);
            System.out.println("User added successfully.");
        }
    }

    public void issueBook(String isbn, String userId, String issueDate) {
        Book book = books.get(isbn);
        User user = users.get(userId);
        issueBook.issueBook(book, user, issueDate);
    }

    public void returnBook(String isbn, String userId, String returnDate) {
        Book book = books.get(isbn);
        User user = users.get(userId);
        issueBook.returnBook(book, user, returnDate);
    }

    public void printBookDetails() {
        for (Book book : books.values()) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getIsbn() +
                    ", Available Copies: " + book.getAvailableCopies());
        }
        System.out.println("Total available books: " + getTotalAvailableBooks());
        System.out.println("Total issued books: " + getTotalIssuedBooks());
    }
    

    private int getTotalAvailableBooks() {
        int total = 0;
        for (Book book : books.values()) {
            total += book.getAvailableCopies();
        }
        return total;
    }

    private int getTotalIssuedBooks() {
        int total = 0;
        for (Book book : books.values()) {
            total += (book.getNumberOfCopies() - book.getAvailableCopies());
        }
        return total;
    }
}
