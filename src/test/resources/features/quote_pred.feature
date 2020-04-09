@quote_pred 
  Feature: Predefined steps for Quote page
    @quote_pred1
    Scenario: Responsive UI
      Given I open url "http://skryabin.com/webdriver/html/quote.html"
      When I resize window to 1024 and 1000
      Then element with xpath "//b[@id='location']" should be displayed
      And element with xpath "//b[@id='currentDate']" should be displayed
      And element with xpath "//b[@id='currentTime']" should be displayed
      When I resize window to 800 and 1000
      Then element with xpath "//b[@id='location']" should be displayed
      And element with xpath "//b[@id='currentDate']" should be displayed
      And element with xpath "//b[@id='currentTime']" should be displayed
      When I resize window to 600 and 1000s
      Then element with xpath "//b[@id='location']" should not be displayed
      And element with xpath "//b[@id='currentDate']" should not be displayed
      And element with xpath "//b[@id='currentTime']" should not be displayed

      @quote_pred2
      Scenario: Veerify Name requirements
        Given I open url "http://skryabin.com/webdriver/html/quote.html"
        When I click on element with xpath "//input[@id='name']"
        Then element with xpath "<string>" should be displayed
