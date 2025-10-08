package test;

import org.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;
import page.MainPage;

public class EcommerceTest extends BaseTest {

    @BeforeMethod
    public void loginUser(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.gotoLogin();
        loginPage.loginUser("Johnsalon@gmail.com","123456");
    }


}
