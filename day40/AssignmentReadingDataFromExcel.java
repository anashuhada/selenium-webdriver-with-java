package day40;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AssignmentReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/testdata/sample.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Data");
		
		int totalRow = sheet.getLastRowNum();
		System.out.println("Total number of rows: " + totalRow);
		
		int totalCell = sheet.getRow(0).getLastCellNum();
		System.out.println("Total number of rows: " + totalCell);
		
		for(int r = 0; r <= totalRow; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for(int c = 0; c < totalCell; c++) {
				XSSFCell currentCell = currentRow.getCell(c);
				System.out.print(currentCell + "\t");
			}
			
			System.out.println("\n");
		}
		
		workbook.close();
		file.close();
		
	}

}
