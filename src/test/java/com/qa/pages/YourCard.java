package com.qa.pages;

import org.junit.Assert;

import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class YourCard extends BasePage {
	TestUtils utils = new TestUtils();

	@AndroidFindBy(accessibility = "eye-icon-card-number-image")
	private MobileElement HIDE_CARD;

	@AndroidFindBy(accessibility = "eye-icon-card-cvc")
	private MobileElement HIDE_CVV;

	@AndroidFindBy(accessibility = "card-number-first-four-digits-5384")
	private MobileElement CARD_FIRST_FOUR;

	@AndroidFindBy(accessibility = "second-four-digits-2300")
	private MobileElement CARD_SECOND_FOUR;

	@AndroidFindBy(accessibility = "third-four-digits-0617")
	private MobileElement CARD_THIRD_FOUR;

	@AndroidFindBy(accessibility = "card-number-last-four-digits-0268")
	private MobileElement CARD_LAST_FOUR;

	@AndroidFindBy(accessibility = "profile-expiry-date")
	private MobileElement CARD_EXPIRY;

	@AndroidFindBy(accessibility = "reveal-cvc")
	private MobileElement CARD_CVV;

	@AndroidFindBy(accessibility = "card-number-five-to-thirteen-digits-hidden")
	private MobileElement CARD_HIDDEN;

	public YourCard() {
	}

	public YourCard unHideCard() throws InterruptedException {
		waitForVisibility(HIDE_CARD);
		click(HIDE_CARD, "Unhiding card details");
		return new YourCard();
	}

	public YourCard unHideCvv() throws InterruptedException {
		waitForVisibility(HIDE_CVV);
		click(HIDE_CVV, "Unhiding cvv");
		return new YourCard();
	}

	public String getCardDetails() throws InterruptedException {
		waitForVisibility(CARD_SECOND_FOUR);

		String first = getText(CARD_FIRST_FOUR, "Card first four digits (unhidden)");
		String second = getText(CARD_SECOND_FOUR, "Card second four digits (unhidden)");
		String third = getText(CARD_THIRD_FOUR, "Card third four digits (unhidden)");
		String last = getText(CARD_LAST_FOUR, "Card last four digits (unhidden)");

		return first + second + third + last;
	}

	public String getCvvDetails() throws InterruptedException {
		waitForVisibility(CARD_CVV);
		return getText(CARD_CVV, "Card cvv details");
	}

	public String getCardDetailsHidden() throws InterruptedException {
		
		waitForVisibility(CARD_SECOND_FOUR);

		String first = getText(CARD_FIRST_FOUR, "Card first four digits ");
		String hidden = getText(CARD_HIDDEN, "Card hidden");
		String last = getText(CARD_LAST_FOUR, "Card last four digits ");

		return first + hidden + last;
 
	}
}
