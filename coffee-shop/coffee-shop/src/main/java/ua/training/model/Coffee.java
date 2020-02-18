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

public class Coffee{
    private CoffeTypes coffeType;
    private int amount;


    public CoffeTypes getCoffeType() {
        return coffeType;
    }

    public void setCoffeType(CoffeTypes coffeType) {
        this.coffeType = coffeType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
