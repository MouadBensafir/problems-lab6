package problem5;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Stack Test ===");

        BookStack stack = new BookStack();
        stack.push(new Book("Clean Code", "Robert C. Martin", 2008));
        stack.push(new Book("1984", "George Orwell ", 1949));
        stack.push(new Book("The Hobbit", "J.R.R. Tolkien", 1937));

        stack.pop();
        stack.peek();
    }
}
