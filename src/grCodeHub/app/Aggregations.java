package grCodeHub.app;

import java.util.*;
//lambda tutorial

//like the basket class, just for designing a tutorial
public class Aggregations {

    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    //increase the price for products using a specified rate
    public void applyIncreasePrice (float rate){
        products.forEach( p -> p.setPrice( p.getPrice() * (1+rate)));
    }

    //returns the most expensive product in the list
    public Product getMostExpensiveProduct(){

        Optional<Product> productsOptional = products.stream().max(Comparator.comparingDouble(Product::getPrice));

       if(productsOptional.isPresent()) {
           return productsOptional.get();
       }
       else{
           return null;
       }

    }

    //returns the least Expensive in the list
    public Product getLeastExpensiveProduct(){
        return products.stream().min(Comparator.comparingDouble(Product::getPrice)).get();
    }

    public float averagePrice() {
//        products.stream()
//                .map(p -> p.getPrice()).reduce(0.0f, (a, b) -> a + b) / products.size();

        return (float)  products.stream()
                            .mapToDouble(p-> p.getPrice())
                            .average().getAsDouble();
    }

}
