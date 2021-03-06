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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Pincode_Test
{
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
    public void addtoCart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));
        if(driver.findElement(By.xpath("//input[@name='q']")).isDisplayed()) {
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("laptop");
        }

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
//        driver.findElement(By.className("_3wU53n")).click();
//        Thread.sleep(3000);
        driver.findElement(By.className("_3SQWE6")).click();
        Thread.sleep(3000);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.xpath("//input[@class='_3X4tVa']")).sendKeys("69103");
        driver.findElement(By.xpath("//span[@class='_2aK_gu']")).click();
        String pincode_message=driver.findElement(By.xpath("_13J5uS")).getText();
        System.out.println(pincode_message);


    }


//    @AfterMethod
//    public void Driverclose()
//    {
//        driver.quit();
//    }
}





