package com.danan.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.AcroFields.FieldPosition;
import com.itextpdf.text.pdf.AcroFields.Item;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PDFTest {

	public static final String ADDRESS = "中国陕西西安尚德路179号14楼1104垚";

	public static void main(String[] args) throws IOException, DocumentException {
		printPosition();
		generatePDF();
	}

	private static void generatePDF() throws IOException, DocumentException {
		
		Resource resource = new ClassPathResource("com/danan/pdf/loan.pdf");
		PdfReader reader = new PdfReader(resource.getInputStream());
		FileOutputStream outputStream = new FileOutputStream(new File("D:/works/ffmpeg/target.pdf"));
		PdfStamper pdfStamper = new PdfStamper(reader, outputStream);
		PdfContentByte cb = pdfStamper.getOverContent(1);
		BaseFont basefont=BaseFont.createFont("C:\\Windows\\Fonts\\SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		cb.beginText();
		
		float fixWidth = basefont.getWidthPoint(ADDRESS,8);
		int size=8;
		while(fixWidth>92.631195&&size>2) {
			fixWidth=basefont.getWidthPoint(ADDRESS, --size);
			System.out.println("fix width: "+ fixWidth +" size: "+ size );
		}
		cb.setFontAndSize(basefont, size);
		
		cb.showTextAligned(PdfContentByte.ALIGN_LEFT, ADDRESS, 0.70087916F*72, 10.02121F*72, 0);
		cb.endText();
		
		
		drawLine(cb,35.6601F,658.1379F,4F);

		pdfStamper.close();
		outputStream.close();
		reader.close();
	}
	
	public static void drawRectangle(PdfContentByte content, float x,float y,float width, float height) {
	    content.saveState();
	    content.setColorStroke(BaseColor.BLACK);
	    content.rectangle(x, y, width, height);
	    content.fillStroke();
	    content.restoreState();
	}
	
	public static void drawLine(PdfContentByte content, float x,float y,float w) {
	    content.saveState();
	    content.setColorStroke(BaseColor.BLACK);
	    content.setLineWidth(0.5F);
	    content.moveTo(x, y);
	    content.lineTo(x+w, y+w);
	    content.moveTo(x, y+w);
	    content.lineTo(x+w, y);
	    content.stroke();
	    content.restoreState();
	}

	private static void printPosition() throws IOException{
		Resource resource = new ClassPathResource("com/danan/pdf/template.pdf");
		PdfReader reader = new PdfReader(resource.getInputStream());
		Rectangle rect = reader.getPageSize(1);
		System.out.println("page size :" + rect.getWidth()/72 +"X" + rect.getHeight()/72 +" border left: " + rect.getLeft()/72 );
		AcroFields fields = reader.getAcroFields();
		Set<Entry<String, Item>> entries = fields.getFields().entrySet();
		Iterator<Entry<String, Item>> it = entries.iterator();
		while(it.hasNext()) {
			Entry<String, Item> entry=it.next();
			String key=entry.getKey();
			List<FieldPosition> positions=fields.getFieldPositions(key);
			FieldPosition position = positions.get(0);
			int page =position.page;
			float left = position.position.getLeft();
			float width = position.position.getWidth();
			float height = position.position.getHeight();
			float bottom =position.position.getBottom();
			float top =position.position.getTop();
			
			System.out.println("Field: " + key +" item : left:"+left +" width: " + width +" height: "+height+" bottom: "+ bottom +" top :"+ top +" at page:" + page);
		}
		
		reader.close();
	}
	
	
}
