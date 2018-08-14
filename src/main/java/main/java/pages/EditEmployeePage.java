package main.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditEmployeePage extends main.java.pages.PageObject {

    @FindBy(xpath = "//fieldset/div/button[1]")
    private WebElement update;

    @FindBy(xpath = "//fieldset/div/p")
    private WebElement delete;

    public WebElement updateButton() {
        return update;
    }

    public WebElement deleteButton() {
        return delete;
    }
}
