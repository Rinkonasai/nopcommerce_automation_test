package page;

import org.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    protected By emailField = By.id("Email");
    protected By passwordField = By.id("Password");
    protected By loginButton = By.className("login-button");
    protected By registerButton = By.className("register-button");
    protected By myAccountIsVisible = By.className("ico-account");
    protected By errorMessage = By.className("message-error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Testing will wait until the url contains login before proceeding
    public void waitLoginPage(){ wait.until(ExpectedConditions.urlContains("login"));}

    public void enterEmail(String email){ sendKeys(emailField, email);}
    public void enterPassword(String password){ sendKeys(passwordField,password);}
    public void clickLoginButton(){ click(loginButton);}
    public void clickRegisterButton(){ click(registerButton);}

    public void loginUser(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void navigateToRegister(){
        clickRegisterButton();
    }

    public Boolean isErrorMessageVisible(){
        return isDisplayed(errorMessage);
    }

    public Boolean userIsOnline(){
        return isDisplayed(myAccountIsVisible);
    }
}
