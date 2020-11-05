package lab9.exercise1;

import lab9.exercise1.customer.Customer;
import lab9.exercise1.exceptions.WrongRequestException;
import lab9.exercise1.menu.Menu;
import lab9.exercise1.stock.Stock;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.menu();
        int currentDate = 100;
        Stock stock = new Stock();
        System.out.println(stock.stock.toString());

        Customer customer = new Customer("Slava", 5, 10);
        int[] request;
        while (true) {
            try {
                request = makeRequest();
                customer.rents(request);
                break;
            } catch (WrongRequestException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(customer.rentedItems.toString());
        System.out.println(stock.stock.toString());
        customer.returns(request);
        System.out.println(stock.stock.toString());



        if (currentDate > customer.dateToReturn) {
            System.out.println(customer.outOfDateFee());
        }
    }

    /* This method converts the request string to an array of integers */
    private static int[] makeRequest() {
        Scanner sc = new Scanner(System.in);
        String[] request = sc.nextLine().split(" ");
        int[] intArray = new int[request.length];
        for (int i = 0; i < request.length; i++) {
            intArray[i] = Integer.parseInt(request[i]);
        }

        return intArray;
    }
}
