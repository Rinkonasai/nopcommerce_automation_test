package page;

import org.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    private By maleGender = By.id("gender-male");
    private By femaleGender = By.id("gender-female");
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By companyField = By.id("Company");
    private By newsletterBox = By.id("Newsletter");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By submitButton = By.id("register-button");
    private By errorMessage = By.className("field-validation-error");
    private By errorMessage2 = By.cssSelector("li");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void clickMaleGender(){ click(maleGender); }
    public void clickFemaleGender(){ click(femaleGender); }
    public void enterFirstName(String firstName){
        sendKeys(firstNameField, firstName);
    }
    public void enterLastName(String lastName){
        sendKeys(lastNameField, lastName);
    }
    public void enterEmail(String email){
        sendKeys(emailField, email);
    }
    public void enterCompanyName(String companyName){ sendKeys(companyField, companyName); }
    public void newsletter(){ click(newsletterBox); }
    public void enterPassword(String password){ sendKeys(passwordField, password); }
    public void confirmPassword(String password){ sendKeys(confirmPasswordField, password); }



    //Unfinished
    public RegisterPage enterDetails(String firstName, String lastName, String email, String password, String password2){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        newsletter();
        enterPassword(password);
        confirmPassword(password2);
        return this;
    }

    public MainPage submitRegistration(){
        click(submitButton);
        wait.until(ExpectedConditions.urlContains("registerresult"));
        return new MainPage(driver);
    }

    public RegisterPage submitRegistrationError(){
        click(submitButton);
        //System.out.println("Error Detected");
        return this;
    }

    public boolean isErrorMessageDisplayed(){
        return isDisplayed(errorMessage) || isDisplayed(errorMessage2) ;
    }
}
