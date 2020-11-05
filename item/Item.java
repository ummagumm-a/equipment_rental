package lab9.exercise1.item;

public abstract class Item {
    Item typeOfItem;
    int rentDate;
    int returnDate;
    int price;

    public abstract void toRent(String requestedItems);
    public abstract void toReturn(String itemsToReturn);
    public abstract void isOutOfDateFee();
}
