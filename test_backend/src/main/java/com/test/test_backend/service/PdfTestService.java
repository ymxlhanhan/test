package com.test.test_backend.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface PdfTestService {
    void test(MultipartFile file, HttpServletResponse response, String fileName) throws FileNotFoundException;
}
