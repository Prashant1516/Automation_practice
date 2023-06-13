package Prashant_practice.Page_objects;

import Reusable_components.Components;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_page extends Components {
    WebDriver driver;
    public Landing_page(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="userEmail")
    WebElement useremail;
    @FindBy(id="userPassword")
    WebElement password;
    @FindBy(id="login")
    WebElement submit;

    public void Login(String Email, String Password)
    {
        useremail.sendKeys(Email);
        password.sendKeys(Password);
        submit.click();
    }
//    public void Goto()
//    {
//        driver.get("https://rahulshettyacademy.com/client");
//    }

}
