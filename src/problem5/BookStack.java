package problem5;

import java.util.LinkedList;

public class BookStack {
    private LinkedList<Book> stack;

    public BookStack() {
        stack = new LinkedList<>();
    }

    public void push(Book book) {
        stack.addLast(book);
    }

    public Book pop() {
        return stack.removeLast();
    }

    public Book peek() {
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents (top to bottom):");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println("- " + stack.get(i));
        }
    }


}

