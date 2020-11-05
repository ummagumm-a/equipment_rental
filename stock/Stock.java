package lab9.exercise1.stock;

import java.util.HashMap;

public class Stock {
    public static HashMap<Integer, Integer> stock = new HashMap<>();

    {
        stock.put(1, 10);
        stock.put(2, 10);
        stock.put(3, 10);
        stock.put(4, 10);
        stock.put(5, 10);
        stock.put(6, 10);
        stock.put(7, 10);
        stock.put(8, 10);
    }

    public static void addItems(int item, int numberOfItemsToAdd) {
        int tmp = stock.get(item);
        stock.put(item, tmp + numberOfItemsToAdd);
    }

    public static void reduceItems(int item, int numberOfItemsToReduce) {
        int tmp = stock.get(item);
        if (tmp <= numberOfItemsToReduce) {
            stock.put(item, 1);
        } else {
            stock.put(item, tmp - numberOfItemsToReduce);
        }
    }
}
