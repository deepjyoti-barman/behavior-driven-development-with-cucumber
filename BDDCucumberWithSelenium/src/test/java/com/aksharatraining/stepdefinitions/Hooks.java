package com.aksharatraining.stepdefinitions;


import io.cucumber.java.*;

public class Hooks {

    @Before
    public void beforeScenario1() {
        System.out.println("Scenario Start");
    }

    @Before("@positive")
    public void beforeScenario2() {
        System.out.println("--------------------");
    }

    @After(order = 2)
    public void afterScenario1() {
        System.out.println("Scenario End");
    }

    @After(order = 1)
    public void afterScenario2() {
        System.out.println("====================");
    }

    @BeforeAll
    public static void beforeAllScenario() {
        System.out.println("WELCOME");
    }

    @AfterAll
    public static void afterAllScenario() {
        System.out.println("THE END");
    }

    @BeforeStep
    public void beforeEveryStep() {
        System.out.println("*********************");
    }

    @AfterStep
    public void afterEveryStep() {
        System.out.println("+++++++++++++++++++++");
    }
}
