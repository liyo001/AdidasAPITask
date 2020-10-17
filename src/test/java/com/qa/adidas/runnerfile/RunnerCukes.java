package com.qa.adidas.runnerfile;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, strict = false,
        features = "src/test/resources/features/",
        glue = { "com.qa.adidas.stepdefinitions" }, tags = { "@petstore" },
        plugin = { "html:target/cucumber", "json:target/cucumber.json",
                "junit:target/cucumber.xml" })

public class RunnerCukes {
}