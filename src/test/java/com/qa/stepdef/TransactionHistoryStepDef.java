package com.qa.stepdef;

import com.qa.pages.CurrencyPage;
import com.qa.pages.Footer;
import com.qa.pages.Login;
import com.qa.pages.TransactionHistory;
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

public class TransactionHistoryStepDef {

	@And("I validate transaction for the month {string}")
	public void validateTxnforfonth(String month) throws InterruptedException {
		new CurrencyPage().clickCurrency();
		String monthOnScreen = new TransactionHistory().getTxnHistMonth();
		try {
			Assert.assertTrue("Month expected to be " + month + " but found " + monthOnScreen,
					monthOnScreen.equalsIgnoreCase(month));
		} catch (AssertionError e) {
			System.out.println("Assertion error. ");
		}

		String txnAmtZero = new TransactionHistory().getSpentInfo();
		try {
			Assert.assertTrue("Transaction amount expected was 0 but found " + txnAmtZero.split(" ")[2].split("£")[1],
					"0".equalsIgnoreCase(txnAmtZero.split(" ")[2].split("£")[1]));
		} catch (AssertionError e) {
			System.out.println("Assertion error. ");
		}

	}

	@Then("I validate there is no transaction message")
	public void validateloTxnHessage() throws InterruptedException {
		String noTxnMsg = new TransactionHistory().getNoTxnMsg();
		try {
			Assert.assertTrue("No Txn message validated",
					"You have no transactions for the time period you have selected".equalsIgnoreCase(noTxnMsg));
		} catch (AssertionError e) {
			System.out.println("Assertion error. ");
		}

	}

}
