package com.qa.stepdef;

import com.qa.pages.CurrencyPage;
import com.qa.pages.Footer;
import com.qa.utils.DriverManager;
//import com.qa.utils.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class CurrencyStepDef {

	@Then("I navigate to {string} page")
	public void navigateToPage(String page) throws InterruptedException {
		new Footer().goToPage(page);
	}

}
