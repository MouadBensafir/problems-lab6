package problem3;

public class Novel extends Book {
    public double price;

    public Novel(String title, int numRec, int nbrPages, String author, double price) {
        super(title, numRec, nbrPages, author);
        this.price = price;
    }
}
