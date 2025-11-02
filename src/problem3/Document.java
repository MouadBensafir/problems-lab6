package problem3;

public class Document {
    protected int numRec;
    protected String title;

    public int getNumRec() { return this.numRec; }
    public String getTitle() { return this.title; }

    public Document(String title, int numRec) {
        this.title = title;
        this.numRec = numRec;
    }
}
