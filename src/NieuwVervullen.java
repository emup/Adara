public class NieuwVervullen extends Vervullen {
    int amount;

    @Override
    void vragen() {
        System.out.println("Hoeveel kisten al gevuld?: ");
        amount = Menu.scanner.nextInt();
    }

    @Override
    void updaten(Object... args) {
        Main.kisten.removeAmount(amount);
        String name = (String) args[0];
        int customer = (int) args[1];
        int kn = (int) args[2];
        Main.orders.add(new Order(name, Main.getCustomerFromId(customer, Main.customers), kn, amount));
    }

    @Override
    void confirmatie() {
        System.out.println(Menu.ANSI_GREEN_BACKGROUND + Menu.ANSI_BLACK + "Nieuwe order toegevoegd!" + Menu.ANSI_RESET + "\n");
    }
}
