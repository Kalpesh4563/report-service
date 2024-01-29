package com.example.controller;

import com.example.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
public class ReportController {

    @Autowired
    private ExcelService service;



    @GetMapping("/excel")
    public ResponseEntity<Resource> getActualdata() throws IOException {
        
        String fileName = "productdata.xls";

        ByteArrayInputStream actualdata = service.dataExcel();
        InputStreamResource file = new InputStreamResource(actualdata);

        ResponseEntity<Resource> body = ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName="+fileName)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);

        return body;
    }
}