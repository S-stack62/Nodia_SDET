package com.crm.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtility {
	
	/**
	 * This Method used to read data from properties & return value based on Key specified
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstant.PROPERTYFILEPATH);
		Properties p=new Properties();
		p.load(file);
		return p.getProperty(key);
	}

}
