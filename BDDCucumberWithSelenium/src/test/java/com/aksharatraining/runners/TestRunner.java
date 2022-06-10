package com.aksharatraining.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = "src/test/java/com/aksharatraining/features",
        features = "src/test/java",
        glue = "com.aksharatraining.stepdefinitions",
        monochrome = true,
        tags = "@data-table-example",
//        dryRun = true,
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/report.html"}
)
public class TestRunner {

}
