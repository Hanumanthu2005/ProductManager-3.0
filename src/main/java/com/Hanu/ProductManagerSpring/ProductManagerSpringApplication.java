package com.Hanu.ProductManagerSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProductManagerSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductManagerSpringApplication.class, args);

		ProductService service = context.getBean(ProductService.class);
		List<Product> products = service.getAllProducts();

        System.out.println("gets all products");

        products.forEach(System.out::println);

        System.out.println("=====================================================================");

        System.out.println("get product by name");

        System.out.println(service.getByName("macbook charger"));

        System.out.println("=====================================================================");

        System.out.println("get product by place");

        List<Product> placeProducts = service.getByPlace("table");

        placeProducts.forEach(System.out::println);

        System.out.println("=====================================================================");

        System.out.println("product not covers the warrenty");

        List<Product> notWarrenty = service.getOutOfWarrenty(2025);

        notWarrenty.forEach(System.out::println);

        System.out.println("=====================================================================");

        System.out.println("all products contains word");

        List<Product> containsWord = service.getProductsContainsWord("lenovo");

        containsWord.forEach(System.out::println);
	}

}
