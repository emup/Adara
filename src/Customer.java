public class Customer {
    private static int hoogstenr = 0;
    private int nr = hoogstenr++;
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public static void addCustomer() {
        System.out.println(Main.ANSI_CYAN + "Klant toevoegen" + Main.ANSI_RESET);
        System.out.println("Naam: ");
        Menu.scanner.nextLine();
        String name = Menu.scanner.nextLine();
        Main.customers.add(new Customer(name));
        System.out.println(Main.ANSI_GREEN_BACKGROUND + Main.ANSI_BLACK + "Klant toegevoegd!" + Main.ANSI_RESET + "\n");
        CustomerMenu.showCustomerMenu();
    }

    public static void showCustomers() {
        if(Main.checkSelected()) {
            for (Customer c : Main.customers) {
                System.out.println("- " + c);
            }
            Menu.sendBackToMenuOption();
        }
    }

    @Override
    public String toString() {
        return "Klantnr:" + nr + ", naam: " + name;
    }
}
