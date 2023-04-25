package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
public static ExtentReports createReports() {
		
		ExtentReports reports= new ExtentReports ();
		ExtentSparkReporter htmlReports = new ExtentSparkReporter ("Swaglabs.html");
		reports.attachReporter(htmlReports);
		reports.setSystemInfo("Application", "Swaglabs");
		reports.setSystemInfo("TestType", "Regression");
		reports.setSystemInfo("Created by", "pratiksha");
		
		return reports;

}
}