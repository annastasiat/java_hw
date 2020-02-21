package ua.training.model.entity;

import org.junit.Test;
import ua.training.exception.NoProductExistException;
import ua.training.exception.NoProductLeftException;

import java.util.List;

import static org.junit.Assert.*;

public class CoffeeShopTest {

    @Test
    public void getCoffeeProductsAllAreCoffee() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> products = shop.getCoffeeProducts();
        for (Product product : products) {
            assertTrue(product instanceof Coffee);
        }
    }

    @Test
    public void getCoffeeProductsAll() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> products = shop.getCoffeeProducts();
        assertEquals(3, products.size());
    }

    @Test
    public void getCoffeeByPriceRange() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> products = shop.getCoffeeByPriceRange(23, 45);
        for (Product product : products) {
            assertTrue(product.getPrice() >= 23 && product.getPrice() <= 45);
        }
    }

    @Test
    public void getCoffeeByPriceRangeIncorrectMinMax() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> products = shop.getCoffeeByPriceRange(23, 20);
        assertEquals(0, products.size());
    }

    @Test
    public void getCoffeeByAmountRange() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> products = shop.getCoffeeByAmountRange(23, 45);
        for (Product product : products) {
            assertTrue(product.getAmount() >= 23 && product.getAmount() <= 45);
        }
    }

    @Test
    public void getCoffeeByAmountRangeIncorrectMinMax() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> products = shop.getCoffeeByAmountRange(23, 20);
        assertEquals(0, products.size());
    }

    @Test
    public void sortByPriceAndWeight() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        List<Product> products = shop.sortByPriceAndWeight();
        Coffee prevCoffee = (Coffee) products.get(0);
        double prevCoffeeVal = (double) prevCoffee.getPrice() / prevCoffee.getWeightPerPiece();
        for (Product product : products) {
            Coffee coffee = (Coffee) product;
            double val = (double) coffee.getPrice() / coffee.getWeightPerPiece();
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
    public void getCoffeeProduct() {
        CoffeeShop shop = new CoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        try {
            assertEquals(LoadTypes.ORDINARY_LOAD.get(0),
                    shop.getCoffee(((Coffee) LoadTypes.ORDINARY_LOAD.get(0)).getOrigin(),
                            ((Coffee) LoadTypes.ORDINARY_LOAD.get(0)).getState()));
        } catch (NoProductExistException e) {
            fail();
        }
    }

    @Test(expected = NoProductExistException.class)
    public void getCoffeeException() throws NoProductExistException {
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