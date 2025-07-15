package base_test;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Basetest {
	  public static Actions actions;
	    public static WebDriver driver;

	    public ExtentSparkReporter sparkReporter;
	    public ExtentReports extent;
	    public ExtentTest logger;

	   
	    @BeforeTest
	    public void beforeTestMethod() {
	        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Jai.html");
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        sparkReporter.config().setTheme(Theme.DARK);
	        sparkReporter.config().setDocumentTitle("Automation Report");
	        sparkReporter.config().setReportName("Automation reports until now");

	        extent.setSystemInfo("HostName", "RHEL8");
	        extent.setSystemInfo("UserName", "root");
	        
	    }

	 
	    @BeforeMethod
	    @Parameters({"browser", "url"})
	    public void beforeMethod(@Optional("chrome") String browser, Method testMethod, @Optional("https://example.com") String url) {
	        logger = extent.createTest(testMethod.getName());
	        setupDriver(browser);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        driver.manage().window().maximize();
	        driver.get(url);
	        actions = new Actions(driver); // Accessible globally
	    }

	  
	    @AfterMethod
	    public void afterMethod(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	            logger.log(Status.FAIL, result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	            logger.log(Status.SKIP, result.getThrowable());
	        } else {
	            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
	        }
	    }

	   
	    @AfterTest
	    public void afterTest() {
	        if (driver != null) {
	        	driver.close();
	             driver.quit(); 
	        }
	        extent.flush();
	    }

	   
	    public void setupDriver(String browser) {
	        switch (browser.toLowerCase()) {
	            case "chrome":
	                driver = new ChromeDriver();
	                break;
	            case "firefox":
	                driver = new FirefoxDriver();
	                break;
	            case "edge":
	                driver = new EdgeDriver();
	                break;
	            default:
	                throw new IllegalArgumentException("Browser not supported: " + browser);
	        }
	    }

	    public WebDriverWait getWait(int seconds) {
	        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	    }

	    public WebElement waitForVisibility(By locator, int seconds) {
	        return getWait(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    public WebElement waitForClickable(By locator, int seconds) {
	        return getWait(seconds).until(ExpectedConditions.elementToBeClickable(locator));
	    }

	    public boolean waitForTitleContains(String titleSubstring, int seconds) {
	        return getWait(seconds).until(ExpectedConditions.titleContains(titleSubstring));
	    }

	    public boolean waitForUrlContains(String urlSubstring, int seconds) {
	        return getWait(seconds).until(ExpectedConditions.urlContains(urlSubstring));
	    }
	}
