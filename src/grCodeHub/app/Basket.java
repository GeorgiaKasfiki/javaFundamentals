package grCodeHub.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Basket {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Product p : products) {
            System.out.println(p);
        }

        //System.out.println(products);

        //printing using lambda calculus
        products.forEach(product -> System.out.println(product));
        // more modern writing
        products.forEach(System.out::println);
    }

    public void removeProduct(int index) {
        if (index >= 0 && index < products.size()) {
            products.remove(index);
        }
    }

    public void clearProducts() {
        products.clear();
    }

    public float getTotalCoast() {
       float totalProductPrice = 0;

//        //1st
//        float totalCost = 0;
//        for (int i = 0; i < products.size(); i++) {
//            totalCost += products.get(i).getPrice() + products.get(i).getQuantity();
//        }
//        //2nd
//        totalProductPrice =0;
//        for (Product p : products){
//            totalProductPrice += p.getPrice() * p.getQuantity();
//        }

        //3rd (lambda calculus)
        totalProductPrice = products.stream().map(p -> p.getPrice() * p.getQuantity()).reduce(0f,(a,b) -> a+b);

        return totalProductPrice;
    }
    public void saveBasket(String filename)  {
        try {
            PrintWriter printWriter = new PrintWriter( new File(filename));
            for (Product p : products){
                printWriter.println(p.getCode()+ ", "+p.getName()+", "+ p.getPrice()+", "+ p.getQuantity()+".");
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be save.");
        }

    }
    public void loadBasket(String filename){
        products.clear();
        try{
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",");
                Product product = new ColorProducts(
                                            words[0],
                                            words[1],
                                            Float.parseFloat(words[2]),
                                            Integer.parseInt((words[3])), "black" );
                products.add(product);
            }
        } catch (Exception e) {}
    }


}
