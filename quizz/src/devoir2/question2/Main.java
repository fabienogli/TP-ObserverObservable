
public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        for (int i = 0; i < 3; i++) {
            Customer customer = new Customer(i+1);
            bank.addCustomer(customer);
        }
        bank.setTauxInteret(3);
        bank.setTauxInteret(2);
    }
}
