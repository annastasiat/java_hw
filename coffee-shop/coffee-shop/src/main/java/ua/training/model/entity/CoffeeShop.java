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

    public CoffeeShop() {
        this.money = 0;
    }

    /**
     * Получение кофе из всех продуктов
     * @return Список записей из DBCoffeeShop, поле Product которого имеет тип Coffee
     * @see DBCoffeeShop
     * @see Coffee
     */
    public List<DBCoffeeShop> getCoffeeProductsRecords() {
        List<DBCoffeeShop> coffeeRecords = new ArrayList<>();
        for (DBCoffeeShop record : DBCoffeeShop.values()) {
            if (record.getProduct() instanceof Coffee) {
                coffeeRecords.add(record);
            }
        }
        return coffeeRecords;
    }

    /**
     * Получение кофе c ценой из заданного диапазона(включительно)
     *
     * @param minPrice нижняя граница диапазона цены (в копейках)
     * @param maxPrice верхняя граница диапазона цены (в копейках)
     * @return Список записей из DBCoffeeShop, поле Product которого имеет тип Coffee с ценой в заданном диапазоне
     * @see DBCoffeeShop
     * @see Coffee
     */
    public List<DBCoffeeShop> getCoffeeByPriceRange(int minPrice, int maxPrice) {
        List<DBCoffeeShop> records = new ArrayList<>();
        for (DBCoffeeShop record : getCoffeeProductsRecords()) {
            Coffee coffee = (Coffee) record.getProduct();
            if (coffee.getPrice() >= minPrice && coffee.getPrice() <= maxPrice) {
                records.add(record);
            }
        }
        return records;
    }

    /**
     * Получение кофе количество которого в заданном диапазоне(включительно)
     *
     * @param minAmount нижняя граница диапазона
     * @param maxAmount верхняя граница диапазона
     * @return Список записей из DBCoffeeShop, поле Product которого имеет тип Coffee,
     * а поле Amount находится в заданном диапазоне (включительно)
     * @see DBCoffeeShop
     * @see Coffee
     */
    public List<DBCoffeeShop> getCoffeeByAmountRange(int minAmount, int maxAmount) {
        List<DBCoffeeShop> records = new ArrayList<>();
        for (DBCoffeeShop record : getCoffeeProductsRecords()) {
            if (record.getAmount() >= minAmount && record.getAmount() <= maxAmount) {
                records.add(record);
            }
        }
        return records;
    }

    /**
     * @return Отсортированный список записей из DBCoffeeShop в соответствии с соотношением цена - вес
     * @see DBCoffeeShop
     */
    public List<DBCoffeeShop> sortByPriceAndWeight() {
        List<DBCoffeeShop> sortedRecords = getCoffeeProductsRecords();
        sortedRecords.sort(Comparator.comparingDouble(x ->
                (double) ((Coffee) x.getProduct()).getWeightPerPiece() / x.getProduct().getPrice()));
        return sortedRecords;
    }

    /**
     * @param record запись пробукта в DBCoffeeShop
     * @param amount количество
     * @return доступен ли данный продукт в данном количестве
     * @see DBCoffeeShop
     */
    public boolean isAvailableAmount(DBCoffeeShop record, int amount) {
        return record.getAmount() >= amount;
    }


    /**
     * @param origin      происходжение кофе
     * @param coffeeState состояние кофе
     * @return запись в DBCoffeeShop кофе
     * @throws NoRecordInDBException запись с такими параметрами не найдена
     * @see CoffeeState
     * @see NoRecordInDBException
     */
    public DBCoffeeShop getCoffeeInDB(String origin, CoffeeState coffeeState) throws NoRecordInDBException {
        List<DBCoffeeShop> coffeeRecords = getCoffeeProductsRecords();
        for (DBCoffeeShop record : coffeeRecords) {
            Coffee coffee = (Coffee) record.getProduct();
            if (coffee.getOrigin().equalsIgnoreCase(origin) &&
                    coffee.getState().toString().equalsIgnoreCase(coffeeState.toString())) {
                return record;
            }
        }
        throw new NoRecordInDBException();
    }

    /**
     * Добавляет деньги в кассу, уменьшает количество продаваемого продукта
     *
     * @param record запись пробукта в DBCoffeeShop
     * @param amount       количество для продажи
     * @throws NoProductLeftException количество продукта в DBCoffeeShop меньше требуемого
     * @see DBCoffeeShop
     * @see NoProductLeftException
     */
    public void sell(DBCoffeeShop record, int amount) throws NoProductLeftException {
        if (!isAvailableAmount(record, amount)) throw new NoProductLeftException();
        else {
            record.setAmount(record.getAmount() - amount);
            money += record.getProduct().getPrice();
        }
    }

}
