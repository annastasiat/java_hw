package ua.training.model.entity;

import org.junit.Test;
import ua.training.exception.NoRecordInDBException;

import java.util.List;

import static org.junit.Assert.*;

public class CoffeeShopTest {

    @Test
    public void getCoffeeProductsRecordsAllAreCoffee() {
        CoffeeShop shop = new CoffeeShop();
        List<DBCoffeeShop> records = shop.getCoffeeProductsRecords();
        for(DBCoffeeShop record:records){
            assertTrue(record.getProduct() instanceof Coffee);
        }
    }

    @Test
    public void getCoffeeProductsRecordsAll() {
        CoffeeShop shop = new CoffeeShop();
        List<DBCoffeeShop> records = shop.getCoffeeProductsRecords();
        assertEquals(3, records.size());
    }

    @Test
    public void getCoffeeByPriceRange() {
        CoffeeShop shop = new CoffeeShop();
        List<DBCoffeeShop> records = shop.getCoffeeByPriceRange(23, 45);
        for(DBCoffeeShop record:records){
            assertTrue(record.getProduct().getPrice()>=23&&record.getProduct().getPrice()<=45);
        }
    }
    @Test
    public void getCoffeeByPriceRangeIncorrectMinMax() {
        CoffeeShop shop = new CoffeeShop();
        List<DBCoffeeShop> records = shop.getCoffeeByPriceRange(23, 20);
        assertEquals(0, records.size());
    }
    @Test
    public void getCoffeeByAmountRange() {
        CoffeeShop shop = new CoffeeShop();
        List<DBCoffeeShop> records = shop.getCoffeeByAmountRange(23, 45);
        for(DBCoffeeShop record:records){
            assertTrue(record.getAmount()>=23&&record.getAmount()<=45);
        }
    }
    @Test
    public void getCoffeeByAmountRangeIncorrectMinMax() {
        CoffeeShop shop = new CoffeeShop();
        List<DBCoffeeShop> records = shop.getCoffeeByAmountRange(23, 20);
        assertEquals(0, records.size());
    }

    @Test
    public void sortByPriceAndWeight() {
        CoffeeShop shop = new CoffeeShop();
        List<DBCoffeeShop> records = shop.sortByPriceAndWeight();
        Coffee prevCoffee = (Coffee)records.get(0).getProduct();
        double prevCoffeeVal = (double) prevCoffee.getWeightPerPiece()/prevCoffee.getPrice();
        for(DBCoffeeShop record:records){
            Coffee coffee = (Coffee)record.getProduct();
            double val = (double)coffee.getWeightPerPiece()/coffee.getPrice();
            assertTrue(val >= prevCoffeeVal);
            prevCoffeeVal = val;
        }
    }
/*
    @Test
    public void isAvailableAmount1() {
        CoffeeShop shop = new CoffeeShop();
        DBCoffeeShop.COFFEE_1.setAmount(4);
        try {
            shop.isAvailableAmountCoffeeType((Coffee)DBCoffeeShop.COFFEE_1.getProduct(), 3);
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void isAvailableAmount2() {
        CoffeeShop shop = new CoffeeShop();
        DBCoffeeShop.COFFEE_1.setAmount(4);
        try {
            shop.isAvailableAmountCoffeeType((Coffee)DBCoffeeShop.COFFEE_1.getProduct(), 4);
        } catch (Exception e) {
            fail();
        }
    }
    @Test()
    public void isAvailableAmount3() {
        CoffeeShop shop = new CoffeeShop();
        DBCoffeeShop.COFFEE_1.setAmount(4);
        try {
            assertFalse(shop.isAvailableAmountCoffeeType((Coffee) DBCoffeeShop.COFFEE_1.getProduct(), 5));
        } catch (NoRecordInDBException e) {
            fail();
        }
    }

    @Test
    public void getCoffeeRecord() {
        CoffeeShop shop = new CoffeeShop();
        try {
            shop.getCoffeeRecord((Coffee) DBCoffeeShop.COFFEE_2.getProduct());
        } catch (NoRecordInDBException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = NoRecordInDBException.class)
    public void getCoffeeRecordException() throws  NoRecordInDBException {
        CoffeeShop shop = new CoffeeShop();
        shop.getCoffeeRecord(new Coffee("ff", CoffeeState.BEANS, 6, 6 ));
    }

    @Test
    public void sell() {

    }*/
}