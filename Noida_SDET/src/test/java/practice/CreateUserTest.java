package practice;

import org.testng.annotations.Test;

public class CreateUserTest {
	
	@Test
	public void createUserTest()
	{
		String USERNAME=System.getProperty("username");
		System.out.println("execute test 1");
		System.out.println("=======>"+USERNAME);
	}

}
