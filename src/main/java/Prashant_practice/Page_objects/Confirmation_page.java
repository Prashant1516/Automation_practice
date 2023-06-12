package Prashant_practice.Page_objects;

import Reusable_components.Components;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmation_page extends Components {
    WebDriver driver;

    public Confirmation_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class='hero-primary']")
    WebElement confirmation_text;

    public String Message_for_confirmation() {
        String message = confirmation_text.getText();//text got
        return message;
    }
}
