import java.util.ArrayList;
import java.util.List;

public class Bank {
    private double tauxInteret;

    private List<Customer> customers;


    public Bank() {
        this.tauxInteret = 0;
        customers = new ArrayList<Customer>();
    }

    public double getTauxInteret() {
        return this.tauxInteret;
    }

    public void setTauxInteret(double setTaux) {
        this.tauxInteret = setTaux;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }


}
