package problem1;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop
{
    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList<>();
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        do
        {
            System.out.print("Enter the name of the item: ");
            itemName = scan.nextLine();

            System.out.print("Enter the unit price: ");
            itemPrice = scan.nextDouble();

            System.out.print("Enter the quantity: ");
            quantity = scan.nextInt();
            scan.nextLine(); // empty buffer for the rest of the line

            // *** Create a new item and add it to the cart
            item = new Item(itemName, itemPrice, quantity);
            cart.add(item);

            // *** Print the contents of the cart object using println
            double totalPrice = 0.0;
            System.out.println("\n== Content of the cart ==");
            for (Item i : cart) {
                System.out.println("- " + i);
                totalPrice += i.getPrice() * i.getQuantity();
            }

            NumberFormat fmt = NumberFormat.getCurrencyInstance();
            System.out.println("Total Price : " + fmt.format(totalPrice) + "\n");

            System.out.print("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();
        }
        while (keepShopping.equalsIgnoreCase("y"));
    }
}
