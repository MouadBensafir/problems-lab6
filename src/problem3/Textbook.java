package problem3;

public class Textbook extends Book{
    public String level;

    public Textbook(String title, int nbrPages, String author, String level) {
        super(title, nbrPages, author);
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("Textbook[Title: %s, Author: %s, Pages: %d, Level: %s]", getTitle(), getAuthor(), getNumPages(), level);
    }
}
