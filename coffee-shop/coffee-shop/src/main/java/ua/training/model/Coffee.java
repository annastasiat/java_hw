package ua.training.model;

/*
* Фургон кофе.
* Загрузить фургон определенного объема грузом на
определенную сумму из различных сортов кофе, находящихся в тому же в
разных физических состояниях (зерно, молотый, растворимый в банках и
пакетиках). Учитывать объем кофе вместе с упаковкой.
* Провести сортировку товаров на основе соотношения цены и веса.
* Найти товар в фургоне, соответствующий заданному диапазону параметров качества.
* */

import java.util.Objects;

public class Coffee  extends Product{
    private CoffeeType coffeeType;
    private int amount;

    public Coffee(CoffeeType coffeeType){
        this.coffeeType = coffeeType;
        this.amount = 0;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addItems(int amount) {
        this.amount = this.amount + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(coffeeType, coffee.coffeeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeType);
    }
}



/*
*
* public enum Coffee {
    BRASIL,
    COLUMBIAN;


    //
    private State beans;
    private State ground;
    private State instant;
    Coffee(){
        this.beans = new State(CoffeeState.BEANS, 0 ,0);
        this.ground = new State(CoffeeState.GROUND, 0 ,0);
        this.instant = new State(CoffeeState.INSTANT, 0 ,0);
    }

    Coffee(State beans, State ground, State instant) {
        this.beans = beans;
        this.ground = ground;
        this.instant = instant;
    }


}
    * */
