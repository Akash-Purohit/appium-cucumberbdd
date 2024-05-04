@TestFeature 
Feature: Workflow of the synthetic monitoring cashpassport android application

	@test
	Scenario: Login, balance enquiry, txn history and card details validation
		Given I enter pin
		And I wait for 3 seconds
		Then I validate currency balance
		And I validate transaction for the month "June"
		Then I validate there is no transaction message
		Then I navigate back
		Then I navigate to "Your Card" page
		Then I validate card details
		Then I wait for 6 seconds
		Then I validate hidden card details