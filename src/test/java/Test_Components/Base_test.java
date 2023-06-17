package Test_Components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base_test {
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)

    public void Invoke_driver() throws IOException {
        Properties prop = new Properties();
        FileInputStream File = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Global.properties");
        prop.load(File);
        String Browser_name = prop.getProperty("Browser");
        if (Browser_name.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/client");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        }
        //   return driver;
    }

    @AfterMethod(alwaysRun = true)

    public void Teardown() {
        driver.close();
    }

    public String Take_screen_short(String testcase_name,WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "//reports//"+testcase_name + ".png");
        FileUtils.copyFile(source, destination);
        return System.getProperty("user.dir") + "//reports//"+ testcase_name + ".png";
    }


//    public Landing_page Launch_Website()
//    {
//        Landing_page landing_page = new Landing_page(driver);
//        landing_page.Goto();
//        return landing_page;
//    }
}



