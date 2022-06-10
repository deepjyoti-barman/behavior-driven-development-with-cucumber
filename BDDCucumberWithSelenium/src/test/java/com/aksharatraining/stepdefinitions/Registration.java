package com.aksharatraining.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Registration {

    @Given("The Registration page is displayed")
    public void theRegistrationPageIsDisplayed() {
        System.out.println("The Registration page is displayed");
    }

    @When("The user enters the following details")
    public void theUserEntersTheFollowingDetails(DataTable dataTable) {
        // Algorithm 1 (List<List<String>>)
        List<List<String>> userData = dataTable.asLists(String.class);
//        userData.remove(0);         // CTE: throws java.lang.UnsupportedOperationException

        for (int i = 1; i < userData.size(); i++) {
            System.out.println("First name: " + userData.get(i).get(0));
            System.out.println("Last name: " + userData.get(i).get(1));
            System.out.println("Phone no: " + userData.get(i).get(2));
        }

        System.out.println("#####################");

        // Algorithm 2 (List<List<String>>)
        // Arrays.asList: Returns a fixed-size list backed by the specified array.
        // You can't add to it; you can't remove from it. You can't structurally modify the List.
        // Solution: Create a LinkedList, which supports faster remove.
        List<List<String>> userInfo = new LinkedList<>(dataTable.asLists());
        userInfo.remove(0);

        for (List<String> rowData : userInfo) {
            System.out.println("First name: " + rowData.get(0));
            System.out.println("Last name: " + rowData.get(1));
            System.out.println("Phone no: " + rowData.get(2));
        }

        System.out.println("#####################");

        // Algorithm 3 (List<Map<String, String>>)
        List<Map<String, String>> userMap = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> userEntry : userMap) {
            System.out.println("First name: " + userEntry.get("firstname"));
            System.out.println("Last name: " + userEntry.get("lastname"));
            System.out.println("Phone no: " + userEntry.get("phoneno"));
        }
    }

    @When("The user enters the following information")
    public void theUserEntersTheFollowingInformation(DataTable dataTable) {
        // Algorithm 4 (List<String>)
        List<String> userDetails = dataTable.asList();

        System.out.println("First name: " + userDetails.get(0));
        System.out.println("Last name: " + userDetails.get(1));
        System.out.println("Phone no: " + userDetails.get(2));
    }

    @When("The user fills in the fields with necessary data")
    public void theUserFillsInTheFieldsWithNecessaryData(DataTable dataTable) {
        Map<String, String> userMap = dataTable.asMap();

        System.out.println("First name: " + userMap.get("firstname"));
        System.out.println("Last name: " + userMap.get("lastname"));
        System.out.println("Phone no: " + userMap.get("phoneno"));
    }

    @When("The user enters his bio as the following")
    public void theUserEntersHisBioAsTheFollowing(String docString) {
        System.out.println(docString);
    }

    @When("The user clicks on the submit button")
    public void theUserClicksOnTheSubmitButton() {
        System.out.println("The user clicks on the submit button");
    }
    @Then("Registration success page should be displayed")
    public void registrationSuccessPageShouldBeDisplayed() {
        System.out.println("Registration success page should be displayed");
    }
}
