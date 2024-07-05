package MySeleniumProject.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Happy Automation File");
		
		reporter.config().setDocumentTitle("Harry Automation Results");
		
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Automation Engineer", "Harpreet Sindhia");
		
		return extent;
		
		
		
}
}