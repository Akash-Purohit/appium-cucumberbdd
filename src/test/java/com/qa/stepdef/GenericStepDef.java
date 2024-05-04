package com.qa.stepdef;

import com.qa.pages.CurrencyPage;
import com.qa.pages.Footer;
import com.qa.utils.DriverManager;
//import com.qa.utils.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class GenericStepDef {

	@Then("I wait for {int} seconds")
	public void waitForTime(Integer seconds) throws InterruptedException {
		Thread.sleep(seconds);
	}
	
	@Then("I navigate back")
	public void navigateBack() {
		new DriverManager().getDriver().navigate().back();
	}

}
