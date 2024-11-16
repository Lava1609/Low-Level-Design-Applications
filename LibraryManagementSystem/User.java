package LibraryManagement;


import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String userId;
    private Map<String, IssuedBookDetails> issuedBooks; // Map of ISBN to IssuedBookDetails

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.issuedBooks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public boolean canIssueMoreBooks() {
        return issuedBooks.size() < 3;
    }
 
    public void issueBook(Book book, String issueDate, String dueDate) {
        issuedBooks.put(book.getIsbn(), new IssuedBookDetails(issueDate, dueDate));
    }

    public void returnBook(Book book, String returnDate) {
        issuedBooks.remove(book.getIsbn());
    }

    private class IssuedBookDetails {
        private String issueDate;
        private String dueDate;

        public IssuedBookDetails(String issueDate, String dueDate) {
            this.issueDate = issueDate;
            this.dueDate = dueDate;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public String getDueDate() {
            return dueDate;
        }
    }
}
