@quote
  Feature: Predefined Quote form
    @quote1
    Scenario: Responsive ui
      Given I open url "http://skryabin.com/webdriver/html/quote.html"
      #Desktop ui
      When I resize window to 1024 and 1000
      Then element with xpath "//*[@id='location']" should be displayed
      And element with xpath "//b[@id='currentDate']" should be displayed
      And element with xpath "//b[@id='currentTime']" should be displayed
      #Tablet ui
      When I resize window to 800 and 1000
      Then element with xpath "//*[@id='location']" should be displayed
      And element with xpath "//b[@id='currentDate']" should be displayed
      And element with xpath "//b[@id='currentTime']" should be displayed
      #Mobile UI
      When I resize window to 600 and 1000
      Then element with xpath "//*[@id='location']" should not be displayed
      And element with xpath "//*[@id='currentDate']" should not be displayed
      And element with xpath "//*[@id='currentTime']" should not be displayed
    # This is a comment in Cucumber
  
    @quote2
    Scenario: Validate Name field
      Given I open url "http://skryabin.com/webdriver/html/quote.html"
      When I click on element using JavaScript with xpath "//input[@id='name']"
      Then element with xpath "//*[@aria-describedby='nameDialog']" should be displayed
      When I type "Peter" into element with xpath "//input[@id='firstName']"
      And I type "Orange" into element with xpath "//input[@id='lastName']"
      And I click on element using JavaScript with xpath "//span[contains(text(),'Save')]"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "Peter Orange"
    @quote3
    Scenario: Validate Username field
      Given I open url "http://skryabin.com/webdriver/html/quote.html"
      When I type "a" into element with xpath "//*[@name='username']"
      And I click on element with xpath "//input[@name='email']"
    #  And I click on element using JavaScript with xpath "//input[@name='email']"
    #  And  I wait for 3 sec
      Then element with xpath "//label[@id='username-error']" should contain text "2 characters"
    #  Then element with xpath "//label[@id='username-error']" should have text as "Please enter at least 2 characters."

