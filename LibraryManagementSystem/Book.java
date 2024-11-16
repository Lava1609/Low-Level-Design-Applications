package LibraryManagement;
public class Book {
    private String title;
    private String author;
    private String isbn;
    private int numberOfCopies;
    private int issuedCopies;

    public Book(String title, String author, String isbn, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.numberOfCopies = numberOfCopies;
        this.issuedCopies = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public int getAvailableCopies() {
        return numberOfCopies - issuedCopies;
    }

    public boolean isAvailable() {
        return getAvailableCopies() > 0;
    }

    public void issueBook() {
        if (isAvailable()) {
            issuedCopies++;
        }
    }

    public void returnBook() {
        if (issuedCopies > 0) {
            issuedCopies--;
        }
    }
}
