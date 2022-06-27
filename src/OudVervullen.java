public class OudVervullen extends Vervullen {
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
        Main.orders.get(order).addKist(amount);
    }

    @Override
    void confirmatie() {
        System.out.println(Menu.ANSI_GREEN_BACKGROUND + Menu.ANSI_BLACK + amount + " kisten toegevoegd aan order " +
                order + Menu.ANSI_RESET + "\n");
    }
}
