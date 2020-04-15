@wd
  Feature: WebDriver methods
    @wd1
    Scenario: Open the page
      Given I go to "google" and print details
      And I go back and forward, then refresh the page
    @wd2
    Scenario: Loop through urls
      Given I open "https://www.google.com/" then "http://skryabin.com/webdriver/html/quote.html" then "https://www.amazon.com/"
    @wd3
    Scenario: Quote with required fields
      Given I open "quote" page
      When I fill out first name "Peter" and last name "Orange"
      And I fill out required fields
      Then I assert required fields
    @wd4
    Scenario: Responsive UI
      Given I open "quote" page
      When I change resolution to "phone"