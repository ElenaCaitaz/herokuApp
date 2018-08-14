package main.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//input[@ng-model='user.name']")
    private WebElement userName;

    @FindBy(xpath = "//input[@ng-model='user.password']")
    private WebElement userPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login;

    @FindBy(xpath = "//*[@id='login-form']/fieldset/p[1]")
    private WebElement errorMessage;

    public EmployeesPage userLogin(String username, String password) {
        userName.sendKeys(username);
        userPassword.sendKeys(password);
        login.click();
        return new EmployeesPage();
    }

    public WebElement errorMessage(){
        return errorMessage;
    }
    public boolean onThePage() {
        return super.onThePage(userName);
    }
}

