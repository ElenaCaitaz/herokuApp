package main.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeesPage extends PageObject {

    @FindBy(xpath = "//*[@id='bAdd']")
    private WebElement create;

    @FindBy(xpath = "//*[@id='bEdit']")
    private WebElement edit;

    @FindBy(xpath = "//*[@id='bDelete']")
    private WebElement delete;

    @FindBy(xpath = "//header/div/p[1]")
    private WebElement logout;

    @FindBy(xpath = "//*[@id='employee-list']/li")
    private List<WebElement> employees;


    public WebElement logoutButton() {
        return logout;
    }

    public WebElement editButton() {
        return edit;
    }
    public WebElement createButton() {
        return create;
    }

    public List<WebElement> getEmployees(){
        return employees;
    }

    public boolean onThePage() {
        return super.onThePage(create);
    }


}
