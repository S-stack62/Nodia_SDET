package com.crm.GenericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific generic libraries
 * @author SOUMYASANTA SAHOO
 *
 */
public class JavaUtility {
	
	/**
	 * Generate Random Number
	 * @return
	 */
	public static String getRandomData()
	{
		Random r=new Random();
		int ran=r.nextInt(1000);
		return "_"+ran;
	}
	
	/**
	 * Generate Current System Date
	 * @return
	 */
	public String getCurrentSystemDate()
	{
		Date date=new Date();
		String currentDate=date.toString();
		return currentDate;
	}

}
