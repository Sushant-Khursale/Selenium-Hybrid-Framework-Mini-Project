package com.inetBanking.TestCases;

import java.io.IOException;

import com.inetBanking.Utilities.XLUtils;

public class TestExcelAccess {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
//		XLUtils xl = new XLUtils("C:\\Users\\Hp User\\eclipse-workspace\\inetBankingV1\\src\\test\\java\\com\\inetBanking\\TestData\\TestData_inetBankingV1.xlsx","Sheet1");
		XLUtils xl = new XLUtils("./src/test/java/com/inetBanking/TestData/TestData_inetBankingV1.xlsx","Sheet1");
		int rows = xl.getRowCount();
		int columns = xl.getColumnCount();
		System.out.println(columns);
		
		String[][] logindata = new String[rows-1][columns];
		
		for(int i=1;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				
				logindata[i-1][j]= (String) xl.getData(i, j);
				//System.out.print(xl.getData(i, j)+" ");
			}
			//System.out.println();
		}
		
		for(int x=0;x<rows-1;x++) {
			for(int y=0;y<columns;y++) {
				System.out.print(logindata[x][y]+" ");
				
			}
			System.out.println();
		}
	
		
	}

}
