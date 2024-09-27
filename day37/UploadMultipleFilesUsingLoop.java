package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadMultipleFilesUsingLoop {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

		driver.manage().window().maximize();
		
		// store file in array
		String files[] = {
				"/Volumes/KINGSTON/Software Testing/Automation Testing/txt_file1",
				"/Volumes/KINGSTON/Software Testing/Automation Testing/txt_file1"
		};
		
		// use enhanced for loop to upload one by one
		for (String filePath : files) {
		    driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(filePath);
		}
		
		// count no of files uploaded
		int countFile = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		
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
