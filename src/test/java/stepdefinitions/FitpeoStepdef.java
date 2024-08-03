package stepdefinitions;

import helpers.ReadProperties;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import page.FitpeoPage;

import java.time.Duration;

public class FitpeoStepdef 
{
	private WebDriver driver=null;
	static FitpeoPage user = new FitpeoPage();

	static String url =null;

	@Given("User navigate to Fitpeo landing page")
	public void user_navigate_to_fitpeo_landing_page() throws InterruptedException
	{
			this.driver = Hooks.getDriver();
			url = ReadProperties.getProperty("HomeURL");
			driver.navigate().to(url);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			String title = driver.getTitle();
			Assert.assertEquals(title,"Remote Patient Monitoring (RPM) - fitpeo.com");

	}

	@When("User navigate to {string} Page")
	public void user_navigate_to_revenue_calculator_page(String pagename)
	{
		user.navigateTo(pagename);
	}

	@When("Scroll Down to the slider section")
	public void scroll_down_to_the_slider_section() {
	    user.moveToSlider();
	}

	@When("User set the slider {string}")
	public void user_set_the_slider(String string) {
	    user.SetTheSlider(string);
	}

	@Then("Set the patient number to {string}")
	public void set_the_patient_number_to(String patientCount) {
	   user.setThePatient(patientCount);
	}

	@Then("User choose CPT codes{string}, {string}, {string} and {string}")
	public void user_choose_cpt_codes(String code1, String code2, String code3, String code4) {
	   user.selectCodes(code1,code2,code3,code4);
	}

	@Then("User validate Total Recurring reimbursement {string}")
	public void user_validate_total_recurring_reimbursement(String string)
	{
		user.validateReimbursement(string);
	    
	}


}
