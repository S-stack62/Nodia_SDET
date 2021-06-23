package com.crm.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This
 * @author SOUMYASANTA SAHOO
 *
 */
public class ExcelUtility {
	
	/**
	 * Read the excel data with Row & Column number
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetname, int rownum, int cellnum) throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstant.EXCELFILEPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetname);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		String value=cell.getStringCellValue();
		return value;
	}

	/**
	 * This method will read data by using TC_ID & Header
	 * @param sheetname
	 * @param tcId
	 * @param header
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetname, String tcId, String header) throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstant.EXCELFILEPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetname); //Sheet1
		int lastRowNum=sheet.getLastRowNum(); //4
		int expectedRow=0;
		for(int i=0;i<=lastRowNum;i++)
		{
			String testcaseId=sheet.getRow(i).getCell(0).getStringCellValue(); //TC_02
			System.out.println(testcaseId);
			if(testcaseId.equals(tcId))
			{
				//expectedRow=i;  //expectedRow=3
				break;
			}
			expectedRow=i;  //expectedRow=3
		}
		System.out.println(expectedRow);
		//expectedRow--; //2
		
		int excpectedCellNum=0;
		int lastCell=sheet.getRow(expectedRow).getLastCellNum(); //4
		for(int j=0;j<lastCell;j++)
		{
			String value=sheet.getRow(expectedRow).getCell(j).getStringCellValue(); //Industry_Type
			if(value.equals(header))
			{
				excpectedCellNum=j; //j=3
				break;
			}
		}
		
		String data=sheet.getRow(expectedRow+1).getCell(excpectedCellNum).getStringCellValue(); //Finance
		return data;
		}
}
