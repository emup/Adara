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
