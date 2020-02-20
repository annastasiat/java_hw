package ua.training.model.entity;

public class Coffee extends Product {

    private final String origin;
    private final CoffeeState state;
    private final int weightPerPiece;

    public Coffee(String origin, CoffeeState state, int weightPerPiece, int price, int amount) {
        super(price, amount);
        this.origin = origin;
        this.state = state;
        this.weightPerPiece = weightPerPiece;
    }

    public String getOrigin() {
        return origin;
    }

    public CoffeeState getState() {
        return state;
    }

    public int getWeightPerPiece() {
        return weightPerPiece;
    }

}
