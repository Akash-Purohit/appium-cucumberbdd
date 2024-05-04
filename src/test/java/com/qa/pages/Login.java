package com.qa.pages;

import org.junit.Assert;

import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Login extends BasePage {
	TestUtils utils = new TestUtils();

	@AndroidFindBy(accessibility = "1")
	private MobileElement NUMBER_1;

	@AndroidFindBy(accessibility = "2")
	private MobileElement NUMBER_2;
	
	@AndroidFindBy(accessibility = "3")
	private MobileElement NUMBER_3;

	@AndroidFindBy(accessibility = "4")
	private MobileElement NUMBER_4;
	
	@AndroidFindBy(accessibility = "5")
	private MobileElement NUMBER_5;

	@AndroidFindBy(accessibility = "6")
	private MobileElement NUMBER_6;
	
	@AndroidFindBy(accessibility = "7")
	private MobileElement NUMBER_7;

	@AndroidFindBy(accessibility = "8")
	private MobileElement NUMBER_8;
	
	@AndroidFindBy(accessibility = "9")
	private MobileElement NUMBER_9;

	@AndroidFindBy(accessibility = "0")
	private MobileElement NUMBER_0;

	public Login() {
	}

	public Login enterPin() throws InterruptedException {
		click(NUMBER_9);
		click(NUMBER_2);
		click(NUMBER_1);
		click(NUMBER_3);
		click(NUMBER_5);
		
		return this;
	}
	
}
