package day44;

import org.testng.annotations.*;

public class PaymentTests {
	
	@Test(priority=1, groups = {"sanity", "regression", "functional"})
	void paymentInMYR() {
		System.out.println("Payment in MYR...");
	}
	
	@Test(priority=1, groups = {"sanity", "regression", "functional"})
	void paymentInUSD() {
		System.out.println("Payment in USD...");
	}

}
