package problem3;

public class Document {
    protected int numRec;
    protected String title;
    private static int nextRec = 1;

    public int getNumRec() { return this.numRec; }
    public String getTitle() { return this.title; }

    public Document(String title) {
        this.title = title;
        this.numRec = nextRec++;
    }
}
