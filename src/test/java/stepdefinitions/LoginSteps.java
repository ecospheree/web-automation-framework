package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("User is on login page")
    public void user_is_on_login_page() {
        loginPage.openLoginPage();
    }

    @When("User enters valid username and password")
    public void user_enters_valid_credentials() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_credentials() {
        loginPage.inputUsername("invalid_user");
        loginPage.inputPassword("wrong_password");
    }

    @When("User enters empty username and password")
    public void user_enters_empty_credentials() {
        loginPage.inputUsername("");
        loginPage.inputPassword("");
    }

    @And("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User should be redirected to homepage")
    public void user_should_be_redirected_to_homepage() {
        Assert.assertTrue(
                loginPage.getCurrentUrl().contains("inventory")
        );
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Epic sadface")
        );
    }
}