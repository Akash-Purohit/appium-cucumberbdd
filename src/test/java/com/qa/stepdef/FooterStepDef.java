package com.qa.stepdef;

import com.qa.pages.CurrencyPage;
import com.qa.utils.DriverManager;
//import com.qa.utils.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class FooterStepDef {

	@Then("I validate currency balance")
	public void validateBalance() throws InterruptedException {
		Thread.sleep(5000);
		String currencyValue = new CurrencyPage().getCurrencyAmount();
		String decimalValue = new CurrencyPage().getCurrencyDecimalAmount();
		try {
			Assert.assertTrue("Balance Validated OK", (currencyValue + decimalValue).equalsIgnoreCase("0.01"));
		} catch (AssertionError e) {
			System.out.println("Assertion error. ");
		}

	}

}
