package grCodeHub.app;

import java.util.ArrayList;
import java.lang.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UI userInterface = new UI();
        Basket basket = new Basket();
        userInterface.manageBasket(basket);

    }

}
