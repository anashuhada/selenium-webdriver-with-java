package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		// create new xlsx file
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/testdata/myfileDynamic.xlsx");
				
		XSSFWorkbook workbook = new XSSFWorkbook(); // create the workbook
				
		XSSFSheet sheet = workbook.createSheet("DynamicData");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter how many rows? :");
		int noOfRows = sc.nextInt();
		
		System.out.println("Enter how many cells? :");
		int noOfCells = sc.nextInt();
		
		
		for(int r = 0; r <= noOfRows; r++) {
			
			XSSFRow currRow = sheet.createRow(r);
			
			for(int c = 0; c < noOfCells; c++) {
				XSSFCell cell = currRow.createCell(c);
				cell.setCellValue(sc.next()); // user enters the cell values
			}
		}
		
		workbook.write(file); // attach workbook to the file
		workbook.close();
		file.close();
		
		System.out.println("File is created...");

	}

}
