package Flipkart_Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User_Login
{
public WebDriver driver=null;
    @Test(priority=1)
    @Parameters({"browser","url","emailid","password"})
    public void Login_Test(String browser,String url,String emailid,String password) throws InterruptedException
    {

BrowserSetup Login=new BrowserSetup();
WebDriver driver=Login.SetUp(browser,url);
Actions actions=new Actions(driver);
Action sendEsc=actions.sendKeys(Keys.ESCAPE).build();
sendEsc.perform();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
        String LoginMessage=driver.findElement(By.className("_3Ep39l")).getText();
        Assert.assertEquals(LoginMessage,"Login");
        driver.findElement(By.className("_3Ep39l")).click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(emailid);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        WebElement login_button=driver.findElement(By.xpath("//div[@class='_1avdGP']/button"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",login_button);

            }

            @Test(priority=2)
            @Parameters({"email_id","pass_word"})
            public void Login_fail_Test(String email_id,String pass_word) throws InterruptedException
            {
                Actions actions=new Actions(driver);
                Action sendEsc=actions.sendKeys(Keys.ESCAPE).build();
                sendEsc.perform();
                driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
                String LoginMessage=driver.findElement(By.className("_3Ep39l")).getText();
                Assert.assertEquals(LoginMessage,"Login");
                driver.findElement(By.className("_3Ep39l")).click();

                driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
                driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(email_id);
                driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass_word);
                WebElement login_button=driver.findElement(By.xpath("//div[@class='_1avdGP']/button"));
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("arguments[0].click()",login_button);

            }
  @AfterMethod
public void Driverclose()
{
    driver.quit();
}
}

