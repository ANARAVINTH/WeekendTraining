package stepdefinationfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import resuable.BrowserInvocation;
import resuable.SelectHelper;
import resuable.TextBoxHelper;

import java.io.IOException;
import java.util.List;

public class NewSteps extends BrowserInvocation {

    private WebDriver driver;
    private TextBoxHelper textbox;
    private SelectHelper selectHelper;

    @Given("launch URL")
    public void launch() throws IOException {
       driver= BrowserInvocation.browserCode();
       textbox = TextBoxHelper.getInstance(driver);

    }
    @When("Pass Credit")
    public void passCredit() {

        textbox.enterTextValue(By.cssSelector(".input.r4.wide.mb16.mt8.username"),"LearnMore");
        textbox.enterTextValue(By.xpath("//input[@id='password']"),"123");

    }

    @And("click the button")
    public void clickTheButton() {
        textbox.clickText(By.id("Login"));
    }


    @Then("Validate error")
    public void validateError() {

        String expectedResult = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        String acutalResult = textbox.getTextValue(By.id("error"));

        double a = 12.33;
        double b = 33.55;
        Assert.assertEquals(expectedResult, acutalResult);
        Assert.assertEquals(a, b);
    }


    @Then("Validate the enable conditon of return date")
    public void validateTheEnableConditonOfReturnDate() {

       Boolean opacityValue = driver.findElement(By.xpath("//div[@id='marketDate_2']")).isEnabled();
        Assert.assertTrue(opacityValue);
    }

    @Then("perform alert action")
    public void performAlertAction() {

        driver.findElement(By.id("alertButton")).click();
       String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);

    }

    @Then("Select the date {string} and Month {string}")
    public void handleCalander(String userProvidedDate,String userProvidedMonth) {

        driver.findElement(By.className("ui-datepicker-trigger")).click();
  //      driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active.ui-state-hover")).click();


//       int size = firstMonth.findElements(By.className("ui-state-default")).size();
//
//        for(int i=0;i<size;i++){
//          String datefFromUI =  firstMonth.findElements(By.className("ui-state-default")).get(i).getText();
//
//            if(datefFromUI.equals(userProvidedDate)){
//
//                firstMonth.findElements(By.className("ui-state-default")).get(i).click();
//                break;
//            }
//
//        }



       while (!driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div")).getText().contains(userProvidedMonth)){
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
       }

        WebElement firstMonth =  driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']"));
        List<WebElement> enabledDates= firstMonth.findElements(By.className("ui-state-default"));
        for(WebElement t:enabledDates){
            String uiDates= t.getText();
            if(uiDates.equals(userProvidedDate)){
                t.click();
                break;
            }
        }

    }

    @Then("Handle Stale Element Exceptions")
    public void handleStaleElementExceptions() {

        WebElement username;
        WebElement password;
        username= driver.findElement(By.id("username"));
        password = driver.findElement(By.id("password"));
        username.sendKeys("Aravinth");
        password.sendKeys("123");
        driver.navigate().refresh();
        try{
        username.sendKeys("learnmore");
        password.sendKeys("1234");
        }
        catch (StaleElementReferenceException e){
            username = driver.findElement(By.id("username"));
            password = driver.findElement(By.id("password"));
            username.sendKeys("learnmore");
            password.sendKeys("1234");

        }
        catch(Exception f){

                f.printStackTrace();
        }




    }

    @Then("Hello code")
    public void helloCode() {


    }
}
