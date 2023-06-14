package Prashant_practice.Page_objects;

import Reusable_components.Components;
import org.openqa.selenium.By;
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

    @FindBy(css="[class*='flyInOut']")
    WebElement error_text;
    @FindBy(xpath = "//div[contains(text(),'*Enter Valid Email')]")
    WebElement Error_on_nulll;
    @FindBy(css = "[class='forgot-password-link']")
    WebElement forget_pass;


    public void Login(String Email, String Password)
    {
        useremail.sendKeys(Email);
        password.sendKeys(Password);
        submit.click();
    }
    public String Error_Message()
    {
        Explicit_wait();
        return error_text.getText();

    }
    public String Error_on_null()
    {
       // wait_to_appear(By.xpath("//div[contains(text(),'*Enter Valid Email')]"));
        return Error_on_nulll.getText();
    }
    public void Forget_pass_button()
    {
        forget_pass.click();
    }
    public void Goto()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }

}
