package definitions;

import cucumber.api.java.en.Given;

public class JavaStepDefs {
    @Given("I print {string} in console")
    public void iPrintInConsole(String arg0) {
        System.out.println(arg0);
        System.out.println("Good job everybody");
    }


    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println(str1+" "+str2);
        System.out.println(str1.toLowerCase());
        System.out.println(str2.toUpperCase());


    }
}
