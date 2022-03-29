public class Kist {
    private Integer amount;

    public Kist(Integer amount) {
        this.amount = amount;
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
