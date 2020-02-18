package ua.training.model;

import java.util.*;
import java.util.stream.Collectors;

/*
* Фургон кофе.
* Загрузить фургон определенного объема грузом на
определенную сумму из различных сортов кофе, находящихся в тому же в
разных физических состояниях (зерно, молотый, растворимый в банках и
пакетиках). Учитывать объем кофе вместе с упаковкой.
* Провести сортировку товаров на основе соотношения цены и веса.
* Найти товар в фургоне, соответствующий заданному диапазону параметров качества.
* */

public class CoffeeShop {
    private List<Coffee> coffeeList = new ArrayList<>();
    private final int VOLUME = 200;

    public List<Coffee> getCoffeeByPriceRange(int minPrice, int maxPrice){
        List<Coffee> coffeeInPriceRange = new ArrayList<>();
        for(Coffee coffee:coffeeList){
            int price = coffee.getCoffeType().getPrice();
            if(price>=minPrice&&price<=maxPrice){
                coffeeInPriceRange.add(coffee);
            }
        }
        return coffeeInPriceRange;
    }

    public List<Coffee> getCoffeeByAmountRange(int minAmount, int maxAmount){
        List<Coffee> coffeeInAmountRange = new ArrayList<>();
        for(Coffee coffee:coffeeList){
            int amount = coffee.getAmount();
            if(amount>=minAmount&&amount<=maxAmount){
                coffeeInAmountRange.add(coffee);
            }
        }
        return coffeeInAmountRange;
    }

    public List<Coffee> sortByPrice() {
        return Collections.sort(coffeeList, (a, b) ->
                a.getCoffeType().getPrice() < b.getCoffeType().getPrice() ? -1:
                        a.getCoffeType().getPrice() == b.getCoffeType().getPrice()?0:1);

    }

    public List<Coffee> sortByWeight() {

    }

    public void loadCoffee(){

    }

    public void sell(Coffee coffee){
        coffeeTypesAndAmounts.remove(coffee);
    }




}
