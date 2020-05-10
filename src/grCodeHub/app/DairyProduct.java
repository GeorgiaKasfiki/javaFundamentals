package grCodeHub.app;

public class DairyProduct extends Product {
    private String Producer;

    public DairyProduct (String code, String name, float price, int quantity, String producer) {
        super(code, name, price, quantity);
        this.Producer = producer;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    @Override
    public String toString() {
        return super.toString()+ "DairyProduct{" +
                "Producer='" + Producer + '.';
    }
}
