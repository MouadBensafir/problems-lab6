package problem3;

public class Novel extends Book {
    public double price;

    public Novel(String title, int nbrPages, String author, double price) {
        super(title, nbrPages, author);
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Novel[Title: %s, Author: %s, Pages: %d, Level: %s]", getTitle(), getAuthor(), getNumPages(), price);
    }
}
