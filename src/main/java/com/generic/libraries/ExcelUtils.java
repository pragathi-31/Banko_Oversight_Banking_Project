package com.generic.libraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	/**
	 * This program will return the value from excel
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		return sh.getRow(row).getCell(cell).getStringCellValue();
	}
	/**
	 * This method will return the last row which has data
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNum(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		return sh.getLastRowNum();
	}
	/**
	 * this method will return last cell number
	 * @param sheetname
	 * @param row
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastCellNum(String sheetname,int row) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		return sh.getRow(row).getLastCellNum();
	}
	/**
	 * this method will return the key value pair from the data stored in excel
	 * @param sheetname
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String,String> hashMapData(String sheetname,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		
		int lastRow= sh.getLastRowNum();
		HashMap<String, String> hm=new HashMap<String, String>();
		for(int i=0;i<=lastRow;i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(cell).getStringCellValue();
			hm.put(key, value);
		}
		return hm;
	}
	/**
	 * checking the cell whether it is null or not then writing data into that
	 * @param sheetname
	 * @param value
	 * @param rownum
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setExcelData(String sheetname,String value,int rownum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet(sheetname);
		for(int i=1;true;i++) {
			
			try {
			 Row row = sh.getRow(rownum);
			 Cell cell = row.getCell(i);
			 if(cell==null) {
				 row.createCell(i).setCellValue(value);
				 break;
			 }

			
			}catch (Exception e) {
				
			}
			
			
		}
		FileOutputStream fos=new FileOutputStream(IpathConstants.excelPath);
		wb.write(fos);
		wb.close();
	}
	public void setExcelData(String sheetname,String value, int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		sh.getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IpathConstants.excelPath);
		wb.write(fos);
		wb.close();
	}
	
}
