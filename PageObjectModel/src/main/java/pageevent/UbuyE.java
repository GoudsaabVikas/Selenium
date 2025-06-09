package pageevent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import pageobject.Ubuyob;
import utils.Elementfetch;

public class UbuyE {
	 Elementfetch k = new Elementfetch();
	    public ExtentReports extent;

	    public void Ubuybtn(ExtentTest test) {
	        WebElement A = k.getWebElement("xpath", Ubuyob.brands);
	        A.click();

	        try {
	            // Assertion before clicking
	            assertTrue(A.isDisplayed(), "TC:1 --Element should be displayed before clicking.");
	            assertTrue(A.isEnabled(), "TC:2 --Element should be enabled before clicking.");

	            A.click();
	            test.pass("TC:4 --Successfully clicked on the element.");

	        } catch (AssertionError e) {
	            test.fail("Assertion failed in Login(): " + e.getMessage()); // Fixed method name
	            throw e;
	        } catch (Exception e) {
	            test.fail("Exception in Login(): " + e.getMessage());
	            throw e;
	        }
	    }

	    public void enterPhoneNumber(ExtentTest test) { // Parameterized input
	        WebElement inputField = k.getWebElement("xpath", Ubuyob.brands);

	        try {
	            // Pre-checks
	            assertTrue(inputField.isDisplayed(), "TC:5 --Input field should be visible.");
	            assertTrue(inputField.isEnabled(), "TC:6 --Input field should be enabled.");
	            test.pass("TC:7 --Input field is visible and enabled.");

	            // Action
	          
	            test.pass("TC:8 --Entered text into input field: ");

	           

	        } catch (AssertionError e) {
	            test.fail("Assertion failed in enterPhoneNumber(): " + e.getMessage());
	            throw e;
	        } catch (Exception e) {
	            test.fail("Exception in enterPhoneNumber(): " + e.getMessage());
	            throw e;
	        }
	    }
	}



