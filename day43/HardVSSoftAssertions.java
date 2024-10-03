package day43;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class HardVSSoftAssertions {
	
	//@Test
	void testHardAssertions() {
		System.out.println("Testing...");
		System.out.println("Testing...");
		
		// hard assertion
		Assert.assertEquals(1, 2); // assertion failed the rest of the code wont be executed
		
		System.out.println("Testing...");
		System.out.println("Testing...");
		
		// last step use assertion
	}
	
	@Test
	void testSoftAssertions() {
		System.out.println("Testing...");
		System.out.println("Testing...");
		
		// must create SoftAssert class object
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2); // soft assertion
		
		System.out.println("Testing...");
		System.out.println("Testing...");
		
		sa.assertAll(); // this is mandatory 
	}

}
