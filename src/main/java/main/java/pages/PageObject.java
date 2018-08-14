package main.java.pages;

import main.java.commons.ScenarioContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    public boolean onThePage(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ScenarioContext.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
}

