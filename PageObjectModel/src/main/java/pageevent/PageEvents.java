package pageevent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageobject.Pageobject;
import utils.Elementfetch;

public class PageEvents {
    Elementfetch k = new Elementfetch();
    public ExtentReports extent;

    public void young(ExtentTest test) {
        WebElement A = k.getWebElement("xpath", Pageobject.css);

        try {
            // Assertion before clicking
            assertTrue(A.isDisplayed(), "TC:1 --Element should be displayed before clicking.");
            assertTrue(A.isEnabled(), "TC:2 --Element should be enabled before clicking.");
            test.pass("TC:3 --Element is displayed and enabled before clicking.");

            A.click();
            test.pass("TC:4 --Successfully clicked on the element.");

            // Optional: Add assertion after click if UI change occurs
            // e.g. verify redirection or next element
        } catch (AssertionError e) {
            test.fail("Assertion failed in young(): " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("Exception in young(): " + e.getMessage());
            throw e;
        }
    }

    public void woung(ExtentTest test) {
        WebElement inputField = k.getWebElement("xpath", Pageobject.link);
        String inputText = "jsjshd";

        try {
            // Pre-checks
            assertTrue(inputField.isDisplayed(), "TC:5 --Input field should be visible.");
            assertTrue(inputField.isEnabled(), "TC:6 --Input field should be enabled.");
            test.pass("TC:7 --Input field is visible and enabled.");

            // Action
            inputField.sendKeys(inputText);
            test.pass("TC:8 --Entered text into input field: " + inputText);

            // Post-condition
            assertEquals(inputField.getAttribute("value"), inputText, "Text should be entered correctly.");
            test.pass("TC:9 --Verified input text is present in the field.");

        } catch (AssertionError e) {
            test.fail("Assertion failed in woung(): " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("Exception in woung(): " + e.getMessage());
            throw e;
        }
    }
}
