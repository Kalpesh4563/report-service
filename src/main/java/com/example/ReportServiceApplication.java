package com.example;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ReportServiceApplication {

    @Autowired
    private ProductRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(ReportServiceApplication.class, args);
    }
    @PostConstruct
    public List<Product> addProduct(){
        List<Product> list = Stream.of(
                new Product(1,"TV","Smart TV","Pune","Pimple Gurav"),
                new Product(2,"TV","Smart TV","Pune","Pimple Gurav"),
                new Product(3,"TV","Smart TV","Pune","Pimple Gurav"),
                new Product(4,"TV","Smart TV","Pune","Pimple Gurav")
        ).collect(Collectors.toList());
        repository.saveAll(list);
        return list;
    }

}
