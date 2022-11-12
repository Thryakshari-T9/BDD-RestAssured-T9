package com.test.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/test/features",
        glue = {"com/test/GlueCode"},
     //   tags = {"~@InvalidLogin"},
        		dryRun = false, 
        		monochrome = true,
        	plugin = {
					"pretty",
					"json:target/cucumber-reports/CucumberTestReport.json",
					"rerun:target/cucumber-reports/rerun.txt"
        })


public class TestRunner {

}
