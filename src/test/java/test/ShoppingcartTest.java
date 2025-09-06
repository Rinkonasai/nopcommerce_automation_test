package test;

import org.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import page.MainPage;
import page.ShoppingcartPage;

public class ShoppingcartTest extends BaseTest {

    @BeforeMethod
    public void navigateToShoopingCart(){
        MainPage mainPage = new MainPage(driver);
        ShoppingcartPage shoppingcartPage = mainPage.gotoShoppingcart();
    }

}
