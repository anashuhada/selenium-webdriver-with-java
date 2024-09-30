package day40;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Excel files -> workbook -> sheets -> rows -> cells
/*XSSFWorkbook -> workbook
XSSFSheet -> sheet
XSSFRow -> row
XSSFCell -> cell*/


public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		// open the file using reading mode
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/testdata/data.xlsx");
		
		// extract the workbook from the file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		// extract the sheet name
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// XSSFSheet sheet1 = workbook.getSheetAt(0); // other alternative
		
		// return the last row no of the sheet 
		int totalRow = sheet.getLastRowNum();
		System.out.println("Number of rows: " + totalRow); // 5
		
		// return the last cell no of the row
		int totalCell = sheet.getRow(0).getLastCellNum();
		System.out.println("Number of cells: " + totalCell); // 4
		
		// as per Java count starts from 0 for both row and cell
		for(int r = 0; r <= totalRow; r++) {
			
			XSSFRow currRow = sheet.getRow(r);
			
			for(int c = 0; c < totalCell; c++) {
				XSSFCell currCell = currRow.getCell(c);
				System.out.print(currCell.toString() + "\t");
			}
			
			System.out.println("\n");
		}
		
		workbook.close();
		file.close();
		
	}

}
