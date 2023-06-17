package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Reports {
    public static ExtentReports Get_report_obj()
    {
        String path= System.getProperty("J:\\Selenium\\Frameworksparactice\\MyFramewrok\\Screenshorts")+"//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Result");
        reporter.config().setDocumentTitle("Result for Testcases");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester =","Prashant");
        return extent;


    }
}
