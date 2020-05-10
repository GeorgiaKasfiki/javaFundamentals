package grCodeHub.app;

import java.util.Scanner;

public class UI {

    public Choice menu(){

        Choice returnChoice;

        System.out.println("1. Add a product. \n 2. Remove a product." +
                "\n 3.Display basket. \n 4. Clear basket. \n 5. Total cost. \n 6. Save. \n 7. Load. \n 0. Exit");
        int choice;

        Scanner scanner = new Scanner(System.in);
        try{
            choice = scanner.nextInt();
            switch(choice){
                case 1: return Choice.ADD;
                case 2: return Choice.REMOVE;
                case 3: return Choice.DISPLAY;
                case 4: return Choice.CLEAR;
                case 5: return Choice.TOTALCOST;
                case 6: return Choice.SAVE;
                case 7: return Choice.LOAD;
                case 0: return Choice.EXIT;
                default: return Choice.ERROR;
            }
        }
        catch (Exception e){
            return Choice.ERROR;
        }

    }

    //factory method design pattern
    public Product createProduct() {
        String code, name;
        int quantity;
        float price;
        String color;
        String producer;
        int productType;

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. for dairy 2. for color product ");
        productType = scanner.nextInt();

        System.out.println("Give product Code");
        code = scanner.next();
        System.out.println("Give product Name");
        name = scanner.next();
        System.out.println("Give product Quantity");
        quantity = scanner.nextInt();
        System.out.println("Give product Price");
        price = scanner.nextFloat();

        Product product;
        switch (productType) {
            case 1:
                System.out.println("Give producer ");
                producer = scanner.next();
                product = new DairyProduct(code, name, price, quantity, producer);
                return product;
            case 2:
                System.out.println("Give color ");
                color = scanner.next();
                product = new ColorProducts(code, name, price, quantity, color);
                return product;
            default: return null;
        }
    }

    public void manageBasket(Basket basket){
        Choice choice;

        do {
            choice = menu();
            switch (choice) {
                case ADD:
                    Product product = createProduct();
                    basket.addProduct(product);
                    break;
                case REMOVE:
                    System.out.println("Give and index to remove");
                    Scanner scanner = new Scanner(System.in);
                    int index = scanner.nextInt();
                    basket.removeProduct(index);
                    break;
                case DISPLAY:
                    basket.displayProducts();
                    break;
                case CLEAR:
                    basket.clearProducts();
                    break;
                case TOTALCOST:
                    System.out.println("Total cost is " + basket.getTotalCoast() + "$");
                    break;
                case EXIT:
                case SAVE:
                    basket.saveBasket("basket.txt");
                    break;
                case LOAD:
                    basket.loadBasket("basket.txt");
                    break;
                case ERROR:
                    System.out.println("Wrong input.");
                    break;
            }
        }while(choice !=Choice.EXIT);
    }

}
