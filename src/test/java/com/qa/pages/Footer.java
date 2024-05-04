package com.qa.pages;

import org.junit.Assert;

import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Footer extends BasePage {
	TestUtils utils = new TestUtils();

	@AndroidFindBy(accessibility = "footer-button-my-card-scene")
	private MobileElement MY_CARD;

	@AndroidFindBy(accessibility = "footer-text-top-up")
	private MobileElement ADD_MONEY;

	@AndroidFindBy(accessibility = "footer-button-move-money")
	private MobileElement MOVE_MONEY;

	@AndroidFindBy(accessibility = " footer-button-my-account")
	private MobileElement CURRENCY;

	@AndroidFindBy(accessibility = "footer-button-support")
	private MobileElement SUPPORT;

	public Footer() {
	}

	public Footer goToPage(String page) throws InterruptedException {
		switch (page) {
		case "Currencies":
			click(CURRENCY);
			break;
		case "Move Money":
			click(MOVE_MONEY);
			break;
		case "Add Money":
			click(ADD_MONEY);
			break;
		case "Your Card":
			click(MY_CARD);
			break;
		case "Support":
			click(SUPPORT);
			break;
		default:
			break;
		}
		return new Footer();
	}
}
