package kyPointTest.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kyPointTest.pages.LoginPage;


public class LoginStepDef {
LoginPage loginPage = new LoginPage();

    @Given("user navigate landing page")
    public void user_navigate_landing_page() {
        loginPage.navigateLandingPage();

    }

    @When("enter valid credentials {string} {string} and click login")
    public void enterValidCredentialsAndClickLogin(String userName, String password) {
        loginPage.setLoginButton(userName,password);

    }

    @Then("verify message {string}")
    public void verifyMessage(String message) {
        loginPage.verifyMessage(message);


    }

    @Then("verify errorMessage {string}")
    public void verifyErrorMessage(String errorMessage) {
        loginPage.verifyErrorMessage(errorMessage);
    }
}
