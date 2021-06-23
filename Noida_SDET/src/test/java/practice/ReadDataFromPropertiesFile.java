package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertiesFile {
	
	@Test
	public void readDataTest() throws Throwable {
		
		//Read the data from Properties File
		//Step-1: Get the java representation of Physical
		FileInputStream fis=new FileInputStream("./Data/commonData10.properties");
		
		//Step-2: Create an Object of the Properties class & load all the key value pair
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//Step-3: Read the value using getProperty("key")
		String URL=pObj.getProperty("url");
		System.out.println(URL);
		
	}

}
