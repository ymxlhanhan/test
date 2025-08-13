package com.test.test_backend.service.impl;

import com.test.test_backend.service.PdfTestService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class PdfTestServiceImpl implements PdfTestService {

    static final String RESULT = "F:/pdf_temple/";

    @Override
    public void test(MultipartFile file, HttpServletResponse response, String fileName) {
        try {
            resolveResponse(response, fileName);
            InputStream inputStream = file.getInputStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void resolveResponse(HttpServletResponse response, String fileName) {
        response.setContentType("application/pdf");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setHeader("Content-Transfer-Encoding", "Content-Disposition");
    }
}
