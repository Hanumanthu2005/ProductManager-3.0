package com.Hanu.ProductManagerSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    ProductDao dao;

    public List<Product> getAllProducts()
    {
        return dao.findAll();
    }

    public void save(Product product)
    {
        dao.save(product);
    }

    public Product getByName(String name)
    {
        return dao.findByName(name);
    }

    public List<Product> getByPlace(String place)
    {
        return dao.findByPlace(place);
    }

    public List<Product> getOutOfWarrenty(int warrenty)
    {
        return dao.findOutOfWarrentyProducts(warrenty);
    }

    public List<Product> getProductsContainsWord(String word)
    {
        return dao.findByWord(word);
    }


}
