package ua.training.model.entity;

import java.util.Objects;

public class Coffee extends Product {

    private String origin;
    private CoffeeState state;
    private int weightPerPiece;

    public Coffee(String origin, CoffeeState state, int weightPerPiece, int price) {
        super(price);
        this.origin = origin;
        this.state = state;
        this.weightPerPiece = weightPerPiece;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public CoffeeState getState() {
        return state;
    }

    public void setState(CoffeeState state) {
        this.state = state;
    }

    public int getWeightPerPiece() {
        return weightPerPiece;
    }

    public void setWeightPerPiece(int weightPerPiece) {
        this.weightPerPiece = weightPerPiece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee that = (Coffee) o;
        return weightPerPiece == that.weightPerPiece &&
                Objects.equals(origin, that.origin) &&
                state == that.state && this.getPrice() == that.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, state, weightPerPiece, getPrice());
    }
}
