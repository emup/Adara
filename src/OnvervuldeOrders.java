import java.util.ArrayList;

public class OnvervuldeOrders implements VervulObserver {
    protected static ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void update(Order vervulUpdate) {
        orders.remove(vervulUpdate);
        System.out.println("Order verwijderd van lijst onvervulde orders!");
    }
}
