package com.github.wasmq.test;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class JMSCorrelationIdTest {

	
	@Test
	public void correlationidTest(){
		byte[] bytes= new byte[24];
		
		byte[] ids = "mvtm-1502514267717".getBytes();
		
		for(int i=0;i<bytes.length&&i<ids.length;i++){
			bytes[i]=ids[i];
		}
		
		String wasf=Hex.encodeHexString(bytes);
		
		System.out.println("JMSCorrelationID:"+wasf);
	}
	
	
	@Test
	public void correlationidDecodeTest(){
		byte[] bytes = new byte[24];
		String str ="414d51204855424d514c4f43414c2020d9ef945920001f10";
		int count=str.length()/2;
		for(int i=0;i<count;i++){
		   Integer r=Integer.decode("0X"+str.substring(i*2, (i+1)*2));
		   bytes[i]=r.byteValue();
		}
		
		System.out.println(new String(bytes));
		
	}
	
	
	
	
	
}
