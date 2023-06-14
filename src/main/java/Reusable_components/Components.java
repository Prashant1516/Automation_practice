package Reusable_components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Components {

    public WebDriver driver;

    public Components(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement Cart_button;
    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement Orders_on_header;


    public void Click_cart_button() {
        Cart_button.click();
    }


    public void wait_to_appear(By findby) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));

    }

    public  void Orders_page_click() {
        Orders_on_header.click();
    }


    public void Explicit_wait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}

