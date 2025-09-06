package page;

import org.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private By navigateToRegister = By.className("ico-register");
    private By navigateToLogin = By.className("ico-login");
    private By navigateToWishlist = By.className("ico-wishlist");
    private By navigateToShoppingcart = By.className("ico-cart");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage gotoRegister(){
        click(navigateToRegister);
        return new RegisterPage(driver);
    }

    public LoginPage gotoLogin(){
        click(navigateToLogin);
        return new LoginPage(driver);
    }

    public ShoppingcartPage gotoShoppingcart(){
        click(navigateToShoppingcart);
        return new ShoppingcartPage(driver);
    }

    public WishlistPage gotoWishlist(){
        click(navigateToWishlist);
        return new WishlistPage(driver);
    }
}
