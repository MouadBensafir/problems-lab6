package problem3;

public class Book extends Document {
    protected String author;
    protected int nbrPages;

    public String getAuthor() { return this.author; }
    public int getNumPages() { return this.nbrPages; }

    public Book(String title, int numRec, int nbrPages, String author) {
        super(title, numRec);
        this.nbrPages = nbrPages;
        this.author = author;
    }
}
