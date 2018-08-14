package main.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewEmployeePage extends PageObject  {

    @FindBy(xpath = "//fieldset/label[1]/input")
    private WebElement firstName;

    @FindBy(xpath = "//fieldset/label[2]/input")
    private WebElement lasttName;

    @FindBy(xpath = "//fieldset/label[3]/input")
    private WebElement startDate;

    @FindBy(xpath = "//fieldset/label[4]/input")
    private WebElement email;

    @FindBy(xpath = "//div/button[2]")
    private WebElement add;

    @FindBy(xpath = "//*[@id='sub-nav']/li")
    private WebElement cancel;

    public WebElement firstName() {
        return firstName;
    }

    public WebElement lastName() {
        return lasttName;
    }

    public WebElement startDate() {
        return startDate;

    }

    public WebElement email() {
        return email;
    }

    public WebElement addButton() {
        return add;
    }
}
