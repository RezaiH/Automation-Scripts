@all
Feature: Verify the login functionality of the website

  @createAccount   @smoke # done
  Scenario: Verify user can create an account on the website
    Given User is on the website homepage
    When User clicks on My Account tab
    And User clicks on Register option
    Then User is navigated to the Register Account page
    When User enters first name "AseelaJan" in the first name input field
    And User enters last name "Musakhail" in the last name input field
    And User enters email "aseela1@gmail.com" in the email input field
    And User enters telephone number 2021111111 in the telephone input field
    And User enters the password "aseela1" in the password input field
    And User re-enters the password "aseela1" in the confirm password input field
    And User clicks on Subscribe Yes button
    And User checks the Privacy Policy checkbox
    And User clicks on Continue button
    Then User is navigated to the Your Account Has Been Created page
	  
	@createNewAccout   @smoke
	Scenario: Verify user can create an account on the website
    Given User is on the website homepage
    When User clicks on My Account tab
    And User clicks on Register option
    Then User is navigated to the Register Account page
    And User fills the inputs with below information
    |firstName|lastName|emailAddress|telephoneNumber|password|confPassword|
    |Zohra|Habibi|zohra3@gmail.com|7773334444|zohra1|zohra1|
    
    
  @validLogin			@smoke  # done
  Scenario: Verify user can log in into the application with valid credentials
    Given User is on the website homepage
    When User clicks on My Account tab
    And User clicks on Login option
    Then User is navigated to the Account Login page
    When User enters the email "aseelaJan@gmail.com" in the email input field
    And User enters the password "aseela1" in the password input field
    And User clicks on the Login button
    Then User is navigated to the My Account page

  @invalidPassword  @smoke  #done
  Scenario: Verify user cannot log in into the application with invlaid password
    Given User is on the website homepage
    When User clicks on My Account tab
    And User clicks on Login option
    Then User is navigated to the Account Login page
    When User enters the email "aseela@gmail.com" in the email input field
    And User enters the password "xyz" in the password input field
    And User clicks on the Login button
    Then User gets an error message "Warning: No match for E-Mail Address and/or Password."

  @updateEmailAddress  @smoke #done
  Scenario: Verify user can update the created account
    Given User is logged in into the application
    When User clicks on Edit your account information link
    Then User is navigated to the My Account Information page
    And User update the last name as "Donal J Trump"
    And User clicks on Continue button
    Then User gets the success message "Success: Your account has been successfully updated."

	@createMultipleAccounts  @smoke  # done
  Scenario Outline: Verify user can create accounts on the website
    Given User is on the website homepage
    When User clicks on My Account tab
    And User clicks on Register option
    Then User is navigated to the Register Account page
    When User enters first name <firstName> in the first name input field
    And User enters last name <lastName> in the last name input field
    And User enters email <email> in the email input field
    And User enters telephone number <telephoneNumber> in the telephone input field
    And User enters the password <password> in the password input field
    And User re-enters the password <confirmPassword> in the confirm password input field
    And User clicks on Subscribe Yes button
    And User checks the Privacy Policy checkbox
    And User clicks on Continue button
    Then User is navigated to the Your Account Has Been Created page

    Examples: 
      | firstName     | lastName    | email                    | telephoneNumber | password      | confirmPassword |
      | "Mudaser"     | "Musakhail" | "mudaser2@gmail.com"      |      2021111111 | "mudaser1"    | "mudaser1"      |
      | "Naweed"      | "Musakhail" | "naweed2@gmail.com"       |      2022222222 | "naweed1"     | "naweed1"       |
      | "Nazeer"      | "Musakhail" | "nazeer2@hotmail.com"     |      2023333333 | "nazeer1"     | "nazeer1"       |
      | "Mahdi"       | "Hussaini"  | "mahdi2@outlook.com"      |      2024444444 | "mahdi1"      | "mahdi1"        |
      | "Ali Hussain" | "Hussaini"  | "aliHussain2@hotmail.com" |      2025555555 | "aliHussain1" | "aliHussain1"   |
      | "Ahmad"       | "Hussain"   | "ahmad2@yahoo.com"        |      2026666666 | "ahmad1"      | "ahmad1"        |
      
      
   @userMultipleLogins  @smoke   # done
   Scenario Outline: Verify multiple users can login into the application 
   Given User is on the website homepage
   When User clicks on My Account tab
   And User clicks on Login option 
   Then User is navigated to the Account Login page
   When User enters email <email address> in the email input field
   And User enters password <password> in the password input field
   And User clicks on the Login button
   Then User is navigated to the My Account page
   Examples:
   |email address|password|
   |"mudaser2@gmail.com"							|"mudaser1"	   		|
   |"naweed2@gmail.com"							  |"naweed1"				|
   |"nazeer2@hotmail.com"						  |"nazeer1"				|
   |"mahdi2@outlook.com"							|"mahdi1"					|
   |"aliHussain2@hotmail.com"			    |"aliHussain1"		|
   |"ahmad2@yahoo.com"								|"ahmad1"					|
   
   
   @logout  @smoke
   Scenario Outline: Verify user can logout from the application successfully 
   Given User is on the website homepage
   When User clicks on My Account tab
   And User clicks on Login option 
   Then User is navigated to the Account Login page
   And User enters email "habibi1@gmail.com" in the email input field
   And User enters password "habibi" in the password input field
   And User clicks on the Login button
   When User clicks on Logout link
   Then User is successfully logedout
   And User clicks on Continue button
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
