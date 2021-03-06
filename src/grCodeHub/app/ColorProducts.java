package grCodeHub.app;

public class ColorProducts extends Product implements Printable{
    private String color;

    public ColorProducts(String code, String name, float price, int quantity, String color) {
        super(code, name, price, quantity);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString()+ "ColorProducts{" +
                "color='" + color + '\'' +
                '}';
    }

    @Override
    public void print() {
        System.out.println("color is= " +color);
    }
}
