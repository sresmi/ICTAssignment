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

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Delete_Cart {


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
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("laptop");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        //Clicking the first entry
        driver.findElement(By.className("_3wU53n")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("_3SQWE6")).click();
        Thread.sleep(3000);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.xpath("//input[@class='_3X4tVa']")).sendKeys("670141");
        driver.findElement(By.xpath("//span[@class='_2aK_gu']")).click();
        driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
        driver.navigate().to("https://www.flipkart.com/viewcart?otracker=PP_GoToCart");
        //Test to check page loaded
        Assert.assertEquals(driver.getTitle(), "Shopping Cart | Flipkart.com");
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]"))).click();

        driver.findElement(By.xpath("//div[@class='gdUKd9 _3Z4XMp _2nQDKB']")).click();
//        JavascriptExecutor js=(JavascriptExecutor)driver;
//        Thread.sleep(2000);
//        js.executeScript("arguments[0].click()");

    }
    }



