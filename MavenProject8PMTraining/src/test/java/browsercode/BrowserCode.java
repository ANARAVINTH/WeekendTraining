package browsercode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserCode {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\SeleniumFiles\\Drivers\\chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.get("https://login.salesforce.com/");

       driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[1]/div/input[1]")).sendKeys("Aravinth");
       driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");
       driver.findElement(By.xpath("//input[@id='Login']")).click();

      String expectedResult = "check your username and password. If you still can't log in, contact your Salesforce administrator.";
      String actualErrorMessage = driver.findElement(By.id("error")).getText();

        System.out.println("Error : " + actualErrorMessage);

        if(expectedResult.equals(actualErrorMessage)){

            System.out.println("both are equal");
        }
        else{
            System.out.println("not equal");
        }

    }


}
