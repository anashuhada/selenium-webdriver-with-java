package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel files -> workbook -> sheets -> rows -> cells
/*XSSFWorkbook -> workbook
XSSFSheet -> sheet
XSSFRow -> row
XSSFCell -> cell*/

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		// create new xlsx file
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/testdata/myfile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(); // create the workbook
		
		XSSFSheet sheet = workbook.createSheet("Data");
		
		// create row 1
		XSSFRow row1 = sheet.createRow(0);
		
		// create cells in row 1
		row1.createCell(0).setCellValue("Java");
		row1.createCell(1).setCellValue(19);
		row1.createCell(2).setCellValue("Automation");
		
		// create row 2
		XSSFRow row2 = sheet.createRow(1);
				
		// create cells in row 2
		row2.createCell(0).setCellValue("Python");
		row2.createCell(1).setCellValue(3);
		row2.createCell(2).setCellValue("Automation");
		
		// create row 3
		XSSFRow row3 = sheet.createRow(2);
						
		// create cells in row 3
		row3.createCell(0).setCellValue("C#");
		row3.createCell(1).setCellValue(5);
		row3.createCell(2).setCellValue("Automation");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created...");
		
	}

}
