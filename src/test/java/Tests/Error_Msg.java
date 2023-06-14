package Tests;

import Prashant_practice.Page_objects.Landing_page;
import Test_Components.Base_test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Error_Msg extends Base_test {

    @Test

    public void Error_validation()
    {
        Landing_page landing_page =new Landing_page(driver);
        landing_page.Login("prashant12343433@test.com","Prashant123!");
        landing_page.Error_Message();
        Assert.assertEquals("Incorrect email or password.", landing_page.Error_Message());

    }
    @Test
    public void Error_on_null_credential()
    {
        Landing_page landing_page = new Landing_page(driver);
        landing_page.Login("","");
        landing_page.Error_on_null();
        Assert.assertEquals("*Enter Valid Email", landing_page.Error_on_null());
    }
}
