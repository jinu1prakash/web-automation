package com.org.src.mock.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/featurefile",glue = "com/org/src/mock/testSteppack",tags = "@myntratestcases",plugin = {
        "pretty",
        "json:build/cucumber-report/cucumber.json",
        "html:build/cucumber-report/cucumber.html",
        "junit:build/cucumber-report/cucumber.xml"})
public class TestRunner {
}
