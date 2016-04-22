package com.danan.business.smot.web;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.danan.appmanagment.RetrvApplicationInfoRequest;
import org.danan.appmanagment.RetrvApplicationInfoResponse;
import org.danan.bean.commonsegment.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WebServiceController {
	private static List<String> contentList=new ArrayList<String>();

	@Autowired
	@Qualifier("inputChannel")
	private MessageChannel mc =null;
	
	@RequestMapping("/download")
	@ResponseBody
	public String downloadAttachment(){
		RetrvApplicationInfoRequest request =new RetrvApplicationInfoRequest();
		request.setIn("1");
		MessageBuilder<RetrvApplicationInfoRequest> mb =MessageBuilder.withPayload(request);
		MessagingTemplate mt =new MessagingTemplate(mc);
		Message<?> sendAndReceive = mt.sendAndReceive(mb.build());
		RetrvApplicationInfoResponse retrvApplicationInfo = (RetrvApplicationInfoResponse) sendAndReceive.getPayload();
		Customer info = retrvApplicationInfo.getInfo();
		DataHandler attachment = info.getAttachment();
		try{
		FileOutputStream outStream = new FileOutputStream("D:/works/A1.txt");
		InputStream inputStream = attachment.getInputStream();
		FileChannel channel = outStream.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byte[] bytes= new byte[1];
		int n=-1;
		while((n=inputStream.read(bytes))!=-1){
			if(!byteBuffer.hasRemaining()){
				byteBuffer.flip();
				channel.write(byteBuffer);
				byteBuffer.clear();
			}
			byteBuffer.put(bytes, 0, n);
		}
		//clean remaining byte
		byteBuffer.flip();
		channel.write(byteBuffer);
		inputStream.close();
		channel.close();
		outStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
	@RequestMapping("/excel")
	public void parseExcel(HttpServletResponse response){
		try {
		Workbook workbook=getWorkbook();
		Sheet sheet=workbook.getSheetAt(0);
		int rowsNum=sheet.getPhysicalNumberOfRows();
		for(int rowIndex=0;rowIndex<rowsNum;rowIndex++){
		Row row=	sheet.getRow(rowIndex);
		int columnNums=row.getPhysicalNumberOfCells();
		
		PrintWriter writer= response.getWriter();
		for(int columnIndex=0;columnIndex<columnNums;columnIndex++){
			writer.println((row.getCell(columnIndex)));
			contentList.add(row.getCell(columnIndex).getStringCellValue());
		}
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private Workbook getWorkbook(){
		InputStream inputStream=null;
		try{
			 inputStream = this.getClass().getClassLoader().getResourceAsStream("a.xlsx");
		Workbook wb=new XSSFWorkbook(inputStream);
		return wb;
		}catch(Exception e){
			
		}finally{
			IOUtils.closeQuietly(inputStream);
		}
		return null;
	}
	
	
}
