package main.java.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.commons.DataKeys;
import main.java.commons.ScenarioContext;
import main.java.models.EmployeeDetails;
import main.java.pages.EditEmployeePage;
import main.java.pages.EmployeesPage;
import main.java.pages.LoginPage;
import main.java.pages.NewEmployeePage;
import main.java.utils.Utility;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;

public class UiSteps {
    private ScenarioContext context = ScenarioContext.getInstance();

    @Given("^user navigates to Login page$")
    public void userNavigatesToPage() {
        context.getDriver().get("http://cafetownsend-angular-rails.herokuapp.com");
        LoginPage loginPage = (LoginPage) context.getPage(LoginPage.class);
        Assert.assertTrue("Login page fail to open", loginPage.onThePage());

    }

    @When("^user logs in with '(.*)' username and '(.*)' password$")
    public void userLogsInWithUsernameAndPassword(String name, String password) {
        context.getDriver().get("http://cafetownsend-angular-rails.herokuapp.com");
        LoginPage loginPage = (LoginPage) context.getPage(LoginPage.class);
        loginPage.userLogin(name, password);
        Utility.takeScreenshot(context.getDriver(), "User enters credentials");
    }


    @Then("^user is redirected to Employees page$")
    public void userIsRedirectedToEmployeesPage() {
        EmployeesPage employeesPage = (EmployeesPage) context.getPage(EmployeesPage.class);
        Assert.assertTrue("User is redirected to Page", employeesPage.onThePage());
        Utility.takeScreenshot(context.getDriver(), "Employees page");
    }

    @When("^user clicks on Logout$")
    public void userClicksOnLogout() {
        EmployeesPage employeesPage = (EmployeesPage) context.getPage(EmployeesPage.class);
        employeesPage.logoutButton().click();
        Utility.takeScreenshot(context.getDriver(), "User is logged out");
    }

    @Then("^user is redirected to Login page$")
    public void userIsRedirectedToLoginPage() throws Throwable {
        LoginPage loginPage = (LoginPage) context.getPage(LoginPage.class);
        Assert.assertTrue("User is redirected to Page", loginPage.onThePage());
        Utility.takeScreenshot(context.getDriver(), "Redirected to Login page");
    }

    @Then("^error message '(.*)' is displayed$")
    public void errorMessageInvalidUsernameOrPasswordIsDisplayed(String expectedError) {
        LoginPage loginPage = (LoginPage) context.getPage(LoginPage.class);
        String actualError = loginPage.errorMessage().getText();
        Assert.assertThat(actualError, is(expectedError));
        Utility.takeScreenshot(context.getDriver(), "Error is displayed");
    }

    @When("^user clicks on Create$")
    public void userClicksOnCreate() {
        EmployeesPage employeesPage = (EmployeesPage) context.getPage(EmployeesPage.class);
        employeesPage.createButton().click();
    }

    @When("^user (fills-in|updates) employee details with the following data$")
    public void userFillsInEmployeeDetailsWithTheFollowingData(String type, List<EmployeeDetails> detailsList) {
        EmployeeDetails employeeDetails = detailsList.get(0);

        NewEmployeePage newEmployee = (NewEmployeePage) context.getPage(NewEmployeePage.class);
        newEmployee.firstName().clear();
        newEmployee.firstName().sendKeys(employeeDetails.getFirstName());
        newEmployee.lastName().clear();
        newEmployee.lastName().sendKeys(employeeDetails.getLastName());
        newEmployee.startDate().clear();
        newEmployee.startDate().sendKeys(employeeDetails.getStartDate());
        newEmployee.email().clear();
        newEmployee.email().sendKeys(employeeDetails.getEmail());

        String firstName= employeeDetails.getFirstName();
        String lastName = employeeDetails.getLastName();
        context.save(DataKeys.EMPLOYEE_FIRSTNAME, firstName);
        context.save(DataKeys.EMPLOYEE_LASTNAME, lastName);
    }

    @When("^user clicks on Add$")
    public void userClicksOnAdd() {
        NewEmployeePage newEmployee = (NewEmployeePage) context.getPage(NewEmployeePage.class);
        newEmployee.addButton().click();
    }

    @Then("^employee was (created|updated) successfully$")
    public void employeeWasCreatedSuccessfully(String type) {
        EmployeesPage employeesPage = (EmployeesPage) context.getPage(EmployeesPage.class);
        List<WebElement> allEmployees = employeesPage.getEmployees();
        String employeeFirstName = (String) context.getData(DataKeys.EMPLOYEE_FIRSTNAME);
        String employeeLastName = (String) context.getData(DataKeys.EMPLOYEE_LASTNAME);
        Optional<WebElement> name = allEmployees.stream().filter(r -> r.getText().equals(employeeFirstName +" "+employeeLastName)).findFirst();
        Assert.assertTrue("Employee is created", name.isPresent());
        Utility.takeScreenshot(context.getDriver(), "Employee is displayed");
    }

    @When("^user clicks on Edit$")
    public void userClicksOnEdit() {
        EmployeesPage employeesPage = (EmployeesPage) context.getPage(EmployeesPage.class);
        employeesPage.editButton().click();
    }

    @When("^user clicks on first employee$")
    public void userClicksOnFirstEmployee() {
        EmployeesPage employeesPage = (EmployeesPage) context.getPage(EmployeesPage.class);
        WebElement firstEmployee = employeesPage.getEmployees().get(0);
        firstEmployee.click();
    }

    @When("^user clicks on Update$")
    public void userClicksOnUpdate() {
        EditEmployeePage editEmployee = (EditEmployeePage) context.getPage(EditEmployeePage.class);
        editEmployee.updateButton().click();
    }
}

