package com.inetBanking.Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public XLUtils(String testDataPath, String sheetName) throws IOException {
		workbook = new XSSFWorkbook(testDataPath);
		sheet = workbook.getSheet(sheetName);
		
	}
	
	public int getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
	
	public int getColumnCount() {
		int colCount = sheet.getRow(0).getLastCellNum();
		return colCount;
	}
	
	public Object getData(int rowNum, int colNum) {
		
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		return value;
	}

}
