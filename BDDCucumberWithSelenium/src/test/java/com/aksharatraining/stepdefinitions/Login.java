package com.aksharatraining.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login {

    @Given("The Login page is displayed")
    public void theLoginPageIsDisplayed() {
        System.out.println("The login page is displayed");
    }

    @When("The user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() {
        System.out.println("The user enters valid username and password");
    }

    @When("The user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        System.out.println("The user clicks on the login button");
    }

    @Then("Home page should be displayed")
    public void homePageShouldBeDisplayed() {
        System.out.println("Home page should be displayed");
    }

    @When("The user enters in-valid username and password")
    public void theUserEntersInValidUsernameAndPassword() {
        System.out.println("The user enters in-valid username and password");
    }

    @Then("Error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        System.out.println("Error message should be displayed");
//        Assert.assertEquals(true, false);
    }

    // {string} is a cucumber expression
    // For more details on cucumber expression parameter values use: https://github.com/cucumber/cucumber-expressions#parameter-types
    @When("The user enters {string} as username and {string} as password")
    public void theUserEntersAsUsernameAndAsPassword(String username, String pwd) {
        System.out.println("The user enters " + username + " as username and " + pwd + " as password");
    }

    @Given("Path of the driver executable is set")
    public void pathOfTheDriverExecutableIsSet() {
        System.out.println("Path of the driver executable is set");
    }

    @Given("The browser is open")
    public void theBrowserIsOpen() {
        System.out.println("The browser is open");
    }

    @Given("The browser is maximized")
    public void theBrowserIsMaximized() {
        System.out.println("The browser is maximized");
    }

    // It is mandatory to use anonymous {} cucumber expression parameter to match with the values present in Examples
    @When("The user enters {} as username and {} as password")
    public void theUserEntersAdminAsUsernameAndManagerAsPassword(String uname, String pwd) {
        System.out.println("Entered username: " + uname);
        System.out.println("Entered password: " + pwd);
    }
}
