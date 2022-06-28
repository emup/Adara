import java.util.ArrayList;

class VervulManager{ // observer pattern
    Order vervulUpdate;
    ArrayList<VervulObserver> luisteraars;

    void setLuisteraars(){
        luisteraars = new ArrayList<VervulObserver>();
        luisteraars.add(new OnvervuldeOrders()); // onvervulde bestellingen
        luisteraars.add(new VervuldeOrders()); // vervulde bestellingen
    }

    public void notifyAllObservers(){
        for (VervulObserver observer : luisteraars) {
            observer.update(this.vervulUpdate);
        }
    }

    void setVervulUpdate(Order vervulUpdate){
        this.vervulUpdate = vervulUpdate;
        notifyAllObservers();
    }
}
