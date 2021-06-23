package com.crm.GenericUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileUtility {
	
	public String readDataFromJSON(String key) throws Throwable, ParseException
	{
		//Read the data from JSON file
		FileReader inputFile=new FileReader(IPathConstant.JSONFILEPATH);
		
		//Parse the json object into java
		JSONParser parser=new JSONParser();
		Object object=parser.parse(inputFile);
		
		//Type cast the object into Hashmap and read the data in key value format
		HashMap jobject=(HashMap)object;
		String value=jobject.get(key).toString();
		return value;
	}

}
