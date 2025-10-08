package test;

import org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;


public class LoginTest extends BaseTest {

    @BeforeMethod
    public void navigateToLogin(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.gotoLogin();
    }

    @Test
    public void validLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitLoginPage();
        loginPage.loginUser("Johnsalon@gmail.com","123456");
        Boolean userStatus = loginPage.userIsOnline();
        Assert.assertTrue(userStatus,"User is not login");
    }

    @Test
    public void invalidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitLoginPage();
        loginPage.loginUser("invalid@gmail.com","654321");
        Boolean userStatus = loginPage.isErrorMessageVisible();
        Assert.assertTrue(userStatus);
    }

    @Test
    public void navigateToRegister(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitLoginPage();
        loginPage.clickRegisterButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl);
        Assert.assertTrue(currentUrl.contains("register"));
    }

    @Test
    public void notExistingUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitLoginPage();
        loginPage.loginUser("chingchong@gmail.com","123456789");
        Boolean userStatus = loginPage.isErrorMessageVisible();
        Assert.assertTrue(userStatus);
    }

}
