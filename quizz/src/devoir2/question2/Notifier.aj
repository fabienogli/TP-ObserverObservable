import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public aspect Notifier {

    List<Customer> customers = new ArrayList<>();

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    pointcut interetsChangent(double value, Bank bank) :
            call(void Bank.setTauxInteret(double)) && args(value) && target(bank);

    pointcut clientAdd(Customer customer, Bank bank) :
            call(void Bank.addCustomer(Customer)) && args(customer) && target(bank);

    before(double value, Bank bank) : interetsChangent(value, bank) {
        support.firePropertyChange("tauxInteret", bank.getTauxInteret(), value);
    }

    after(Customer customer, Bank bank) : clientAdd(customer, bank) {
//        System.out.println("Customer add:" + customer);
        support.addPropertyChangeListener(customer);
    }




}