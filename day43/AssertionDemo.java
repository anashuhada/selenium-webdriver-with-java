package day43;

import org.testng.Assert;
import org.testng.annotations.*;

public class AssertionDemo {
	
	@Test 
	void testTitle() {
		String expTitle = "OpenCart";
		String actTitle = "Opencart";
		
		// conditional cannot make the test failed
		/*if(expTitle.equals(actTitle)) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}*/
		
		// comparison between exp and act
		Assert.assertEquals(expTitle, actTitle);
		
		/*if(expTitle.equals(actTitle)) {
			System.out.println("Test passed");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Test failed");
			Assert.assertTrue(false);
		}*/
			
	}

}
