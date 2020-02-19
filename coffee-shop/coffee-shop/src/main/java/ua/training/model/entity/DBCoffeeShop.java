package ua.training.model.entity;


public enum DBCoffeeShop {

    COFFEE_1(new Coffee("BRAZIL", CoffeeState.BEANS, 100, 34), 4),
    COFFEE_2(new Coffee("COLUMBIA", CoffeeState.BEANS, 100, 45), 4),
    COFFEE_3(new Coffee("BRAZIL", CoffeeState.GROUND, 100, 56), 4);

    private Product product;
    private int amount;

    DBCoffeeShop(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
