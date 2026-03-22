package com.ai_resume_shortlisting.invogent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PDFController {
	@GetMapping("/downloadPdf")
	public void downloadPdf(HttpServletResponse response) throws Exception {

	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition",
	            "attachment; filename=ATS_Report.pdf");

	    PdfWriter writer = new PdfWriter(response.getOutputStream());
	    PdfDocument pdf = new PdfDocument(writer);
	    Document doc = new Document(pdf);

	    doc.add(new Paragraph("🚀ATS Resume Report")
	            .setBold().setFontSize(18));

	    doc.add(new Paragraph("\nOverall Score: 85%"));
	    doc.add(new Paragraph("Experience: 1 Year"));
	    doc.add(new Paragraph("Projects: 5"));

	    doc.add(new Paragraph("\nMatched Skills:")
	            .setBold());
	    doc.add(new Paragraph("✔ Java, Spring Boot, SQL, Hibernate"));

	    doc.add(new Paragraph("\nMissing Skills:")
	            .setBold());
	    doc.add(new Paragraph("✘ Docker, AWS"));

	    doc.add(new Paragraph("\nSuggestions:")
	            .setBold());
	    doc.add(new Paragraph("- Add more cloud technologies"));
	    doc.add(new Paragraph("- Improve DevOps knowledge"));

	    doc.close();
	}
}	
