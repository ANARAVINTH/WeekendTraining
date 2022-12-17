package stepdefinationfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resuable.BrowserInvocation;
import resuable.SelectHelper;
import resuable.TextBoxHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SalaforceValidationSteps extends BrowserInvocation {

   private WebDriver driver;
   private WebElement toElement;
   private WebElement currencyDropdownElement;

   private TextBoxHelper textBoxHelper;

   private SelectHelper selectHelper;


@When("User Enters the username {string} and password {string}")
public void enterUserNamePassword(String userName, String password){

    textBoxHelper.enterTextValue(By.id("username"),"Aravinth");
    textBoxHelper.enterTextValue(By.xpath("//input[@id='password']"),"123");

}

@Given("User navigates to Salesforce Application")
    public void launchSalesforce() throws IOException {

    driver = BrowserInvocation.browserCode();
    textBoxHelper = TextBoxHelper.getInstance(driver);
}

@And("User clicks the login button")
public void clickLoginButton() {

    textBoxHelper.clickText(By.cssSelector(".button.r4.wide.primary"));

}

@Then("User validates the error message")
public void userValidatesTheErrorMessage() {

        String expectedResult = "check your username and password. If you still can't log in, contact your Salesforce administrator.";
        String actualErrorMessage = textBoxHelper.getTextValue(By.id("error"));

        Assert.assertEquals(expectedResult,actualErrorMessage,"Error message doesn't match");
    }

 @Then("User should naviagte to the homepage")
    public void userShouldNaviagteToTheHomepage() {

    }

 @When("User enter the below details")
    public void userEnterTheBelowDetails() {
    }

    @Given("User navigate to the required url")
    public void url() throws IOException {

        driver =    BrowserInvocation.browserCode();

       selectHelper = SelectHelper.getInstance(driver);

    }

    @When("User selects the required value from the dropdown")
    public void selectDropdownValue() {

        selectHelper.selectByValue(currencyDropdownElement,"KWD");

    }

    @When("User selects the required value from the dynamic dropdown")
    public void userSelectsTheRequiredValueFromTheDynamicDropdown() {

        driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@Value='MAA']")).click();
        toElement = driver.findElement(By.id("glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR"));
        toElement.findElement(By.xpath("//a[@Value='BLR']")).click();
    }

    @Then("iterate the dropdownvalues")
    public void iterateTheDropdownvalues() {

  // int curencyDropdownSize = currencyDropdownElement.findElements(By.tagName("option")).size();

//        for(int i=1;i<curencyDropdownSize;i++){
//
//           String value = currencyDropdownElement.findElements(By.tagName("option")).get(i).getText();
//            System.out.println(value);
//        }

List<WebElement> options = currencyDropdownElement.findElements(By.tagName("option"));

List<String> dropdownValues = new ArrayList<String>();

        for(WebElement e:options){
            dropdownValues.add(e.getText());
        }
        System.out.println(dropdownValues);

        for (String f:dropdownValues){

            if(f.equals("EUR")){

                Assert.assertEquals(f,"UR");
                break;
            }
        }
    }

    @When("User Handles the auto suggestive")
    public void userHandlesTheAutoSuggestive() throws InterruptedException {

    driver.findElement(By.name("flying_from_N")).click();
    WebElement from = driver.findElement(By.name("flying_from"));
    from.sendKeys("che");
    Thread.sleep(3000);
    int i=0;
    while(i<4){
        from.sendKeys(Keys.ARROW_DOWN);
        if(from.getText().equalsIgnoreCase("Russia")){
            from.sendKeys(Keys.ENTER);
        }
        i++;
    }

    }

    @When("switch inside the frame")
    public void switchInsideTheFrame() {

        WebElement frameElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frameElement);

        Actions frameAction = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable")) ;
        WebElement target = driver.findElement(By.id("droppable"));
        frameAction.dragAndDrop(source,target).build().perform();

        driver.switchTo().defaultContent();

        driver.findElement(By.partialLinkText("Draggable")).click();


    }

    @When("count the link")
    public void countTheLink() {

      int totalLinkSize =  driver.findElements(By.tagName("a")).size();
        System.out.println(totalLinkSize);

     WebElement footerElement = driver.findElement(By.id("footer-habitat"));
     int footerCount = footerElement.findElements(By.tagName("a")).size();
        System.out.println(footerCount);

     List<WebElement> product = footerElement.findElements(By.xpath("//div[@id='nav_menu-2']/ul/li/a"));

     System.out.println(product.size());

     for(WebElement e:product){

        String keyFunc = Keys.chord(Keys.CONTROL,Keys.ENTER);
        e.sendKeys(keyFunc);
     }

    Set<String> windowsProps = driver.getWindowHandles();

     for (String o:windowsProps){

         String title =driver.switchTo().window(o).getTitle();
         if(title.contains("Speed lab")){

             break;
         }
     }

     driver.switchTo().defaultContent();



    }
}
