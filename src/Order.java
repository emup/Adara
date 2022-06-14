public class Order {
    private static int hoogstenr = 0;
    private int nr = hoogstenr++;
    private String name;
    private Customer customer;
    private int kistNeeded;
    private int kistUsed;

    public Order(String name, Customer customer, int kistNeeded, int kistUsed) {
        this.name = name;
        this.customer = customer;
        this.kistNeeded = kistNeeded;
        this.kistUsed = kistUsed;
    }

    public static void addOrder() {
        System.out.println(Main.ANSI_CYAN + "Order toevoegen" + Main.ANSI_RESET);
        System.out.println("Ordernaam: ");
        Menu.scanner.nextLine();
        String name = Menu.scanner.nextLine();
        System.out.println("Klantnr: ");
        int customer = Menu.scanner.nextInt();
        System.out.println("Hoeveel kisten nodig?: ");
        int kn = Menu.scanner.nextInt();
        System.out.println("Hoeveel kisten al gevuld?: ");
        int ku = Menu.scanner.nextInt();
        Main.orders.add(new Order(name, Main.getCustomerFromId(customer, Main.customers), kn, ku));
        System.out.println(Main.ANSI_GREEN_BACKGROUND + Main.ANSI_BLACK + "Order toegevoegd!" + Main.ANSI_RESET + "\n");
        OrderMenu.showOrderMenu();
    }

    public static void fulfillOrder() {
        System.out.println(Main.ANSI_CYAN + "Order vervullen" + Main.ANSI_RESET);
        System.out.println("Ordernr: ");
        Menu.scanner.nextLine();
        int order = Menu.scanner.nextInt();
        System.out.println("Hoeveel kisten wilt u toevoegen?: ");
        int amount = Menu.scanner.nextInt();
        Main.kisten.removeAmount(amount);
        Main.orders.get(order).addKist(amount);
        System.out.println(Main.ANSI_GREEN_BACKGROUND + Main.ANSI_BLACK + amount + "kisten toegevoegd aan order " +
                order + Main.ANSI_RESET + "\n");
    }

    public static void showOrders() {
        if(Main.checkSelected()) {
            for (Order o : Main.orders) {
                System.out.println("- " + o);
            }
            Menu.sendBackToMenuOption();
        }
    }

    public static void showOrdersFulfilled() {
        while(Main.checkSelected()) {
            for (Order o : Main.orders) {
                if(o.getKistUsed() == o.getKistNeeded()) {
                    System.out.println("- " + o);
                }
            }
            Menu.sendBackToMenuOption();
        }
    }

    public int getKistNeeded() {
        return kistNeeded;
    }

    public int getKistUsed() {
        return kistUsed;
    }

    public void addKist(int amount) {
        this.kistUsed += amount;
    }

    @Override
    public String toString() {
        return "Ordernr: " + nr +
                ", naam: " + name +
                ", klant: " + customer +
                ", kisten nodig: " + kistNeeded +
                ", kisten gebruikt: " + kistUsed;
    }
}
