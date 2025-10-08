package test;

import data.UserRegisterData;
import org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.MainPage;
import page.RegisterPage;

public class RegisterTest extends BaseTest {

    @BeforeMethod
    public void NavigateToRegister(){
        MainPage mainPage = new MainPage(driver);
        mainPage.gotoRegister();
    }

    @Test (dataProvider = "registerUserData", dataProviderClass = UserRegisterData.class)
    public void RegisterMale(String firstName, String lastName, String email, String companyName, String password, String password2) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitRegisterPage();
        registerPage.enterFullDetailsMale(firstName,lastName,email,companyName,password,password2);
        registerPage.submitRegistration();
        String currentUrl = driver.getCurrentUrl(); //get current URL for assertion
        Assert.assertNotNull(currentUrl,"URL Not found");
        Assert.assertTrue(currentUrl.contains("registerresult"), "Invalid registration data");
    }

    @Test (dataProvider = "registerUserData", dataProviderClass = UserRegisterData.class)
    public void RegisterFemale(String firstName, String lastName, String email, String companyName, String password, String password2){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitRegisterPage();
        registerPage.enterFullDetailsFemale(firstName,lastName,email,companyName,password,password2);
        registerPage.submitRegistration();
        String currentUrl = driver.getCurrentUrl(); //get current URL for assertion
        Assert.assertNotNull(currentUrl,"URL Not found");
        Assert.assertTrue(currentUrl.contains("registerresult"), "Invalid registration data");
    }

    @Test (dataProvider = "invalidRegisterUserData", dataProviderClass = UserRegisterData.class)
    public  void invalidRegister(String firstName, String email, String companyName, String password, String password2) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitRegisterPage();
        registerPage.enterDetailsNoLastname(firstName,email,companyName,password, password2);
        registerPage.submitRegistrationError();
        Assert.assertTrue(registerPage.isErrorMessageDisplayed());
    }

}
