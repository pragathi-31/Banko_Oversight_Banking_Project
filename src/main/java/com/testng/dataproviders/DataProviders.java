package com.testng.dataproviders;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.libraries.IpathConstants;

public class DataProviders {

	@Test(dataProvider = "excelDataProvider")
	public void check(String ID, String pass) {
		if(ID!=null && pass!=null)
		System.out.println(ID+"--->"+pass);
	}
	
	@DataProvider
	public Object[][] excelDataProvider() throws Exception {
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("customerDetails");
		int lastRow = sh.getLastRowNum()+1;
		short lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastCell][lastRow];
		for(int i=1;i<lastCell;i++) {
			for(int j=0;j<lastRow;j++) {
				obj[i][j]=sh.getRow(j).getCell(i).getStringCellValue();
			}
		}
	
		return obj;
		
	}
	
}
