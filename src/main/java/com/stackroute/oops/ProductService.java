package com.stackroute.oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
    Class for Analyzing the products present in ProductRepository
 */
public class ProductService {


    /*
        Returns the name of the product given the productCode
     */
    public String findProductNameByCode(int productCode) {
       Product[] prod =  ProductRepository.getProducts();
       for(Product pr:prod)
       {
           if (pr.getProductCode()==productCode)
           {
               return pr.getName();
           }
       }
        return null;
    }

    /*
        Returns the Product with maximum price in a given category
     */
    public Product findMaxPriceProductInCategory(String category) {
        Product[] prod =  ProductRepository.getProducts();
        double max=0;
        for(Product pr:prod)
        {
            if (Objects.equals(pr.getCategory(), category))
            {
                max=Math.max(max, pr.getPrice());
            }
        }
        for(Product pr:prod)
        {
            if (pr.getPrice()==max)
            {
                return pr;
            }
        }

        return null;
    }

    /*
        Returns a array of products for a given category
     */
    public Product[] getProductsByCategory(String category) {
        Product[] prod =  ProductRepository.getProducts();
        List<Product> productList = new ArrayList<>();

        for(Product pr:prod)
        {
            if (Objects.equals(pr.getCategory(), category))
            {
                productList.add(pr);
            }
        }
        if(productList.isEmpty())
            return null;


        return productList.toArray(new Product[0]);
    }
}
