import java.util.ArrayList;

public class Main {
    protected static Integer selected;
    protected static ArrayList<Order> orders = new ArrayList<>();
    protected static ArrayList<Customer> customers = new ArrayList<>();
    protected static Kist kisten = new Kist(100);

    public static void main(String[] args) {
        initializeCustomers();
        initializeOrders();
        Menu menu = new Menu();
    }

    protected static Boolean checkSelected() {
        return selected == null || selected != 0;
    }


    private static void initializeCustomers() {
        customers.add(new Customer("ECMA-Corp"));
        customers.add(new Customer("Madurodam"));
        customers.add(new Customer("Keukenhof"));
    }

    private static void initializeOrders() {
        orders.add(new Order("Oranje tulpen voor touristen", getCustomerFromId(1, customers), 40, 0));
        orders.add(new Order("Lading rozen voor trouwfeest", getCustomerFromId(0, customers), 60, 20));
        orders.add(new Order("Hyacinten met spoed", getCustomerFromId(2, customers), 60, 60));
        orders.add(new Order("Rozen voor valentijnsdag", getCustomerFromId(1, customers), 20, 20));
    }

    public static Customer getCustomerFromId(int id, ArrayList<Customer> c) {
        return c.get(id);
    }
}
