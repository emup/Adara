public class OudVervullen extends Vervullen { // Template Method Pattern
    int order;
    int amount;

    @Override
    void vragen() {
        System.out.println(Menu.ANSI_CYAN + "Order vervullen" + Menu.ANSI_RESET);
        System.out.println("Ordernr: ");
        Menu.scanner.nextLine();
        order = Menu.scanner.nextInt();
        System.out.println("Hoeveel kisten wilt u toevoegen?: ");
        amount = Menu.scanner.nextInt();
    }

    @Override
    void updaten(Object... args) {
        Main.kisten.removeAmount(amount);
        OnvervuldeOrders.orders.get(order).addKist(amount);

        if(OnvervuldeOrders.orders.get(order).getKistUsed() == OnvervuldeOrders.orders.get(order).getKistNeeded()) {
            VervulManager vman = new VervulManager();
            vman.setLuisteraars();
            vman.setVervulUpdate(OnvervuldeOrders.orders.get(order)); // call observer
        }
    }

    @Override
    void confirmatie() {
        System.out.println(Menu.ANSI_GREEN_BACKGROUND + Menu.ANSI_BLACK + amount + " kisten toegevoegd aan order " +
                order + Menu.ANSI_RESET + "\n");
    }
}
