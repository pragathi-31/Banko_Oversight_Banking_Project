package com.generic.libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutils {
	
	/**
	 * This method will return the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.filePath);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
