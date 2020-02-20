package ua.training.model.entity;


public enum DBCoffeeShop {

    PRODUCT_1(new Coffee("BRAZIL", CoffeeState.BEANS, 100, 3400), 4),
    PRODUCT_2(new Coffee("COLOMBIA", CoffeeState.BEANS, 100, 4500), 4),
    PRODUCT_3(new Coffee("BRAZIL", CoffeeState.GROUND, 200, 6600), 4);

    private final Product product;
    private int amount;

    DBCoffeeShop(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
