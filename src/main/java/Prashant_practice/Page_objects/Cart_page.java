package Prashant_practice.Page_objects;

import Reusable_components.Components;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Cart_page extends Components {
    WebDriver driver;
    public Cart_page(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = ".cartSection h3")
    List<WebElement> cart_list;
    @FindBy(css = ".totalRow button")
    WebElement checkout;

    public Boolean Verificaton_of_product(String product_name)
    {
      //  List<WebElement> cart= driver.findElements(By.cssSelector(".cartSection h3"));

        Boolean a =  cart_list.stream().anyMatch(cart_prod->cart_prod.getText().equalsIgnoreCase(product_name));
        return a;

    }
    public void Checkout_page()
    {
        checkout.click();
    }

}
