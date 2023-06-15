package Prashant_practice.Page_objects;

import Reusable_components.Components;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Orders_page extends Components {
    WebDriver driver;

    public Orders_page(WebDriver driver) {
        super(driver);
        this.driver= driver;
    }
    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> orders_items;

    public Boolean Orders_page_items()
    {
        Boolean match= orders_items.stream().anyMatch(product->product.getText().equalsIgnoreCase("ZARA COAT 3"));
        return match;
    }
}
