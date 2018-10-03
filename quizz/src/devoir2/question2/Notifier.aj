import java.beans.PropertyChangeSupport;
public aspect Notifier {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    pointcut interetsChangent(double value, Bank bank) :
            call(void Bank.setTauxInteret(double)) && args(value) && target(bank);

    before(double value, Bank bank) : interetsChangent(value, bank) {
        support.firePropertyChange("tauxInteret", bank.getTauxInteret(), value);
    }

    pointcut clientAdd(Customer customer, Bank bank) :
            call(void Bank.addCustomer(Customer)) && args(customer) && target(bank);


    after(Customer customer, Bank bank) : clientAdd(customer, bank) {
        support.addPropertyChangeListener(customer);
        System.out.println(customer + " ajouté comme observer");
    }




}