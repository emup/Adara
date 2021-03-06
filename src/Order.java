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
        System.out.println(Menu.ANSI_CYAN + "Order toevoegen" + Menu.ANSI_RESET);

        Menu.scanner.nextLine();
        String name = askOrderName();
        int customer = askKlantNr();
        int kn = askKistenNodig();

        Vervullen nieuweOrder = new NieuwVervullen();
        nieuweOrder.vervulproces(name, customer, kn);

        OrderMenu.showOrderMenu();
    }

    static String askOrderName() {
        System.out.println("Ordernaam: ");
        return Menu.scanner.nextLine();
    }

    static Integer askKlantNr() {
        System.out.println("Klantnr: ");
        return Menu.scanner.nextInt();
    }

    static Integer askKistenNodig() {
        System.out.println("Hoeveel kisten nodig?: ");
        return Menu.scanner.nextInt();
    }

    public static void showOrders() {
        if(Main.checkSelected()) {
            for (Order o : OnvervuldeOrders.orders) {
                System.out.println("- " + o);
            }
            Menu.sendBackToMenuOption();
        }
    }

    public static void showOrdersFulfilled() {
        while(Main.checkSelected()) {
            for (Order o : VervuldeOrders.ordersVervuld) {
                System.out.println("- " + o);
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
