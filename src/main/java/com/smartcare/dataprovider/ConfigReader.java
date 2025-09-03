package com.smartcare.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String takingPropertyFromConfigReader(String key)
	{
		
		///Config driven approach
		
		Properties pro = new Properties();
		try {
			pro.load( new FileInputStream(new File("./Configuration/Config.Properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		

		String value = pro.getProperty(key);
		return value;
	}
}
