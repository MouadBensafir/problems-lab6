package problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String Name) {
        this.name = Name;
        customers = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer c) {
        if (!customers.contains(c)) {
            customers.add(c);
        }
    }

    public void addTransactionFromTo(Double transaction, String cName1, String cName2) {
        for (Customer c1 : customers) {
            if (c1.getName().equals(cName1)) {
                for (Customer c2 :  customers) {
                    if (c2.getName().equals(cName2)) {
                        c1.addTransaction(-transaction);
                        c2.addTransaction(transaction);
                        System.out.println("Transaction "+ transaction + " has been deduced to " + cName1 + " and added to " + cName2);
                        return;
                    }
                }
                System.out.println("Customer " + cName2 + " does not exist");
                return;
            }
        }
        System.out.println("Customer " + cName1 + " does not exist");
    }
}
