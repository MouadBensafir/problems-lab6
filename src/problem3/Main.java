package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the capacity of your library : ");
        int n = sc.nextInt();
        Library library = new Library(n);

        Novel novel = new Novel("La femme de ménage", 1523, 215, "Freida McFadden", 109.99);
        Magazine magazine = new Magazine("Chokkun Strikes Again!", 1874, "January", 2025);

        library.add(novel);
        library.add(magazine);

    }
}
