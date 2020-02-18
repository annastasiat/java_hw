package ua.training.model;

import java.util.*;

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
    private Set<Coffee> coffeeList = new HashSet<>();
    private final int VOLUME = 200;

    public Set<Coffee> getCoffeeByPriceRange(int minPrice, int maxPrice){
        Set<Coffee> coffeeInPriceRange = new HashSet<>();
        for(Coffee coffee:coffeeList){
            int price = coffee.getPrice();
            if(price>=minPrice&&price<=maxPrice){
                coffeeInPriceRange.add(coffee);
            }
        }
        return coffeeInPriceRange;
    }

    public Set<Coffee> getCoffeeByAmountRange(int minAmount, int maxAmount){
        Set<Coffee> coffeeInAmountRange = new HashSet<>();
        for(Coffee coffee:coffeeList){
            int amount = coffee.getAmount();
            if(amount>=minAmount&&amount<=maxAmount){
                coffeeInAmountRange.add(coffee);
            }
        }
        return coffeeInAmountRange;
    }

    public List<Coffee> sortByPrice() { //no deep copy
        List<Coffee> sortedCoffeeList = new ArrayList<>(coffeeList);
        sortedCoffeeList.sort(Comparator.comparingInt(Product::getPrice));
        return sortedCoffeeList;

    }

    public List<Coffee> sortByWeight() { //no deep copy
        List<Coffee> sortedCoffeeList = new ArrayList<>(coffeeList);
        sortedCoffeeList.sort(Comparator.comparingInt(Product::getPrice));
        return sortedCoffeeList;

    }

    public void loadCoffee(Coffee ... coffees){
        for(Coffee coffee:coffees){
            if(isAvailable(coffee.getCoffeeType())){
                coffeeList.
            }
        }
    }

    public boolean isAvailable(CoffeeType coffeeType){
        return coffeeList.contains(new Coffee(coffeeType));
    }

    public void sell(CoffeeType coffeeToSell){
        if()
        for(Coffee coffee: coffeeList){
            if(coffee.getCoffeeType().equals(coffeeToSell)){
                coffee.setAmount(coffee.getAmount()-1);
            }

        }
    }




}
