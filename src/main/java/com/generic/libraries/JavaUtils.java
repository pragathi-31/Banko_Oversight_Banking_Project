package com.generic.libraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	/**
	 * This method is used to return a random number from 1 to 100
	 * @return
	 */
	
	public int getRandomNumber() {
		Random ran=new Random();
		return ran.nextInt(100);
		
	}
	/**
	 * this method is used to return system date
	 * @return
	 */
	public String systemDate() {
		Date dt=new Date();
		String date = dt.toString();
		return date;
	}
	/**
	 * this method is used to return system date in a particual format that is dd/mm/yyyy hh-mm-ss
	 * @return
	 */
	
	public String getSystemDateInFormat() {
		SimpleDateFormat dateformat= new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date dt=new Date();
		
		return dateformat.format(dt);
		
	}
}
