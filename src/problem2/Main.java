package problem2;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Mouad");
        Customer c2 = new Customer("Arin");

        Bank bank = new Bank("Naps");

        bank.addCustomer(c1);
        bank.addCustomer(c2);

        // Mouad pays Arin
        bank.addTransactionFromTo(1500.0, "Mouad", "Arin");

        // Arin debits Mouad
        bank.addTransactionFromTo(-500.0, "Arin", "Mouad");
        bank.addTransactionFromTo(20000.0, "Sora", "Arin");
        bank.addTransactionFromTo(3500.0, "Mouad", "Wyfy");

    }
}
