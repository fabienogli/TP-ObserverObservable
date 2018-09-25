
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Customer implements PropertyChangeListener {

    private double tauxInteret;
    private int id;

    public Customer(int id) {
        this.id = id;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        this.tauxInteret = (double) propertyChangeEvent.getNewValue();
//        System.out.println("chez le client: "+ this +propertyChangeEvent.getPropertyName() + ": " +  this.tauxInteret);
    }

    @Override
    public String toString() {
        return "Client :" + this.id +"\n";
    }
}
