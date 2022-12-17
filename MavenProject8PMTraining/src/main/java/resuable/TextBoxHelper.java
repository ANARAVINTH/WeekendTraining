package resuable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxHelper {

   private static WebDriver webDriver; // null
    private static TextBoxHelper textBoxHelper;

   private TextBoxHelper(WebDriver driver){

       webDriver = driver;
   }
   public static TextBoxHelper getInstance(WebDriver driver){

           textBoxHelper = new TextBoxHelper(driver);

       return textBoxHelper;

   }

    public void enterTextValue(By locater,String textValue){

        webDriver.findElement(locater).sendKeys(textValue);
    }

    public String getTextValue(By locater){

      String textValue =  webDriver.findElement(locater).getText();
      return textValue;
    }

    public void clearTextValue(By locater){
        webDriver.findElement(locater).clear();

    }

    public void clickText(By locater){
       webDriver.findElement(locater).click();
    }
}
