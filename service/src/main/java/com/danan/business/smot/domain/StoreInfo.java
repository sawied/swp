package com.danan.business.smot.domain;

import java.io.Serializable;
import java.net.URL;

/**
 * 
 * @author danan
 *
 */
public class StoreInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6763864862352282300L;
	
	private String serialUID = null;
	
	private URL fileURL =null;

	public String getSerialUID() {
		return serialUID;
	}

	public void setSerialUID(String serialUID) {
		this.serialUID = serialUID;
	}

	public URL getFileURL() {
		return fileURL;
	}

	public void setFileURL(URL fileURL) {
		this.fileURL = fileURL;
	}
	
	

}
