package com.capgemini.omts.runner;

import org.junit.runner.RunWith;

import com.capgemini.omts.util.TheatreConstants;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature/delete.feature", glue = {TheatreConstants.GLUE})
public class DeleteTestRunner {

}
