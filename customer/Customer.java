package lab9.exercise1.customer;

import lab9.exercise1.exceptions.WrongRequestException;
import lab9.exercise1.item.Item;
import lab9.exercise1.primaryEquipment.Skies;
import lab9.exercise1.primaryEquipment.Snowboard;
import lab9.exercise1.secondaryEquipment.*;
import lab9.exercise1.skiPass.SkiPass;
import lab9.exercise1.stock.Stock;

import java.util.ArrayList;

public class Customer {
    public int id;
    public String name;
    public static int idCounter = 1;
    public ArrayList<Item> rentedItems = new ArrayList<>();
    public int dateOfRent;
    public int dateToReturn;

    public Customer(String name, int dateOfRent, int dateToReturn) {
        this.name = name;
        this.dateOfRent = dateOfRent;
        this.dateToReturn = dateToReturn;

        id = idCounter++;
    }

    public void rents(int[] requestedItems) throws WrongRequestException{
        check(requestedItems);

        for (int item :
                requestedItems) {
            Stock.reduceItems(item, 1);
            switch (item) {
                case 1:
                    rentedItems.add(new Skies());
                    break;
                case 2:
                    rentedItems.add(new Snowboard());
                    break;
                case 3:
                    rentedItems.add(new Helmet());
                    break;
                case 4:
                    rentedItems.add(new Goggles());
                    break;
                case 5:
                    rentedItems.add(new SkiSticks());
                    break;
                case 6:
                    rentedItems.add(new SkiBoots());
                    break;
                case 7:
                    rentedItems.add(new SnowboardBoots());
                    break;
                case 8:
                    rentedItems.add(new SkiPass());
                    break;
                default:
                    break;
            }
        }
    }

    private boolean check(int[] requestedItems) throws WrongRequestException {
        // Customer should rent either skies or a snowboard
        boolean primaryCheck = contains(requestedItems, 1)
                ^ contains(requestedItems, 2);

        // Customer can rent secondary items that are related to the primary item
        // and if primaryCheck is true
        boolean secondaryCheck = !((contains(requestedItems, 1)
                    && contains(requestedItems, 7))
                || (contains(requestedItems, 2)
                    && contains(requestedItems, 5)
                    && contains(requestedItems, 6)));


        if (!(primaryCheck && secondaryCheck)) {
            throw new WrongRequestException("Something is wrong. Try again. Look at the rules.");
        }

        return true;
    }

    private boolean contains(int[] array, int number) {
        for (int tmp :
                array) {
            if (tmp == number) {
                return true;
            }
        }

        return false;

    }

    public void returns(int[] itemsToReturn) {
        for (int item :
                itemsToReturn) {
            Stock.addItems(item, 1);
        }
        rentedItems = null;
    }

    public int outOfDateFee() {
        return 5000;
    }
}
