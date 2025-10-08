package data;

import org.testng.annotations.DataProvider;

public class UserRegisterData {


    //firstName, lastName, email, companyName, password, password2
    @DataProvider (name = "registerUserData")
    public static Object[][] getUserRegisterData() {
        return new Object[][]{
                {"John", "Salon", "Johnsalon@gmail.com", "IBM", "123456", "123456"},
                {"Salon", "John", "Salonjohn@gmail.com", "BMI", "123456", "123456"}
        };
    }

    @DataProvider (name = "registerUserData2")
    public static Object[][] getUserRegisterData2(){
        return new Object[][]{
                {"Emily", "Gryfin", "Emilyana@gmail.com", "Accenture", "123456", "123456"},
                {"Gryfin", "Emily", "Anaemily@gmail.com", "Google", "123456", "123456"}
        };
    }

    @DataProvider (name = "invalidRegisterUserData")
    public static Object[][] getInvalidUserRegisterData(){
        return new Object[][]{
                {"Tel", "Telmona@gmail.com", "Amadeus", "123456", "123456"}
        };
    }
}
