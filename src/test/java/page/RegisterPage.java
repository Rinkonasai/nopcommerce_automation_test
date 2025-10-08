package page;

import org.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    protected By maleGender = By.id("gender-male");
    protected By femaleGender = By.id("gender-female");
    protected By firstNameField = By.id("FirstName");
    protected By lastNameField = By.id("LastName");
    protected By emailField = By.id("Email");
    protected By companyField = By.id("Company");
    protected By newsletterBox = By.id("Newsletter");
    protected By passwordField = By.id("Password");
    protected By confirmPasswordField = By.id("ConfirmPassword");
    protected By submitButton = By.id("register-button");
    protected By errorMessage = By.className("field-validation-error");
    protected By errorMessage2 = By.cssSelector("li");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Testing will wait until the url contains register before proceeding
    public void waitRegisterPage(){ wait.until(ExpectedConditions.urlContains("register"));}

    //Web elements inside the register page
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

    //Test methods
    public void enterFullDetailsMale(String firstName, String lastName, String email, String companyName, String password, String password2){
        clickMaleGender();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterCompanyName(companyName);
        newsletter();
        enterPassword(password);
        confirmPassword(password2);
    }

    public void enterFullDetailsFemale(String firstName, String lastName, String email, String companyName, String password, String password2){
        clickFemaleGender();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterCompanyName(companyName);
        newsletter();
        enterPassword(password);
        confirmPassword(password2);
    }

    public RegisterPage enterDetailsNoLastname(String firstName, String email, String companyName, String password, String password2){
        enterFirstName(firstName);
        enterEmail(email);
        enterCompanyName(companyName);
        newsletter();
        enterPassword(password);
        confirmPassword(password2);
        return this;
    }

    public MainPage submitRegistration(){
        click(submitButton);
        return new MainPage(driver);
    }

    public RegisterPage submitRegistrationError(){
        click(submitButton);
        System.out.println("Error detected[!]");
        return this;
    }

    public boolean isErrorMessageDisplayed(){
        return isDisplayed(errorMessage) || isDisplayed(errorMessage2) ;
    }

}
