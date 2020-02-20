package ua.training.model.entity;

import ua.training.exception.NoProductLeftException;
import ua.training.exception.NoRecordInDBException;

import java.util.*;

/**
 * Фургон кофе. Загрузить фургон определенного объема грузом на
 * определенную сумму из различных сортов кофе, находящихся в тому же в
 * разных физических состояниях (зерно, молотый, растворимый в банках и
 * пакетиках). Учитывать объем кофе вместе с упаковкой.
 * Провести сортировку товаров на основе соотношения цены и веса.
 * Найти товар в фургоне, соответствующий заданному диапазону параметров качества.
 */
public class CoffeeShop implements Shop {

    /**
     * Поле денег в кассе
     */
    private int money;
    private List<Product> coffeeShopProducts;

    public CoffeeShop() {
        this.money = 0;
        this.coffeeShopProducts = new ArrayList<>();
    }

    public void loadProducts(List<Product> newProducts) {
        coffeeShopProducts.addAll(newProducts);
    }

    /**
     * Получение кофе из всех продуктов
     *
     * @return Список записей из DBCoffeeShop, поле Product которого имеет тип Coffee
     * @see Coffee
     */
    public List<Product> getCoffeeProducts() {
        List<Product> coffeeProducts = new ArrayList<>();
        for (Product product : coffeeShopProducts) {
            if (product instanceof Coffee) {
                coffeeProducts.add(product);
            }
        }
        return coffeeProducts;
    }

    /**
     * Получение кофе c ценой из заданного диапазона(включительно)
     *
     * @param minPrice нижняя граница диапазона цены (в копейках)
     * @param maxPrice верхняя граница диапазона цены (в копейках)
     * @return Список записей из DBCoffeeShop, поле Product которого имеет тип Coffee с ценой в заданном диапазоне
     * @see Coffee
     */
    public List<Product> getCoffeeByPriceRange(int minPrice, int maxPrice) {
        List<Product> products = new ArrayList<>();
        for (Product product : getCoffeeProducts()) {
            Coffee coffee = (Coffee) product;
            if (coffee.getPrice() >= minPrice && coffee.getPrice() <= maxPrice) {
                products.add(product);
            }
        }
        return products;
    }

    /**
     * Получение кофе количество которого в заданном диапазоне(включительно)
     *
     * @param minAmount нижняя граница диапазона
     * @param maxAmount верхняя граница диапазона
     * @return Список записей из DBCoffeeShop, поле Product которого имеет тип Coffee,
     * @see Coffee
     */
    public List<Product> getCoffeeByAmountRange(int minAmount, int maxAmount) {
        List<Product> products = new ArrayList<>();
        for (Product product : getCoffeeProducts()) {
            if (product.getAmount() >= minAmount && product.getAmount() <= maxAmount) {
                products.add(product);
            }
        }
        return products;
    }

    /**
     * @return Отсортированный список записей из DBCoffeeShop в соответствии с соотношением цена - вес
     */
    public List<Product> sortByPriceAndWeight() {
        List<Product> sortedProducts = getCoffeeProducts();
        sortedProducts.sort(Comparator.comparingDouble(x ->
                (double) ((Coffee) x).getWeightPerPiece() / x.getPrice()));
        return sortedProducts;
    }

    /**
     * @param product запись пробукта в DBCoffeeShop
     * @param amount  количество
     * @return доступен ли данный продукт в данном количестве
     */
    public boolean isAvailableAmount(Product product, int amount) {
        return product.getAmount() >= amount;
    }


    /**
     * @param origin      происходжение кофе
     * @param coffeeState состояние кофе
     * @return запись в DBCoffeeShop кофе
     * @throws NoRecordInDBException запись с такими параметрами не найдена
     * @see CoffeeState
     * @see NoRecordInDBException
     */
    public Product getCoffee(String origin, CoffeeState coffeeState) throws NoRecordInDBException {
        for (Product product : getCoffeeProducts()) {
            Coffee coffee = (Coffee) product;
            if (coffee.getOrigin().equalsIgnoreCase(origin) &&
                    coffee.getState().toString().equalsIgnoreCase(coffeeState.toString())) {
                return product;
            }
        }
        throw new NoRecordInDBException();
    }

    /**
     * Добавляет деньги в кассу, уменьшает количество продаваемого продукта
     *
     * @param product запись пробукта в DBCoffeeShop
     * @param amount  количество для продажи
     * @throws NoProductLeftException количество продукта в DBCoffeeShop меньше требуемого
     * @see NoProductLeftException
     */
    public void sell(Product product, int amount) throws NoProductLeftException {
        if (!isAvailableAmount(product, amount)) throw new NoProductLeftException();
        else {
            product.setAmount(product.getAmount() - amount);
            money += product.getPrice();
        }
    }

}
