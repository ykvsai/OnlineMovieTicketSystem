package com.capgemini.omts.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature/add.feature", glue = {"com.capgemini.omts.stepDefinition"})
public class AddTestRunner {

}
