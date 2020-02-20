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
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> records = shop.getCoffeeProducts();
        for (Product record : records) {
            assertTrue(record instanceof Coffee);
        }
    }

    @Test
    public void getCoffeeProductsRecordsAll() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> records = shop.getCoffeeProducts();
        assertEquals(3, records.size());
    }

    @Test
    public void getCoffeeByPriceRange() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> records = shop.getCoffeeByPriceRange(23, 45);
        for (Product record : records) {
            assertTrue(record.getPrice() >= 23 && record.getPrice() <= 45);
        }
    }

    @Test
    public void getCoffeeByPriceRangeIncorrectMinMax() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> records = shop.getCoffeeByPriceRange(23, 20);
        assertEquals(0, records.size());
    }

    @Test
    public void getCoffeeByAmountRange() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> records = shop.getCoffeeByAmountRange(23, 45);
        for (Product record : records) {
            assertTrue(record.getAmount() >= 23 && record.getAmount() <= 45);
        }
    }

    @Test
    public void getCoffeeByAmountRangeIncorrectMinMax() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> records = shop.getCoffeeByAmountRange(23, 20);
        assertEquals(0, records.size());
    }

    @Test
    public void sortByPriceAndWeight() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> records = shop.sortByPriceAndWeight();
        Coffee prevCoffee = (Coffee) records.get(0);
        double prevCoffeeVal = (double) prevCoffee.getWeightPerPiece() / prevCoffee.getPrice();
        for (Product record : records) {
            Coffee coffee = (Coffee) record;
            double val = (double) coffee.getWeightPerPiece() / coffee.getPrice();
            assertTrue(val >= prevCoffeeVal);
            prevCoffeeVal = val;
        }
    }

    @Test
    public void isAvailableAmount1() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        LoadTypes.ORDINARY_LOAD.get(0).setAmount(4);
        assertTrue(shop.isAvailableAmount(LoadTypes.ORDINARY_LOAD.get(0), 3));
    }

    @Test
    public void isAvailableAmount2() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        LoadTypes.ORDINARY_LOAD.get(0).setAmount(4);
        assertTrue(shop.isAvailableAmount(LoadTypes.ORDINARY_LOAD.get(0), 4));
    }

    @Test
    public void isAvailableAmount3() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        LoadTypes.ORDINARY_LOAD.get(0).setAmount(4);
        assertFalse(shop.isAvailableAmount(LoadTypes.ORDINARY_LOAD.get(0), 666));
    }

    @Test
    public void getCoffeeRecord() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        try {
            assertEquals(LoadTypes.ORDINARY_LOAD.get(0),
                    shop.getCoffee(((Coffee) LoadTypes.ORDINARY_LOAD.get(0)).getOrigin(),
                            ((Coffee) LoadTypes.ORDINARY_LOAD.get(0)).getState()));
        } catch (NoRecordInDBException e) {
            fail();
        }
    }

    @Test(expected = NoRecordInDBException.class)
    public void getCoffeeRecordException() throws NoRecordInDBException {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        shop.getCoffee("f", CoffeeState.BEANS);
    }

    @Test
    public void sell() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        try {
            shop.sell(LoadTypes.ORDINARY_LOAD.get(0), 1);
        } catch (NoProductLeftException e) {
            fail();
        }
    }

    @Test(expected = NoProductLeftException.class)
    public void sellException() throws NoProductLeftException {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        shop.sell(LoadTypes.ORDINARY_LOAD.get(0), 100);
    }
}