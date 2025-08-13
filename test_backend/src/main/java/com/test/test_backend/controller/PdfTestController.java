package com.test.test_backend.controller;

import com.test.test_backend.service.PdfTestService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pdf")
public class PdfTestController {

    @Autowired
    private PdfTestService pdfTestService;

    @PostMapping("/test")
    public void test(HttpServletResponse response, @RequestParam MultipartFile file) {
        try {
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
