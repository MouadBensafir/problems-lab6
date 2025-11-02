package problem5;

import java.util.LinkedList;

public class BookQueue {
    private LinkedList<Book> queue;

    public BookQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(Book b) {
        queue.addLast(b);
    }

    public Book dequeue() {
        return queue.removeFirst();
    }

    public Book peek() {
        return queue.getFirst();
    }
}
