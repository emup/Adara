public class Kist {
    private Integer amount;

    public Kist(Integer amount) {
        this.amount = amount;
    }

    public static void showKisten() {
        int amount = Main.kisten.getAmount();
        System.out.println(Menu.ANSI_GREEN_BACKGROUND + Menu.ANSI_BLACK + "Er zijn " + amount + " kisten" + Menu.ANSI_RESET + "\n");
        KistenMenu.showKistenMenu();
    }

    public static void addKist() {
        System.out.println(Menu.ANSI_CYAN + "Hoeveel kisten wilt u toevoegen?" + Menu.ANSI_RESET);
        int amount = Menu.scanner.nextInt();
        Main.kisten.addAmount(amount);
        System.out.println(Menu.ANSI_GREEN_BACKGROUND + Menu.ANSI_BLACK + amount + " kisten toegevoegd!" + Menu.ANSI_RESET + "\n");
        KistenMenu.showKistenMenu();
    }

    public static void removeKist() {
        System.out.println(Menu.ANSI_CYAN + "Hoeveel kisten wilt u verwijderen?" + Menu.ANSI_RESET);
        int amount = Menu.scanner.nextInt();
        Main.kisten.removeAmount(amount);
        System.out.println(Menu.ANSI_GREEN_BACKGROUND + Menu.ANSI_BLACK + amount + " kisten verwijderd!" + Menu.ANSI_RESET + "\n");
        KistenMenu.showKistenMenu();
    }

    public Integer getAmount() {
        return amount;
    }

    public void addAmount(Integer amount) {
        this.amount += amount;
    }

    public void removeAmount(Integer amount) {
        this.amount -= amount;
    }
}
