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
        String firstName="Olga";
        String lastName="Olgalastname";
        String favColor="yellow";
        System.out.println(firstName + " " + lastName + " likes "+ favColor);
        System.out.println(lastName.length());
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1==str2);


  }

    @Given("I run operators with {int} and {int}")
    public void iRunOperatorsWithAnd(int num1, int num2) {
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num1==num2);
        if (num1<num2){
            System.out.println("First number less than Second");
        }else{
            System.out.println("First number greater than Second");
        }
    }

    @Given("I print url for {string} page")
    public void iPrintUrlForPage(String site) {
        if (site.equalsIgnoreCase("google")){
            System.out.println("https://www.google.com/");
        }else if (site.equalsIgnoreCase("Get a Quote")){
            System.out.println("http://skryabin.com/webdriver/html/quote.html");
        }else {
            System.out.println("Unknown site");
        }
    }

    @Given("I print arrays")
    public void iPrintArrays() {
        String[] groceryList={"milk","apple","sugar","cake","salt","tea"};
        System.out.println(groceryList);//wouldn't print any values;need to use index
        System.out.println(groceryList[0]);
        System.out.println(groceryList[1]);
        for (int i=0;i<groceryList.length;i++){
            System.out.println(groceryList[i]);
        }
        for (String element:groceryList){
            System.out.println(element);
        }
    }
}
