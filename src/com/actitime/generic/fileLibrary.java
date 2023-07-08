package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fileLibrary {

	public String getPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/data.property");
		Properties p= new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;	
	}
	
	public String getExcelFile(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/ACTITIME.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;	
	}
	public void setExcelFile(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/ACTITIME.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./data/ACTITIME.xlsx");
		wb.write(fos);
		wb.close();
	}
	
}
