
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
        System.out.println(this + "voit que le taux d'intérêt a changé");
        this.tauxInteret = (double) propertyChangeEvent.getNewValue();
    }

    @Override
    public String toString() {
        return "Client :" + this.id +"\n";
    }
}
