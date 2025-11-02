package problem5;

public class Main {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book book2 = new Book("1984", "George Orwell", 1949);
        Book book3 = new Book("Clean Code", "Robert C. Martin", 2008);

        // === Stack Test ===
        System.out.println("=== Stack Test ===");

        // Push books onto the stack
        BookStack stack = new BookStack();
        stack.push(book1);
        stack.push(book2);
        stack.push(book3);

        // Print stack contents
        stack.display();

        // Pop the top book
        System.out.println("Popped: " + stack.pop());

        // Peek at the new top
        System.out.println("Top: " + stack.peek());

        // Print stack contents again
        stack.display();

        // === Queue Test ===
        System.out.println("\n=== Queue Test ===");

        // Enqueue books into the queue
        BookQueue queue = new BookQueue();
        queue.enqueue(book1);
        queue.enqueue(book2);
        queue.enqueue(book3);

        // Print queue contents
        queue.display();

        // Dequeue the front book
        System.out.println("Dequeued: " + queue.dequeue());

        // Peek at the new front
        System.out.println("Front: " + queue.peek());

        // Print queue contents again
        queue.display();
    }
}

