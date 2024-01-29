package com.example.service;

import com.example.Helper.Helper;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ProductRepository repository;

    public ByteArrayInputStream dataExcel() throws IOException {
         return Helper.dataExcel(repository.findAll());
    }
}
