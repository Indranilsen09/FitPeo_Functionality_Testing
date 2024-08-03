package stepdefinitions;

import globalVariables.GlobalVariables;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks 
{
	static WebDriver driver ;

	Scenario scenario;
	@Before
	public void before(Scenario scenario){
		this.scenario = scenario;
		GlobalVariables.scenarioname = scenario.getName();

		//Selenium manager
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		this.driver = driver;
	}

	public static WebDriver getDriver()
	{
		return driver;
	}
	@After
	public void after(Scenario scenario)
	{

	}

	@AfterStep
	public void afterSteps(Scenario scenario) throws IOException {

		this.driver = getDriver();
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("target/screenshots/"+scenario.getName()+"_"+GlobalVariables.sscount+".png");
		GlobalVariables.sscount++;
		FileUtils.copyFile(scrFile,destFile);

	}


}
