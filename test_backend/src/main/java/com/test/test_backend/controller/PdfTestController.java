package com.test.test_backend.controller;

import com.test.test_backend.service.PdfTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pdf")
public class PdfTestController {

    @Autowired
    private PdfTestService pdfTestService;

    @PostMapping("/test")
    public void test(){
        pdfTestService.test();
    }
}
