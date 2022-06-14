public class Kist {
    private Integer amount;

    public Kist(Integer amount) {
        this.amount = amount;
    }

    public static void showKisten() {
        int amount = Main.kisten.getAmount();
        System.out.println(Main.ANSI_GREEN_BACKGROUND + Main.ANSI_BLACK + "Er zijn " + amount + " kisten" + Main.ANSI_RESET + "\n");
        KistenMenu.showKistenMenu();
    }

    public static void addKist() {
        System.out.println(Main.ANSI_CYAN + "Hoeveel kisten wilt u toevoegen?" + Main.ANSI_RESET);
        int amount = Menu.scanner.nextInt();
        Main.kisten.addAmount(amount);
        System.out.println(Main.ANSI_GREEN_BACKGROUND + Main.ANSI_BLACK + amount + " kisten toegevoegd!" + Main.ANSI_RESET + "\n");
        KistenMenu.showKistenMenu();
    }

    public static void removeKist() {
        System.out.println(Main.ANSI_CYAN + "Hoeveel kisten wilt u verwijderen?" + Main.ANSI_RESET);
        int amount = Menu.scanner.nextInt();
        Main.kisten.removeAmount(amount);
        System.out.println(Main.ANSI_GREEN_BACKGROUND + Main.ANSI_BLACK + amount + " kisten verwijderd!" + Main.ANSI_RESET + "\n");
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
