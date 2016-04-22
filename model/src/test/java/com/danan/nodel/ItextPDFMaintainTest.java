package com.danan.nodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

/**
 * this class used as a solution for using pdf. 
 * @author danan
 *
 */
public class ItextPDFMaintainTest {

	
	private static final String STR = "中国智慧 China wisdom for world";
	
	private static final File FILE_IN = new File(System.getProperty("user.home"),"in.pdf");
	
	
	private static final File FILE_OUT = new File(System.getProperty("user.home"),"out.pdf");
	
	@BeforeClass
	public static void setup(){
		
		FileOutputStream fileOutputStream;
		try {
			Document document = new Document();
			fileOutputStream = new FileOutputStream(FILE_IN);
			PdfWriter pdfWriter = PdfWriter.getInstance(document,fileOutputStream);
			document.open();
			document.addCreator("HSBC");
			document.addAuthor("danan");
			document.addTitle("IText practice");
			document.addKeywords("contact");
			document.addSubject("itext");
			document.addProducer();
			document.addCreationDate();
			BaseFont bFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
			Font font = new Font(bFont,24,Font.UNDERLINE,BaseColor.DARK_GRAY);
			//BaseFont.createFont("", encoding, embedded)
			
			for(int i=0;i<1;i++){				
				Paragraph paragraph = new Paragraph(STR+":" +i,font);
//				LineSeparator lineSeparator = new DottedLineSeparator();
//				lineSeparator.setOffset(-3);
//				lineSeparator.setAlignment(Element.ALIGN_LEFT);
//				paragraph.add(lineSeparator);
				document.add(paragraph);
			}
			
//			PdfTemplate pdfTemplate = PdfTemplate.createTemplate(pdfWriter,400,400);
//			pdfTemplate.moveTo(100, 100);
//			pdfTemplate.lineTo(100, 200);
			
			VerticalPositionMark verticalPositionMark = new VerticalPositionMark(){

				@Override
				public void draw(PdfContentByte canvas, float llx, float lly,
						float urx, float ury, float y) {
					canvas.saveState();
					canvas.moveTo(100,100);
					canvas.lineTo(100, 200);
					canvas.saveState();
				}
				
			};
			
			Paragraph paragraph = new Paragraph();
			paragraph.add(verticalPositionMark);
			document.add(paragraph);		
			document.close();
			pdfWriter.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	@Test
	public void readAndModify(){
		getPosition();
	}
	
	@Test
	public void parserContentByToken(){
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(FILE_IN);
			PdfReader pdfReader = new PdfReader(fileInputStream);
			for(int i=1;i<=pdfReader.getNumberOfPages();i++){
				byte[] pageContent = pdfReader.getPageContent(i);
				parserContent(pageContent);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getPosition(){
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(FILE_IN);
			PdfReader pdfReader = new PdfReader(inputStream);
			PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(pdfReader);
			for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
				pdfReaderContentParser.processContent(i, new ParserSignature());
			}
			pdfReader.close();
			inputStream.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void parserContent(byte [] onePageStream){
		try {
			PRTokeniser prTokeniser = new PRTokeniser(onePageStream);
			while(prTokeniser.nextToken()){
				if(prTokeniser.getTokenType().equals(PRTokeniser.TokenType.STRING)){			
					System.out.println(prTokeniser.getStringValue());
				}if(prTokeniser.getTokenType().equals(PRTokeniser.TokenType.NAME)){
					System.out.println(prTokeniser);
				}
				else{
					System.out.println(prTokeniser.getTokenType());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	class ParserSignature implements RenderListener{
		

		public void beginTextBlock() {
		}

		public void renderText(TextRenderInfo renderInfo) {
			String text = renderInfo.getText();
			System.out.println(text);
		}

		public void endTextBlock() {
			
		}

		public void renderImage(ImageRenderInfo renderInfo) {
			System.out.println(renderInfo);
		}
		
	}
	
	
	
}
