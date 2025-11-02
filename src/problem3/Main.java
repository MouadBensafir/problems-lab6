package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask the user for the library capacity
        System.out.print("Enter the number of documents for the library: ");
        int n = sc.nextInt();
        sc.nextLine();

        Library library = new Library(n);

        // Initialize with two sample documents
        Book book1 = new Novel("The Great Gatsby",  599, "F. Scott Fitzgerald", 156.99);
        Book book2 = new Textbook("Introduction to Java",  450, "Herbert Schildt","Beginner");

        library.add(book1);
        library.add(book2);

        int choice;
        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Display all documents");
            System.out.println("2. Add a document");
            System.out.println("3. Delete a document");
            System.out.println("4. Display authors");
            System.out.println("5. Find document by record number");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    library.displayDocuments();
                    break;
                case 2:
                    System.out.println("Choose type: 1- Novel, 2- Textbook, 3- Magazine, 4- Dictionary");
                    int type = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    Document doc = null;
                    switch (type) {
                        case 1:
                            System.out.print("Enter author: ");
                            String author1 = sc.nextLine();
                            System.out.print("Enter number of pages: ");
                            int pages1 = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter price: ");
                            double price = sc.nextDouble();
                            sc.nextLine();
                            doc = new Novel(title, pages1, author1, price);
                            break;
                        case 2:
                            System.out.print("Enter author: ");
                            String author2 = sc.nextLine();
                            System.out.print("Enter number of pages: ");
                            int pages2 = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter level: ");
                            String level = sc.nextLine();
                            doc = new Textbook(title, pages2, author2, level);
                            break;
                        case 3:
                            System.out.print("Enter month: ");
                            String month = sc.nextLine();
                            System.out.print("Enter year: ");
                            int year = sc.nextInt();
                            sc.nextLine();
                            doc = new Magazine(title, month, year);
                            break;
                        case 4:
                            System.out.print("Enter language: ");
                            String language = sc.nextLine();
                            doc = new Dictionary(title, language);
                            break;
                        default:
                            System.out.println("Invalid type!");
                    }
                    if (doc != null) {
                        if (library.add(doc)) {
                            System.out.println("Document added successfully!");
                        } else {
                            System.out.println("Library is full. Cannot add document.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the record number of the document to delete: ");
                    int numEnrg = sc.nextInt();
                    sc.nextLine();
                    Document toDelete = library.document(numEnrg);
                    if (toDelete != null && library.delete(toDelete)) {
                        System.out.println("Document deleted successfully.");
                    } else {
                        System.out.println("Document not found.");
                    }
                    break;
                case 4:
                    library.displayAuthors();
                    break;
                case 5:
                    System.out.print("Enter the record number of the document: ");
                    int recNum = sc.nextInt();
                    sc.nextLine();
                    Document found = library.document(recNum);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Document not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
