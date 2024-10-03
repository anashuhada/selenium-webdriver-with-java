package day43;

import org.testng.Assert;
import org.testng.annotations.*;

public class HardAssertions {
	
	@Test 
	void test() {
		
		// compare String
		Assert.assertEquals("xyz", "xyz1");
		
		// compare numbers
		Assert.assertEquals(123, 456);
		Assert.assertEquals(123, "abc");
		Assert.assertEquals(123, "123");
		
		Assert.assertNotEquals(123, 123); // failed
		Assert.assertNotEquals(123, 456); // passed
		
		Assert.assertTrue(true); // passed
		Assert.assertTrue(false); // failed
		
		Assert.assertTrue(1 == 2); // failed
		Assert.assertTrue(1 == 1); // passed
		
		Assert.assertFalse(1 == 2); // passed
		Assert.assertFalse(1 == 1); // failed
		
		Assert.fail(); // failed
	}
	

}
