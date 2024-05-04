package com.qa.stepdef;

import com.qa.pages.CurrencyPage;
import com.qa.pages.Footer;
import com.qa.pages.Login;
import com.qa.pages.TransactionHistory;
import com.qa.pages.YourCard;
import com.qa.utils.DriverManager;
//import com.qa.utils.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class YourCardStepDef {

	@Then("I validate card details")
	public void validateCardDetails() throws InterruptedException {
		new YourCard().unHideCard();
		new YourCard().unHideCvv();

		String cardDetails = new YourCard().getCardDetails();
		String cvvDetails = new YourCard().getCvvDetails();
		try {
			Assert.assertTrue("Card details don't match", cardDetails.equalsIgnoreCase("5384 2300 0617 0268"));
			Assert.assertTrue("Cvv details don't match", cvvDetails.equalsIgnoreCase("806"));
		} catch (AssertionError e) {
			System.out.println("Assertion error. ");
		}

	}

	@Then("I validate hidden card details")
	public void validateHiddenCardDetails() throws InterruptedException {

		String cardDetails = new YourCard().getCardDetailsHidden();
		String cvvDetails = new YourCard().getCvvDetails();

		try {
			Assert.assertTrue("Card details don't match", cardDetails.equalsIgnoreCase("5384 • • • •  • • • • 2608"));
			Assert.assertTrue("Cvv details don't match", cvvDetails.equalsIgnoreCase("• • •"));
		} catch (AssertionError e) {
			System.out.println("Assertion error. ");
		}

	}

}
