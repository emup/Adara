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
        int ku = askKistenGevuld();

        Main.orders.add(new Order(name, Main.getCustomerFromId(customer, Main.customers), kn, ku));
        System.out.println(Menu.ANSI_GREEN_BACKGROUND + Menu.ANSI_BLACK + "Order toegevoegd!" + Menu.ANSI_RESET + "\n");
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

    static Integer askKistenGevuld() {
        System.out.println("Hoeveel kisten al gevuld?: ");
        return Menu.scanner.nextInt();
    }


    public static void fulfillOrder() {
        System.out.println(Menu.ANSI_CYAN + "Order vervullen" + Menu.ANSI_RESET);
        System.out.println("Ordernr: ");
        Menu.scanner.nextLine();
        int order = Menu.scanner.nextInt();
        System.out.println("Hoeveel kisten wilt u toevoegen?: ");
        int amount = Menu.scanner.nextInt();
        Main.kisten.removeAmount(amount);
        Main.orders.get(order).addKist(amount);
        System.out.println(Menu.ANSI_GREEN_BACKGROUND + Menu.ANSI_BLACK + amount + "kisten toegevoegd aan order " +
                order + Menu.ANSI_RESET + "\n");
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
