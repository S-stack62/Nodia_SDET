package practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateCustomerTest {
	
	@Test
	public void createCustomerTest(XmlTest xml) {
		
		String username=xml.getParameter("username");
		System.out.println(username);
		
	}

}
