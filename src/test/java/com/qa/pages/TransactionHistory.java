package com.qa.pages;

import org.junit.Assert;

import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TransactionHistory extends BasePage {
	TestUtils utils = new TestUtils();

	@AndroidFindBy (accessibility = "transacton-history-list-header-text") 
	private MobileElement TXN_HIST_ZERO_TXT; 
	
	@AndroidFindBy(accessibility  = "filter-range-title") 
	private MobileElement TXN_HIST_MNTH; 

	@AndroidFindBy(accessibility = "empty-list-message") 
	private MobileElement EMPTY_TXN_HIST_MSG; 
	
	@AndroidFindBy(accessibility = "header-left-button")
	private MobileElement BACK_BTN; 
			
	public TransactionHistory() {
	}

	public String getTxnHistMonth() throws InterruptedException {
		waitForVisibility(TXN_HIST_MNTH); 
		return getText(TXN_HIST_MNTH, "Transaction history month");	
	}
	 
	public String getSpentInfo() throws InterruptedException {
		waitForVisibility(TXN_HIST_ZERO_TXT);
		return getText(TXN_HIST_ZERO_TXT, "Amount spent info:");
	}
	
	public String getNoTxnMsg() throws InterruptedException {
		waitForVisibility(EMPTY_TXN_HIST_MSG); 
		return getText(EMPTY_TXN_HIST_MSG, "No transaction message:");		
	}
	 
}
