Feature: Verify if user can add items to Cart

	@addItem    @smoke
	Scenario: Verify if user can add Sony VAIO to the Cart
		Given User is on the website homepage
		And User clicks on Desktops tab and click on show Alldesktops
		Then User should be navigated to the Desktops page "Desktops"
		When User clicks on "Sony VAIO" item
		Then User should be navigated to the Sony VAIO page
		When User enters the quantity as 12
		And User clicks on Add to Cart button
		Then User gets the message "Success: You have added Sony VAIO to your shopping cart!"