package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runners.Suite;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/Fitpeo_Regression.feature", glue="stepdefinitions", publish = false, monochrome = true,
plugin= {"pretty","html:target/reports/fitpeo_report.html","json:target/Reports/report.json","junit:target/Reports/report.xml"},
tags="@Calculate_Revenue")
public class TestRunner 
{

}
