//package PRashantFrameworkPractice;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import java.time.Duration;
//import java.util.List;
//
//public class Stand_alone {
//    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        Testcases.Landing_page landingPage =new Testcases.Landing_page(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
//        driver.manage().window().maximize();
//        driver.get("https://rahulshettyacademy.com/client");
//        driver.findElement(By.id("userEmail")).sendKeys("prashant123@test.com");
//        driver.findElement(By.id("userPassword")).sendKeys("Prashant123!");
//        driver.findElement(By.id("login")).click();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//
//        List <WebElement> products= driver.findElements(By.cssSelector(".offset-sm-1"));
//        WebElement prod= products.stream().filter(product->
//                product.findElement(By.cssSelector(".offset-sm-1 div div h5 b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//        prod.findElement(By.xpath("/html/body/app-root/app-dashboard/section[2]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
//        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
//        Thread.sleep(3000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
//          WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
//
//        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
//
//        List <WebElement> cart= driver.findElements(By.cssSelector(".cartSection h3"));
//
//        Boolean a =  cart.stream().anyMatch(cartprod->cartprod.getText().equalsIgnoreCase("ZARA COAT 3"));
//        Assert.assertTrue(a);
//        driver.findElement(By.cssSelector(".totalRow button")).click();
//        // driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
//        Actions b= new Actions(driver);
//        b.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
//        driver.findElement(By.xpath("//button [@class='ta-item list-group-item ng-star-inserted'][2]")).click();
//        driver.findElement(By.cssSelector("[class*='action__submit']")).click();
//        String message= driver.findElement(By.cssSelector("[class='hero-primary']")).getText();
//        Assert.assertTrue(message.equalsIgnoreCase("Thank you for the order."));
//
//
//    }
//}
