package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;



public class SuiteListner implements ITestListener, IAnnotationTransformer{
	public void onTestFailure(ITestResult result) {
	String filename = System.getProperty("user.dir")+ File.separator+"Screenshots"+File.separator+result.getMethod().getMethodName();
	File f1 = ((TakesScreenshot)base_test.Basetest.driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(f1, new File(filename+".png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public void transform(
		ITestAnnotation annotation, Class testClass, Constructor testConstrutor, Method testMethod) {
	annotation.setRetryAnalyzer(RetryAnalzers.class);
	

}
}