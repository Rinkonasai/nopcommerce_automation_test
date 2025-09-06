package test;

import org.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;
import page.MainPage;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void navigateToLogin(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.gotoLogin();
    }
}
