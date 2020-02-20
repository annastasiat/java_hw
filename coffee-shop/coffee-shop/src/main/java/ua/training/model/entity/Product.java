package ua.training.model.entity;

public class Product {
    /**
     * Цена в копейках
     */
    private int price;

    public Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    /**
     * @return Цена в грн
     */
    public double getPriceDouble() {
        return price / 100.0;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
