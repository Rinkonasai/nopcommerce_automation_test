package test;

import org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.MainPage;
import page.RegisterPage;

public class RegisterTest extends BaseTest {


    @BeforeMethod
    public void NavigateToRegister(){
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = mainPage.gotoRegister();
    }

    @Test
    public void Register() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterDetails(
                "John",
                "Salon",
                "Johnsalon@gmail.com",
                "123456",
                "123456"
        );

        registerPage.submitRegistrationError();

        Assert.assertTrue(registerPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid registration data");
    }

}
