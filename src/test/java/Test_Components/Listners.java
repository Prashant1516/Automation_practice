package Test_Components;

import Resources.Extent_Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import org.testng.ITestListener;

import java.io.IOException;

public class Listners extends Base_test implements ITestListener {
    ExtentTest Test;

    ExtentReports extent = Extent_Reports.Get_report_obj();

    @Override
    public void onTestStart(ITestResult result) {
        Test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Test.fail(result.getThrowable());
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        }
        catch (Exception e1){
            e1.printStackTrace();

        }
        String File_path = null;//taking screenshorts for failed testcases.
        try {
           File_path= Take_screen_short(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Test.addScreenCaptureFromPath(File_path, result.getMethod().getMethodName());
    }


    @Override
    public void onTestSkipped(ITestResult result)
    {

    }

    @Override
    public void onFinish(ITestContext context
    )
    {
        extent.flush();
    }

}
