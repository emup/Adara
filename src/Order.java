public class Order {
    private static int hoogstenr = 0;
    private int nr = hoogstenr++;
    private String name;
    Customer customer;
    private int kistNeeded;
    private int kistUsed;

    public Order(String name, Customer customer, int kistNeeded, int kistUsed) {
        this.name = name;
        this.customer = customer;
        this.kistNeeded = kistNeeded;
        this.kistUsed = kistUsed;
    }

    public int getNr() {
        return nr;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getKistNeeded() {
        return kistNeeded;
    }

    public int getKistUsed() {
        return kistUsed;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setKistNeeded(int kistNeeded) {
        this.kistNeeded = kistNeeded;
    }

    public void setKistUsed(int kistUsed) {
        this.kistUsed = kistUsed;
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
