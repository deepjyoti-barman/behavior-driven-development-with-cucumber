# Behaviour Driven Development with Cucumber

## Introduction

- BDD stands for Behaviour Driven Development.
- BDD is a part of Agile development process and came into existence in 2006.
- In BDD process everyone should be involved - Customer, BA, Management (Product/Market), Architect, Developer, QA, Deployment team etc. and everyone should speak same language.
- For the above reason while implementing BDD we write steps in simple english like 'Gherkin' language, so that everyone can be on the same page.
- Phased in BDD
  - Discovery (discussion)
  - Formulation (documentation using 'Gherkin')
  - Automation (computerization or software development process)
- BDD can be implemented with any of the tools like Selenium, Rest-Assured, Appium etc.
- We will be writing code in Selenium/Rest-Assured/Appium for performing necessary actions against all the steps in step-definition file.
- For execution, we will be using Test Runner (JUnit/TestNG) file. Test Runner will map feature file with step-definition file, and it is going to run it.
- Cucumber is a tool which helps us to implement BDD (other example - JBehave).
- 'cucumber-java' dependency is for writing a program, 'cucumber-junit' dependency is for writing the test runner.

## Gherkin language

### Basics of Gherkin language

- Gherkin uses a set of special keywords to give structure and meaning to executable specifications.
- Primary Keywords: Feature, Rule (as of Gherkin 6), Example (or Scenario), Given, When, Then, And, But for steps (or *), Background, Scenario Outline (or Scenario Template), Examples (or Scenarios).
- Secondary keywords: """ (Doc Strings), | (Data Tables), @ (Tags), # (Comments).
- `Given` is used for 'Pre-condition', `When` is used for 'Action', `Then` is used for 'Verification'.
- Example:
  ```gherkin
  # filename: login.feature
  Given Login page is displayed
  When The user enters id and password
  And He clicks on the login button
  Then The home page should be displayed
  ```
- For extensive elaboration on all the keywords of Gherkin with examples visit: [https://cucumber.io/docs/gherkin/](https://cucumber.io/docs/gherkin/)
- Single line comments are marked with #, multi-line comments are not available.
- Every feature file will have a header called `Feature` there we'll mention what is this feature all about.
- Inside every `Feature` the test-cases are written as `Scenario` i.e. each scenario is one test-case (e.g.valid login, invalid login etc.)
- Under `Scenario` we can have multiple, `Given`, `When`, `Then`, `And` statements.
- Cucumber supports data driven also with the help of `Examples` statement and for that we need to use another keyword called `Scenario Outline`.
- Either spaces or tabs may be used for indentation. The recommended indentation level is two spaces.
- You can not have duplicate steps written for same string mentioned in `Given`/`When`/`Then` etc. keywords. 
- If you have different applications having similar step then you need to come up with unique english sentences (e.g. Login page of app1 is displayed) or else you have to write some logic to check on which page you are currently in before performing the actions.
- We can use regular expressions in strings present inside `Given`/`When`/`Then` statements of step-definition file. It was mandatory till Cucumber version 5/6, but optional in Cucumber version 7.
- If we run the TestRunner class it will execute the entire program, which in-turn will take a lot of time. Hence, if you have an intention to cross-check if every step has a step-definition against it, you can use `dryRun = true` flag inside @CucumberOptions annotation.
- `monochrome =  true` is used to remove junk characters displayed in the console.
- If the step-definition is missing, cucumber by default provides the suggested method to implement, but method name will follow snake-case.
- `snippets = SnippetType.CAMELCASE` can be used to generate step-definition snippets having method names in camel-case.
- `plugin = {"pretty", "html:target/report.html"}` can be used to generate test-execution report in html format.
- Occasionally you’ll find yourself repeating the same Given steps in all the scenarios in a Feature. Since it is repeated in every scenario, this is an indication that those steps are not essential to describe the scenarios; they are incidental details. You can literally move such Given steps to the background, by grouping them under a Background section.
- A Background allows you to add some context to the scenarios that follow it. It can contain one or more Given steps, which are run before each scenario, but after any Before hooks.
- A Background is placed before the first Scenario/Example, at the same level of indentation.
- Background does same feature as `@Before` hook, only difference is Background is available in the feature file itself. Another limitation Background is it is only limited to a particular feature file.
- For more details on Cucumber expressions visit: [https://github.com/cucumber/cucumber-expressions](https://github.com/cucumber/cucumber-expressions)

### Cucumber Hooks

- If you want to write a piece of code a pre-condition or post-condition you can use Hooks with `@Before`, `@After` etc. annotations.
- It is called hooks because it gets attached to all the scenarios/steps automatically.
- If you have multiple hooks with same annotation name you can use `order` parameter to set an order of execution. Higher order means it will be executed first.
- Hooks are not the part of the scenario they are behind the scene feature.
- Advantage of hooks is you can have more/full control over the flow, and we can associate hook for a specific tag which is called conditional hooks. Disadvantage is it runs behind the scene and not gets printed in report, so we will not realise what is happening before and after the scenario when we look at the feature file.
- Caution Note for using Hooks: Think twice before you use hooks. Whatever happens in a `@Before` hook is invisible to people who only read the features. You should consider using a background as a more explicit alternative, especially if the setup should be readable by non-technical people. Only use a `@Before` hook for low-level logic such as starting a browser or deleting data from a database.
- Global hooks: Global hooks will run once before any scenario is run or after all scenario have been run. `@BeforeAll` run before any scenario is run. `@AfterAll` run after all scenarios have been executed. These methods should be declared as static, else we will get CompositeCucumberException. 
- Conditional hooks: Hooks can be conditionally selected for execution based on the tags of the scenario. To run a particular hook only for certain scenarios, you can associate a `@Before` or `@After` hook with a tag expression e.g. `@After("@browser and not @headless")`.
- Scenario hooks: Scenario hooks run for every scenario. `@Before` hooks run before the first step of each scenario. `@After` hooks run after the last step of each scenario, even when the step result is failed, undefined, pending, or skipped. The scenario parameter is optional in `@After` hook. If you use it, you can inspect the status of the scenario e.g. you can take a screenshot with WebDriver for failed scenarios and embed them in Cucumber’s report.
  ```java
  public class Hooks {
      @After
      public void afterScenario(Scenario scenario) {
          if (scenario.isFailed()) {
              byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
              scenario.attach(screenshot, "image/png", "name");
          }
      }
  }
  ```
- Execution order of hooks: `@BeforeAll` -> `@Before` -> `@BeforeStep` -> `@AfterStep` -> `@After` -> `AfterAll`. Tags can only be associated with `@Before` and `@After` for creating conditional hooks.
### Cucumber Tags

- Tags can be placed above the following Gherkin elements:
    - Feature
    - Scenario
    - Scenario Outline
    - Examples
- Multiple tags can be applied to above Gherkin elements.
- It is not possible to place tags above Background or steps (Given, When, Then, And and But).
- Tags are inherited by child elements. Tags that are placed above a Feature will be inherited by Scenario, Scenario Outline, or Examples. Tags that are placed above a Scenario Outline will be inherited by Examples.
- Running a subset of scenarios:
    - Using a JVM system property (JUnit 4 and TestNG):
      ```bash
      mvn test -Dcucumber.filter.tags="@smoke and @fast"
      ```
    - Using an environment variable. 
    - Changing your JUnit 4/TestNG runner class: 
      ```java
      @CucumberOptions(tags = "@smoke and @fast")
      public class RunCucumberTest {}
      ```
- A tag expression is an infix boolean expression. Below are some examples:

  | Expression         | Description                                                   |
  |--------------------|-------------------------------------------------------------- |
  | @fast              | Scenarios tagged with @fast                                   |
  | @wip and not @slow | Scenarios tagged with @wip that aren’t also tagged with @slow |
  | @smoke and @fast   | Scenarios tagged with both @smoke and @fast                   |
  | @gui or @database  | Scenarios tagged with either @gui or @database                |

### 