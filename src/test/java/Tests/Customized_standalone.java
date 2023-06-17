package Tests;

import Prashant_practice.Page_objects.*;
import Test_Components.Base_test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Customized_standalone extends Base_test {
    @Test(dataProvider ="getData")
    public void Submit_order(HashMap<String,String>input) throws InterruptedException, IOException {
        //Landing_page landing_page= Launch_Website();
        Landing_page landing_page = new Landing_page(driver);
        landing_page.Login(input.get("email"), input.get("password"));
        Catelogue catelogue = new Catelogue(driver);
        List<WebElement> prod = catelogue.get_product();
        catelogue.add_product_to_cart();
        Thread.sleep(2000);
        catelogue.Click_cart_button();
        Cart_page cart_page = new Cart_page(driver);
        Boolean match = cart_page.Verificaton_of_product("ZARA COAT 3");
        Assert.assertTrue(match);
        cart_page.Checkout_page();
        Payments_page paymentsPage = new Payments_page(driver);
        paymentsPage.Select_country("ind");
        paymentsPage.Submit_order();
        Confirmation_page confirmationPage = new Confirmation_page(driver);
        String message = confirmationPage.Message_for_confirmation();
        Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
    }
    @Test(dependsOnMethods = {"Submit_order"})

    public void Orders_item_verification_test(HashMap<String,String>input)
    {
        Landing_page landing_page = new Landing_page(driver);
        landing_page.Login(input.get("email"), input.get("password"));
        Orders_page ordersPage= new Orders_page(driver);
        ordersPage.Orders_page_click();
        Assert.assertTrue(ordersPage.Orders_page_items());
    }
    @DataProvider
    public Object[][] getData()
    {
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("email","prashant123@test.com");
        map.put("password","Prashant123!");

        HashMap<String,String> map1=new HashMap<String,String>();
        map1.put("email","prashant1223@test.com");
        map1.put("password","Prashan2t123!");
        return new Object[][] {{map},{map1}};
       // return new Object[][] {{"prashant123@test.com","Prashant123!"},{"prashantssss@dmail.com","12dddd"}};
    }


        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
//        Thread.sleep(3000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
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



}
