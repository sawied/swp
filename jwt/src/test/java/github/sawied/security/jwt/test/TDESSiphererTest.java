package github.sawied.security.jwt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sawied.jwt.security.TDESCipherer;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:github/sawied/jwt/security/security-jwt-context.xml"})
public class TDESSiphererTest {

	@Autowired
	private TDESCipherer cipherer;
	
	private byte[] input="Hello world".getBytes();
	
	
	@Test
	public void tdesEncodeTest(){
		try {
			byte[] ciphertext=cipherer.encrypt(input);
			
			byte[] cleartext=cipherer.decrypt(ciphertext);
			
			Assert.assertEquals(new String(input), new String(cleartext));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
