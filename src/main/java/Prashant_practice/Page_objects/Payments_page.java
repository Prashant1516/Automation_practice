package Prashant_practice.Page_objects;

import Reusable_components.Components;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payments_page extends Components {
    WebDriver driver;
    public Payments_page(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;
    @FindBy(xpath = "//button [@class='ta-item list-group-item ng-star-inserted'][2]")
    WebElement index;
    @FindBy(css = "[class*='action__submit']")
    WebElement Last_submit;
    public void Select_country(String country_checkout)
    {
       country.sendKeys(country_checkout);//ind
        Explicit_wait();

//        Actions b= new Actions(driver);
//        b.sendKeys(index,country_checkout).build().perform();
//        b.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),country_checkout).build().perform();
      //  index.click();

    }
    public void Submit_order() {
        index.click();
        Last_submit.click();
    }
}
