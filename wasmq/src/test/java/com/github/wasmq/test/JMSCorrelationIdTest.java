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
	
	
	
}
