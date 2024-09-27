package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

		driver.manage().window().maximize();
				
		// single file upload - txt_file1
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("/Volumes/KINGSTON/Software Testing/Automation Testing/SeleniumWebDriver/txt_file1");

		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("txt_file1")) {
			System.out.println("File is uploaded");
		}
		else {
			System.out.println("File is not uploaded");
		}
		
		// upload multiple files
		String file1 = "/Volumes/KINGSTON/Software Testing/Automation Testing/txt_file1";
		String file2 = "/Volumes/KINGSTON/Software Testing/Automation Testing/txt_file2";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);

		// List<WebElement> countFile = driver.findElements(By.xpath("//ul[@id='fileList']//li"));
		// System.out.println(countFile.size());
		
		int countFile = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		
		// validate no of files
		if(countFile == 2) {
			System.out.println("All files uploaded");
		}
		else {
			System.out.println("Incorrect file uploaded");
		}
		
		// validate filenames
		String validFile1 = driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText();
		String validFile2 = driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText();
		
		if(validFile1.equals("txt_file1") && validFile2.equals("txt_file2")) {
			System.out.println("Both filenames uploaded");
		}
		else {
			System.out.println("Incorrect filenames uploaded");
		}
		
	}

}
