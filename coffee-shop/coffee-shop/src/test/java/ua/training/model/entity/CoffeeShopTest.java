package ua.training.model.entity;

import org.junit.Test;
import ua.training.exception.NoProductLeftException;
import ua.training.exception.NoRecordInDBException;

import java.util.List;

import static org.junit.Assert.*;

public class CoffeeShopTest {

    @Test
    public void getCoffeeProductsRecordsAllAreCoffee() {
        CoffeeShop shop = new CoffeeShop();
        List<DBCoffeeShop> records = shop.getCoffeeProductsRecords();
        for (DBCoffeeShop record : records) {
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
        for (DBCoffeeShop record : records) {
            assertTrue(record.getProduct().getPrice() >= 23 && record.getProduct().getPrice() <= 45);
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
        for (DBCoffeeShop record : records) {
            assertTrue(record.getAmount() >= 23 && record.getAmount() <= 45);
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
        Coffee prevCoffee = (Coffee) records.get(0).getProduct();
        double prevCoffeeVal = (double) prevCoffee.getWeightPerPiece() / prevCoffee.getPrice();
        for (DBCoffeeShop record : records) {
            Coffee coffee = (Coffee) record.getProduct();
            double val = (double) coffee.getWeightPerPiece() / coffee.getPrice();
            assertTrue(val >= prevCoffeeVal);
            prevCoffeeVal = val;
        }
    }

    @Test
    public void isAvailableAmount1() {
        CoffeeShop shop = new CoffeeShop();
        DBCoffeeShop.PRODUCT_1.setAmount(4);
        assertTrue(shop.isAvailableAmount(DBCoffeeShop.PRODUCT_1, 3));
    }

    @Test
    public void isAvailableAmount2() {
        CoffeeShop shop = new CoffeeShop();
        DBCoffeeShop.PRODUCT_1.setAmount(4);
        assertTrue(shop.isAvailableAmount(DBCoffeeShop.PRODUCT_1, 4));
    }


    @Test()
    public void isAvailableAmount3() {
        CoffeeShop shop = new CoffeeShop();
        DBCoffeeShop.PRODUCT_1.setAmount(4);
        assertFalse(shop.isAvailableAmount(DBCoffeeShop.PRODUCT_1, 5));
    }

    @Test
    public void getCoffeeRecord() {
        CoffeeShop shop = new CoffeeShop();
        try {
            assertEquals(DBCoffeeShop.PRODUCT_1,
                    shop.getCoffeeInDB(((Coffee) DBCoffeeShop.PRODUCT_1.getProduct()).getOrigin(),
                            ((Coffee) DBCoffeeShop.PRODUCT_1.getProduct()).getState()));
        } catch (NoRecordInDBException e) {
            fail();
        }
    }

    @Test(expected = NoRecordInDBException.class)
    public void getCoffeeRecordException() throws NoRecordInDBException {
        CoffeeShop shop = new CoffeeShop();
        shop.getCoffeeInDB("f", CoffeeState.BEANS);
    }

    @Test
    public void sell() {
        CoffeeShop shop = new CoffeeShop();
        try {
            shop.sell(DBCoffeeShop.PRODUCT_1, 1);
        } catch (NoProductLeftException e) {
            fail();
        }
    }

    @Test(expected = NoProductLeftException.class)
    public void sellException() throws NoProductLeftException {
        CoffeeShop shop = new CoffeeShop();
        shop.sell(DBCoffeeShop.PRODUCT_1, 100);
    }
}