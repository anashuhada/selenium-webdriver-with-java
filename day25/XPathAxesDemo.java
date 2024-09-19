package day25;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxesDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		
		driver.manage().window().maximize();
		
		// self node - select the current node
		String selfValue = driver.findElement(By.xpath("//a[contains(text(),'Zomato')]/self::a")).getText();
		System.out.println("Self node: " + selfValue);
		
		// parent node - select the parent of the current node (always one parent)
		String parentValue = driver.findElement(By.xpath("//a[contains(text(),'Zomato')]/parent::td")).getText();
		System.out.println("Parent node: " + parentValue);
		
		// child node - select all children of the current node (one or many)
		List<WebElement> childValue = driver.findElements(By.xpath("//a[contains(text(),'Zomato')]/ancestor::tr/child::td"));
		System.out.println("Child node: " + childValue.size());
		
		// ancestor node - select all ancestors (parent, grandparent, etc)
		String ancestorValue = driver.findElement(By.xpath("//a[contains(text(),'Zomato')]/ancestor::tr")).getText();		
		System.out.println("Ancestor node: " + ancestorValue);
		
		// descendant node - select all descendants (children, grandchildren, etc) of the current node
		List<WebElement> descendantValue = driver.findElements(By.xpath("//a[contains(text(),'Zomato')]/ancestor::tr/descendant::*"));
		System.out.println("Descendant node: " + descendantValue.size());
		
		// following node - select everything in the document after the closing tag of the current node
		List<WebElement> followingValue = driver.findElements(By.xpath("//a[contains(text(),'Zomato')]/ancestor::tr/following::tr"));
		System.out.println("Following node: " + followingValue.size());
		
		// preceding node - select all nodes that appear before current node in the document
		List<WebElement> precedingValue = driver.findElements(By.xpath("//a[contains(text(),'Zomato')]/ancestor::tr/preceding::tr"));
		System.out.println("Preceding node: " + precedingValue.size());
		
		// following-sibling node - select all siblings after the current node
		List<WebElement> follSibValue= driver.findElements(By.xpath("//a[contains(text(),'Zomato')]/ancestor::tr/following-sibling::tr"));
		System.out.println("Following-sibling node: " + follSibValue.size());
		
		// preceding-sibling node - select all siblings before the current node
		List<WebElement> preSibValue= driver.findElements(By.xpath("//a[contains(text(),'Zomato')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Preceding-sibling node: " + preSibValue.size());
		
		driver.close();		
		
	}

}
