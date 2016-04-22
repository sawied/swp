package com.danan.business.smot.web;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.danan.business.smot.domain.StoreInfo;


@Controller
public class DownloadFileController {
	

	private Resource resource= new ClassPathResource("com/danan/resources/sample.pdf");

	@RequestMapping("/file")
	public void download(StoreInfo storeInfo,HttpServletRequest request,HttpServletResponse response)  {
		try {
			InputStream inputStream = resource.getInputStream();
			byte[] byteArray = IOUtils.toByteArray(inputStream);
			//byte[] encode = Base64.encode(byteArray);
			response.setContentLength(byteArray.length);
			response.setContentType("application/pdf");
			response.setHeader("Access-Control-Allow-Origin", "*");
			//response.setHeader("content-Disposition", "attachment; filename=sample.txt");
			IOUtils.copyLarge(new ByteArrayInputStream(byteArray), response.getOutputStream());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
