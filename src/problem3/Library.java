package problem3;

import java.util.ArrayList;

public class Library {
    private int capacity;
    private ArrayList<Document> documents;

    public Library(int capacity) {
        this.capacity = capacity;
        documents = new ArrayList<>();
    }

    public void displayDocuments() {
        for (Document d : documents) {
            System.out.println(d);
        }
    }

    public boolean add(Document doc) {
        if (documents.size() < capacity) {
            return documents.add(doc);
        }
        return false;
    }

    public boolean delete(Document doc) {
        return documents.remove(doc);
    }

    public Document getDocument(int numEnrg) {
        for (Document d : documents) {
            if (d.getNumRec() == numEnrg) {
                return d;
            }
        }
        return null;
    }

    public void displayAuthors() {
        for (Document d : documents) {
            if (d instanceof Book b) {
                System.out.println(b.getAuthor());
            }
        }
    }
}
