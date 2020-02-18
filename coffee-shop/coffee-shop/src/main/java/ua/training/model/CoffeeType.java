package ua.training.model;

public class CoffeeType {
    private String origin;
    private CoffeeState state;
    private String weightPerPiece;

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

    public String getWeightPerPiece() {
        return weightPerPiece;
    }

    public void setWeightPerPiece(String weightPerPiece) {
        this.weightPerPiece = weightPerPiece;
    }
}
