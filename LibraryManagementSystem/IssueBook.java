package LibraryManagement;

import java.util.HashMap;
import java.util.Map;

public class IssueBook {
    private Map<String, IssuedBookDetails> issuedBooks; // Map of ISBN to IssuedBookDetails

    public IssueBook() {
        this.issuedBooks = new HashMap<>();
    }

    public void issueBook(Book book, User user, String issueDate) {
        if (book == null || user == null) {
            System.out.println("Invalid book or user.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is not available.");
            return;
        }

        if (!user.canIssueMoreBooks()) {
            System.out.println("User has reached the limit of issued books.");
            return;
        }

        String dueDate = calculateDueDate(issueDate);
        book.issueBook();
        user.issueBook(book, issueDate, dueDate);
        issuedBooks.put(book.getIsbn(), new IssuedBookDetails(user.getUserId(), issueDate, dueDate));

        System.out.println("Book issued successfully.");
    }

    public void returnBook(Book book, User user, String returnDate) {
        if (book == null || user == null) {
            System.out.println("Invalid book or user.");
            return;
        }

        if (!issuedBooks.containsKey(book.getIsbn())) {
            System.out.println("This book was not issued.");
            return;
        }

        IssuedBookDetails details = issuedBooks.get(book.getIsbn());
        if (!details.getUserId().equals(user.getUserId())) {
            System.out.println("This book was not issued to this user.");
            return;
        }

        int fine = calculateFine(details.getDueDate(), returnDate);
        if (fine > 0) {
            System.out.println("Fine for late return: $" + fine);
        }

        book.returnBook();
        user.returnBook(book, returnDate);
        issuedBooks.remove(book.getIsbn());

        System.out.println("Book returned successfully.");
    }

    private String calculateDueDate(String issueDate) {
        // Add 14 days to issueDate
        return DateUtil.addDaysToDate(issueDate, 14);
    }

    private int calculateFine(String dueDate, String returnDate) {
        int daysLate = DateUtil.daysBetweenDates(dueDate, returnDate);
        if (daysLate > 0) {
            return daysLate; // $1 per day fine
        }
        return 0;
    }

    private class IssuedBookDetails {
        private String userId;
        private String issueDate;
        private String dueDate;

        public IssuedBookDetails(String userId, String issueDate, String dueDate) {
            this.userId = userId;
            this.issueDate = issueDate;
            this.dueDate = dueDate;
        }

        public String getUserId() {
            return userId;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public String getDueDate() {
            return dueDate;
        }
    }
}
