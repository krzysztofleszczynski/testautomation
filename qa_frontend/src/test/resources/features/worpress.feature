Feature: Test of content AddToYourOrder page

Background:
#  Given User is on wordpress website "https://wordpress.com"
#  When User click to login button
#  Then Email login page is displayed

  @wordpress @login
  Scenario: Checking of CartSubtotal content

  Given User is on wordpress website "https://wordpress.com"
  When User click to login button
  Then Email login page is displayed
  When User enter email and click continue button
  Then Passord login page is displayed
  When User enters password and press LogIn button
  Then Main loged page is displayed
  When User press avatar
  Then Personal page is displayed
  When User clicks notyfication link
  Then Notyfication page is displayed
  When User press checkbox
  Then Checkbox is unselected