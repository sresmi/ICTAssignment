

package Flipkart_Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sorted_List {


    WebDriver driver;
    @BeforeMethod
    @Parameters({"browser","url","emailid","password"})
    public void UserLogin(String browser,String url,String emailid,String password) throws InterruptedException
    {
        BrowserSetup Login=new BrowserSetup();
        WebDriver driver=Login.SetUp(browser,url);
        User_Login log=new User_Login();
        log.Login_Test(browser,url,emailid,password);

    }
    @Test(priority = 1)
    public void delete_Cart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));
        if(driver.findElement(By.xpath("//input[@name='q']")).isDisplayed())
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mobiles");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        //Clicking the first entry
        driver.findElement(By.xpath("//div[4][@class='_1xHtJz']")).click();

driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();
        String value=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).getText();

        System.out.println(value);
        Assert.assertEquals("Motorola Razr (Black, 128 GB)",value);
    }
}



