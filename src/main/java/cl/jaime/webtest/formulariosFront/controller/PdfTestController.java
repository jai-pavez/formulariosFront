package cl.jaime.webtest.formulariosFront.controller;

import java.io.ByteArrayOutputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

@Controller
public class PdfTestController {
	
	 public static final String[][] DATA = {
	            {"John Edward Jr.", "AAA"},
	            {"Pascal Einstein W. Alfi", "BBB"},
	            {"St. John", "CCC"}
	    };
	 
	@RequestMapping(value="/getpdf", method=RequestMethod.GET)
	public ResponseEntity<byte[]> getPdf() {
		
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		System.out.println(" estoy en el index saludos");
		//return "index" ;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_PDF);
	    String filename = "pdftest.pdf";
	    headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    
	    System.out.println();
	    ResponseEntity<byte[]> response = new ResponseEntity<>(createPDF(), headers, HttpStatus.OK);

		return response;
	}
	
	
	
	private static byte[] createPDF() {
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PdfWriter writer = new PdfWriter(byteArrayOutputStream);
	    PdfDocument pdfDocument = new PdfDocument(writer);
	    Document document = new Document(pdfDocument);
	    //document.add(new Paragraph("Hello World!"));

	    
	    
	    Table table = new Table(UnitValue.createPercentArray(new float[] {5, 1}));
        table.setWidth(UnitValue.createPercentValue(50));
        table.setTextAlignment(TextAlignment.LEFT);

        table.addCell(new Cell().add(new Paragraph("Name: " + DATA[0][0])).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(DATA[0][1])).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("Surname: " + DATA[1][0])).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(DATA[1][1])).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("School: " + DATA[2][0])).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(DATA[1][1])).setBorder(Border.NO_BORDER));


	    //Write the file content
        document.add(table);
	    document.close();
	    return byteArrayOutputStream.toByteArray();
	}

}
