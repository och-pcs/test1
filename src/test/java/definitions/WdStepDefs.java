package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

//import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;



public class WdStepDefs {
    @Given("I go to {string} and print details")
    public void iGoToAndPrintDetails(String page) {
        if (page.equals("google")){
            getDriver().get("https://www.google.com/");
        }else if (page.equals("Get a Quote")){
            getDriver().get("http://skryabin.com/webdriver/html/quote.html");
        }else {
            System.out.println("Unknown page " + getDriver().getCurrentUrl());
        }
        System.out.println(getDriver().getTitle());
        System.out.println();
        System.out.println(getDriver().getCurrentUrl());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().to("http://skryabin.com/webdriver/html/quote.html");
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @Given("I open {string} then {string} then {string}")
    public void iOpenThenThen(String url0, String url1, String url2) {
        String[] urls={url0,url1,url2};
        for (String url:urls){
            System.out.println(url);
            getDriver().get(url);
        }

    }

    @Given("I open {string} page")
    public void iOpenPage(String arg0) {
        getDriver().get("http://skryabin.com/webdriver/html/quote.html");
    }

    @When("I fill out first name {string} and last name {string}")
    public void iFillOutFirstNameAndLastName(String firstName, String lastName) {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @And("I fill out required fields")
    public void iFillOutRequiredFields() {
        WebElement userName =getDriver().findElement(By.xpath("//input[@name='username']"));
        String un="ab";
       // userName.isDisplayed();
        //userName.sendKeys("ab");
        userName.sendKeys(un);
        WebElement email=getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("abc@abc.com");
        WebElement password=getDriver().findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345");
        WebElement confirm=getDriver().findElement(By.xpath("//input[@id='confirmPassword']"));
        confirm.sendKeys("12345");
        WebElement agreed=getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']"));
        agreed.click();
        WebElement submit=getDriver().findElement(By.xpath("//button[@id='formSubmit']"));
        submit.click();
    }

    @Then("I assert required fields")
    public void iAssertRequiredFields() {
        WebElement resultPage=getDriver().findElement(By.xpath("//div[@id='quotePageResult']"));
        /*assertThat(resultPage.isDisplayed()).isTrue();
        String actualPrivacyPolicy=getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(actualPrivacyPolicy).isEqualToIgnoringCase("true");
        String resultText=getDriver().findElement(By.xpath("//div[@id='quotePageResult']//section")).getText();
        System.out.println(resultText);
        assertThat(resultText).containsIgnoringCase("Peter Orange");
        assertThat(resultText).containsIgnoringCase("abc@abc.com");
        assertThat(resultText).containsIgnoringCase("[entered]");
        assertThat(resultText).doesNotContain("12345");*/
        assertThat(resultPage.isDisplayed()).isTrue();
        String policyChecked=getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(policyChecked).isEqualToIgnoringCase("true");
        System.out.println(policyChecked);
        String actualDate=getDriver().findElement(By.xpath("//b[@name='currentDate']")).getText();
        assertThat(actualDate).isEqualTo("04/13/2020");
        System.out.println(actualDate);
        String username=getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        assertThat(username).isEqualToIgnoringCase("ab");
        System.out.println(username);
        String resultText=getDriver().findElement(By.xpath("//div[@id='quotePageResult']//section")).getText();
        System.out.println(resultText);

    }


    @Given("I open {string} pag")
    public void iOpenPag(String arg0) {
        getDriver().get("http://skryabin.com/webdriver/html/quote.html");
    }

    @When("I change resolution to {string}")
    public void iChangeResolutionTo(String layout) {
        Dimension size;
        switch (layout){
            case ("phone"):
                size=new Dimension(600,1000);
                break;
            case ("desktop"):
                size=new Dimension(1024,1000);
                break;
            default:
                throw new RuntimeException("not supported layout: "+layout);
        }
        getDriver().manage().window().setSize(size);
    }
}
