package LinkedListChallenge;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedList<Place> placesToVisit = new LinkedList<>();

        addPlace(placesToVisit, new Place("Sydney", 0));
        addPlace(placesToVisit, new Place("Adelaide", 1374));
        addPlace(placesToVisit, new Place("Alice Springs", 2771));
        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Darwin", 3972));
        addPlace(placesToVisit, new Place("Melbourne", 877));
        addPlace(placesToVisit, new Place("Perth", 3923));

        menu();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Place> iterator = placesToVisit.listIterator();

        if (!placesToVisit.isEmpty()) {
            System.out.println("Starting from: " + iterator.next());
        } else {
            System.out.println("No places in the itinerary.");
            return;
        }

        while (!quit) {
            System.out.print("Enter action: ");
            String action = scanner.nextLine().trim().toUpperCase();

            switch (action) {
                case "F":
                    if (!goingForward) {
                        if (iterator.hasNext()) iterator.next();
                        goingForward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now visiting " + iterator.next());
                    } else {
                        System.out.println("You reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case "B":
                    if (goingForward) {
                        if (iterator.hasPrevious()) iterator.previous();
                        goingForward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now visiting " + iterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;

                case "L":
                    printList(placesToVisit);
                    break;

                case "M":
                    menu();
                    break;

                case "Q":
                    quit = true;
                    System.out.println("Exiting itinerary...");
                    break;

                default:
                    System.out.println("Invalid action. Type 'M' to see menu again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void addPlace(LinkedList<Place> list, Place newPlace) {
        // Prevent duplicates
        if (list.contains(newPlace)) {
            System.out.println(newPlace.getName() + " already exists in the itinerary.");
            return;
        }

        // Insert in order
        ListIterator<Place> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Place current = iterator.next();
            if (current.getDistance() > newPlace.getDistance()) {
                iterator.previous();
                iterator.add(newPlace);
                return;
            }
        }
        // if we reach the end, add at the end
        iterator.add(newPlace);
    }

    private static void printList(LinkedList<Place> list) {
        System.out.println("\n--- Itinerary ---");
        for (Place place : list) {
            System.out.println(place);
        }
        System.out.println("-----------------\n");
    }

    private static void menu() {
        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }
}

