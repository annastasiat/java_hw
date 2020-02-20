package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public interface LoadTypes {
    public static final List<Product> ORDINARY_LOAD = new ArrayList<Product>() {{
        add(new Coffee("BRAZIL", CoffeeState.BEANS, 100, 3400, 4));
        add(new Coffee("COLOMBIA", CoffeeState.BEANS, 100, 4500, 4));
        add(new Coffee("BRAZIL", CoffeeState.GROUND, 200, 6600, 4));
    }};
}

