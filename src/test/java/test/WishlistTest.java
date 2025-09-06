package test;

import org.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import page.MainPage;
import page.WishlistPage;

public class WishlistTest extends BaseTest {

    @BeforeMethod
    public void navigateToWishlist(){
        MainPage mainPage = new MainPage(driver);
        WishlistPage wishlistPage = mainPage.gotoWishlist();
    }
}
