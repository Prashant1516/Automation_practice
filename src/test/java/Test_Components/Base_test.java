package Test_Components;

import Prashant_practice.Page_objects.Landing_page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base_test {
   public static WebDriver driver;

    @BeforeClass

    public void Invoke_driver() throws IOException {
        Properties prop = new Properties();
        FileInputStream File = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Global.properties");
        prop.load(File);
        String Browser_name = prop.getProperty("Browser");
        if (Browser_name.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/client");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        }
    }



    public Landing_page Launch_Website()
    {
        Landing_page landing_page = new Landing_page(driver);
        landing_page.Goto();
        return landing_page;
    }
}


