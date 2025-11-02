package ArrayListChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GroceryListDemo {

    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\nAvailable actions:");
            System.out.println("0 - to shutdown");
            System.out.println("1 - to add item(s) to list (comma delimited list)");
            System.out.println("2 - to remove any items (comma delimited list)");
            System.out.print("\nEnter a number for which action you want to do: ");

            choice = scan.nextInt();
            scan.nextLine(); // consume leftover newline

            switch (choice) {
                case 0:
                    System.out.println("Shutting down...");
                    break;
                case 1:
                    System.out.print("Enter item(s) to add, separated by commas: ");
                    String addInput = scan.nextLine();
                    String[] addItems = addInput.split(",");
                    for (String item : addItems) {
                        item = item.trim();
                        if (!groceryList.contains(item)) {
                            groceryList.add(item);
                        } else {
                            System.out.println(item + " is already in the list!");
                        }
                    }
                    printSortedList(groceryList);
                    break;
                case 2:
                    System.out.print("Enter item(s) to remove, separated by commas: ");
                    String removeInput = scan.nextLine();
                    String[] removeItems = removeInput.split(",");
                    for (String item : removeItems) {
                        item = item.trim();
                        if (groceryList.contains(item)) {
                            groceryList.remove(item);
                        } else {
                            System.out.println(item + " is not in the list!");
                        }
                    }
                    printSortedList(groceryList);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scan.close();
    }

    // Helper method to print the list alphabetically
    public static void printSortedList(ArrayList<String> list) {
        list.sort(Comparator.naturalOrder());
        System.out.println("\nCurrent grocery list: " + list);
    }
}

