package Prashant_practice.Page_objects;

import Reusable_components.Components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Catelogue extends Components {

    WebDriver driver;

    public Catelogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".offset-sm-1")
    List<WebElement> list_of_products;
    By products = By.cssSelector(".mb-3");
    By product_to_cart = By.xpath("/html/body/app-root/app-dashboard/section[2]/div[1]/div[2]/div[1]/div/div/button[2]");
    By Taost = By.id("toast-container");

    public List<WebElement> get_product() {
        wait_to_appear(products);
        return list_of_products;
    }

    public void add_product_to_cart() {
        WebElement a = list_of_products.stream().filter(product ->
                product.findElement(By.cssSelector(".offset-sm-1 div div h5 b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        a.findElement(product_to_cart).click();
        wait_to_appear(Taost);


    }
}
