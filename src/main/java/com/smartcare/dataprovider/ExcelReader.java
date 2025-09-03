package com.smartcare.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	//we need to add the dependency Apache POI and Apache POI OOXML from the Maven Repositry
	
	

		
		public static Object[][] getDataFromExcel(String sheetname) 
		{
			XSSFWorkbook wb=null;
			
			try 
			{
				wb=new XSSFWorkbook(new FileInputStream(new File("./TestData/TestData.xlsx")));
			} 
			catch (FileNotFoundException e)
			{
				System.out.println("File not found"+e.getMessage());
			}
			catch (IOException e) 
			{
				System.out.println("Could not read the file"+e.getMessage());
			}
			
			int	rowcount=wb.getSheet(sheetname).getPhysicalNumberOfRows();
			int	columncount=wb.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();
			
			Object[][] arr = new Object[rowcount-1][columncount]; // 2d array
			
			for (int i = 1; i < rowcount; i++)
			{
				for (int j = 0; j < columncount; j++) 
				{
					String value="";
				CellType type=wb.getSheet(sheetname).getRow(i).getCell(j).getCellType();
				
				if(type==CellType.NUMERIC)
				{
					value=String.valueOf(wb.getSheet(sheetname).getRow(i).getCell(j).getNumericCellValue());
				}
				else if (type==CellType.STRING) 
				{
					value=wb.getSheet(sheetname).getRow(i).getCell(j).getStringCellValue();
				}
				else if(type==CellType.BOOLEAN)
				{
					value=String.valueOf(wb.getSheet(sheetname).getRow(i).getCell(j).getBooleanCellValue());
				}
				else if (type==CellType.BLANK) 
				{
					value="";
				}
				arr[i-1][j]=value;
				}
			}
			return arr;
			
		}
}
