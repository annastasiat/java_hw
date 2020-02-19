package ua.training.model.entity;

import ua.training.exception.NoProductLeftException;
import ua.training.exception.NoRecordInDBException;

import java.util.*;

/**
 * Класс shop
 *
 * @autor me
 */
public class CoffeeShop {

    /**
     * Поле денег в кассе
     */
    private int money;

    public CoffeeShop() {
        this.money = 0;
    }

    /**
     * Получение кофе из всех продуктов
     *
     * @return Список записей из DBCoffeeShop, поле Product которого имеет тип Coffee
     * @see DBCoffeeShop
     * @see Coffee
     */
    public List<DBCoffeeShop> getCoffeeProductsRecords() {
        List<DBCoffeeShop> records = new ArrayList<>();
        for (DBCoffeeShop record : DBCoffeeShop.values()) {
            if (record.getProduct() instanceof Coffee) {
                records.add(record);
            }
        }
        return records;
    }

    /**
     * Получение кофе c ценой из заданного диапазона(включительно)
     *
     * @param minPrice нижняя граница диапазона цены
     * @param maxPrice верхняя граница диапазона цены
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
     * @param coffeeRecord запись пробукта в DBCoffeeShop
     * @param amount       количество для продажи
     * @throws NoProductLeftException количество продукта в DBCoffeeShop меньше требуемого
     * @see DBCoffeeShop
     * @see NoProductLeftException
     */
    public void sell(DBCoffeeShop coffeeRecord, int amount) throws NoProductLeftException {
        if (!isAvailableAmount(coffeeRecord, amount)) throw new NoProductLeftException();
        else {
            coffeeRecord.setAmount(coffeeRecord.getAmount() - amount);
            money += coffeeRecord.getProduct().getPrice();
        }
    }

}

    /*public DBCoffeeShop getCoffeeRecord(Coffee coffeeType) throws NoRecordInDBException {
        for(DBCoffeeShop record:DBCoffeeShop.values()){
            if(record.getProduct().equals(coffeeType)){
                return record;
            }
        }
        throw new NoRecordInDBException();
    }*/
    /*public void sellCoffeeType(Coffee coffeeToSell, int amount) throws NoProductLeftException, NoRecordInDBException {
        if(!isAvailableAmountCoffeeType(coffeeToSell, amount)) throw new NoProductLeftException();
        else {
            DBCoffeeShop recordToModify = getCoffeeRecord(coffeeToSell);
            recordToModify.setAmount(recordToModify.getAmount()-amount);
            money += recordToModify.getProduct().getPrice();
        }
    }*/


    /*public boolean isAvailableAmountCoffeeType(Coffee coffeeType, int amount) throws NoRecordInDBException {
        return getCoffeeRecord(coffeeType).getAmount()>=amount;
    }*/