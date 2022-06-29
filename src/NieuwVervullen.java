public class NieuwVervullen extends Vervullen { // Template Method Pattern
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
        Order nieuweOrder = new Order(name, Main.getCustomerFromId(customer, Main.customers), kn, amount);
        OnvervuldeOrders.orders.add(nieuweOrder);

        int index = OnvervuldeOrders.orders.indexOf(nieuweOrder);
        if(OnvervuldeOrders.orders.get(index).getKistUsed() == OnvervuldeOrders.orders.get(index).getKistNeeded()) {
            VervulManager vman = new VervulManager();
            vman.setLuisteraars();
            vman.setVervulUpdate(OnvervuldeOrders.orders.get(index)); // call observer
        }
    }

    @Override
    void confirmatie() {
        System.out.println(Menu.ANSI_GREEN_BACKGROUND + Menu.ANSI_BLACK + "Nieuwe order toegevoegd!" + Menu.ANSI_RESET + "\n");
    }
}
