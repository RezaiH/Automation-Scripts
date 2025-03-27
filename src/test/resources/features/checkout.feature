Feature: Test the Checkout functionality of the application

	Scenario: Verify user can login with valid credentials
		Given User is on the Login page
		When User enters username "habibi1"
		And User enters password "habibi"
		And User clicks on Login button
		
		Scenario Template: Verify users can login with different credentials
		  When User enters the username <username>
			Given User enters the password <password>
			And User clicks on Login button
			
			Scenario: Test
			Given user is on the website homepage
			When user enters username 'Hussain'
			And user enters password 'habibi'
			And user clicks on Login button
			Then user is navigated to the Account page
			