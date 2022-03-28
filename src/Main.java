import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    protected Integer selected;
    protected Scanner scanner = new Scanner(System.in);
    protected static ArrayList<Order> orders = new ArrayList<>();
    protected static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        initializeCustomers();
        initializeOrders();
        Menu menu = new Menu();
    }

    private Boolean checkSelected() {
        return selected == null || selected != 0;
    }

    public void showOrders() {
        while(checkSelected()) {
            for (Order o : orders) {
                System.out.println("- " + o);
            }
            scanner.next();
        }
    }

    public void showOrdersFulfilled() {
        while(checkSelected()) {
            for (Order o : orders) {
                if(o.getKistUsed() == o.getKistNeeded()) {
                    System.out.println("- " + o);
                }
            }
            scanner.next();
        }
    }

    private static void initializeCustomers() {
        customers.add(new Customer("ECMA-Corp"));
        customers.add(new Customer("Madurodam"));
        customers.add(new Customer("Keukenhof"));
    }

    private static void initializeOrders() {
        orders.add(new Order("Oranje tulpen voor touristen", getCustomerFromId(1), 40, 0));
        orders.add(new Order("Lading rozen voor trouwfeest", getCustomerFromId(0), 60, 20));
        orders.add(new Order("Hyacinten met spoed", getCustomerFromId(2), 60, 60));
        orders.add(new Order("Rozen voor valentijnsdag", getCustomerFromId(1), 20, 20));
    }

    public static Customer getCustomerFromId(int id) {
        return customers.get(id);
    }
}
