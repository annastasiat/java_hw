package ua.training.model.entity;

public class Product {
    /**
     * Цена в копейках
     */
    private int price;
    private int amount;

    public Product(int price, int amount) {
        this.price = price;
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
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

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
