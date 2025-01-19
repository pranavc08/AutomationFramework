package com.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "loginData")
	public String [][] getData() throws IOException{
		
		String path = "./testData/Opencart_logindata.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalRows = xlutil.getRowCount("sheet1");
		int totalCols = xlutil.getCellCount("sheet1", 1);
		
		String [][] loginData = new String [totalRows][totalCols];
		
		for(int i=1; i<=totalRows; i++) {
			
			for(int j=0; j<totalCols; j++) {
				
				loginData[i-1][j]= xlutil.getCellData("sheet1", i, j);
			}
		}
		
		return loginData;
	}
	
	
	
}
