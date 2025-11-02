package problem3;

public class Textbook extends Book{
    public String level;

    public Textbook(String title, int numRec, int nbrPages, String author, String level) {
        super(title, numRec, nbrPages, author);
        this.level = level;
    }
}
