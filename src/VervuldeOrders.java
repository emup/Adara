import java.util.ArrayList;

public class VervuldeOrders implements VervulObserver {
    protected static ArrayList<Order> ordersVervuld = new ArrayList<>();

    @Override
    public void update(Order vervulUpdate) {
        ordersVervuld.add(vervulUpdate);
        System.out.println("Order toegevoegd aan lijst vervulde orders!");
    }
}
