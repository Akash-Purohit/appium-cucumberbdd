package com.qa.pages;

import org.junit.Assert;

import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CurrencyPage extends BasePage {
	TestUtils utils = new TestUtils();

	@AndroidFindBy(accessibility = "currency-GBP-amount")
	private MobileElement CURRENCY_AMT;

	@AndroidFindBy(accessibility = "currency-GBP-amount-decimal")
	private MobileElement CURRENCY_DEC;

	@AndroidFindBy(accessibility = "purse-row-front-caret-container-GBP")
	private MobileElement CURRENCY_CLICK;

	public CurrencyPage() {
	}

	public String getCurrencyAmount() throws InterruptedException {
		waitForVisibility(CURRENCY_AMT); 
		return getText(CURRENCY_AMT, "Currency Value:");
	}

	public String getCurrencyDecimalAmount() throws InterruptedException {
		waitForVisibility(CURRENCY_DEC); 
		return getText(CURRENCY_DEC, "Currency Value:");
	}
	
	public CurrencyPage clickCurrency() {
		click(CURRENCY_CLICK, "Redirceting to Txn history page");
		return new CurrencyPage();
	}
	
}
