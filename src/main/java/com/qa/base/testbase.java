package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class testbase {
	
	public Properties prop;
	
	public int Response_status_response_code_200= 200;

	public testbase() throws FileNotFoundException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\eclipse-workspace\\RestAPI\\src\\main\\java\\com\\qa\\configuration\\config.properties");
        try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
