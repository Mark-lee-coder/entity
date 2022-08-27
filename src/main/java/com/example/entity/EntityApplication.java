package com.example.entity;

import com.example.entity.entity.Product;
import com.example.entity.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class EntityApplication implements CommandLineRunner {
    private ProductRepository productRepository;
    private Logger logger= LoggerFactory.getLogger(EntityApplication.class);

    @Autowired
    public void productRepository(ProductRepository productRepository) {this.productRepository = productRepository; }

    public static void main(String[] args) {
        SpringApplication.run(EntityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product();
        product1.setName("Tester Product");
        product1.setCategory("TEST");
        product1.setType("GENERAL");
        product1.setSector("SECTOR 1");
        
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Another Tester Product");
        product2.setCategory("TEST");
        product2.setType("CUSTOM");
        product2.setSector("SECTOR 2");

        productRepository.save(product2);

        List <Product> products = productRepository.findAll();//queries all products

        for (Product product : products) {
            logger.info("Products found:" +product.toString());//logs out to console all products
        }

        Product resultProduct = productRepository.findByType("GENERAL");//queries a specific type, general products in this case
        logger.info("General types of product found:" +resultProduct.toString());//logs out to console general products

        List <Product> results = productRepository.findByCategoryAndSector("TEST", "SECTOR1");//queries products using specific parameters

        for (Product product : results) {
            logger.info("Matching results are:" +product.toString());//logs out products meeting the specified parameters
        }
    }
}