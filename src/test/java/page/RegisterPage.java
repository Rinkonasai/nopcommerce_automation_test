package page;

import org.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By submitButton = By.id("register-button");
    private By errorMessage = By.className("field-validation-error");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName){
        sendKeys(firstNameField, firstName);
    }

    public void enterLastName(String lastName){
        sendKeys(lastNameField, lastName);
    }

    public void enterEmail(String email){
        sendKeys(emailField, email);
    }

    public RegisterPage enterDetails(String firstName, String lastName, String email){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        return this;
    }

    public MainPage submitRegistration(){
        click(submitButton);
        wait.until(ExpectedConditions.urlContains("registerresult"));
        return new MainPage(driver);
    }

    public RegisterPage submitRegistrationError(){
        click(submitButton);
        return this;
    }

    public boolean isErrorMessageDisplayed(){
        return isDisplayed(errorMessage);
    }
}
