package resuable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserInvocation {

    private static WebDriver driver;
    protected static WebDriver browserCode() throws IOException {

        FileInputStream fis = new FileInputStream(new File("D:\\Selenium\\WeekendTraing8PM\\MavenProject8PMTraining\\src\\main\\resources\\utilities\\config.Properties"));
        Properties prob = new Properties();
        prob.load(fis);
        switch (prob.getProperty("browser").toLowerCase()){

            case "chrome":
                System.setProperty("webdriver.chrome.driver","D:\\SeleniumFiles\\Drivers\\chromedriver.exe");
                driver  = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","D:\\SeleniumFiles\\Drivers\\chromedriver.exe");
                driver  = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Pass the valid browser name");
        }

//        if(prob.getProperty("browser").equalsIgnoreCase("chrome")){
//            System.setProperty("webdriver.chrome.driver","D:\\SeleniumFiles\\Drivers\\chromedriver.exe");
//            driver  = new ChromeDriver();
//        }
//        else if(prob.getProperty("browser").equalsIgnoreCase("edge")){
//            System.setProperty("webdriver.edge.driver","D:\\SeleniumFiles\\Drivers\\chromedriver.exe");
//            driver  = new EdgeDriver();
//        }
//        else {
//
//            throw new IllegalArgumentException("Pass the valid browser name");
//        }

       // driver.get(prob.getProperty("url"));
        driver.navigate().to(prob.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }

    public static int value(int b){

        int a =b ;

        return a;
    }

    public static String stringValue(){

        String name= "LearnMore";

        return name;

    }


}
