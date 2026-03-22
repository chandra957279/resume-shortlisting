package com.ai_resume_shortlisting.invogent.utils;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

public class PdfReaderUtil {

    public static String extractTextFromPdf(MultipartFile file) {

        try (PDDocument document = PDDocument.load(file.getInputStream())) {

            PDFTextStripper stripper = new PDFTextStripper();

           
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(document.getNumberOfPages());

            String text = stripper.getText(document);

          
            text = text.replaceAll("\\r", " ");
            text = text.replaceAll("\\n", " ");
            text = text.replaceAll("\\s+", " ");

            System.out.println("📄 Extracted Resume Text:");
            System.out.println(text);

            return text;

        } catch (IOException e) {
            throw new RuntimeException("Failed to read PDF file", e);
        }
    }

}
