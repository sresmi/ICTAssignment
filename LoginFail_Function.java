package Flipkart_Login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginFail_Function {

    @Test
    @Parameters({"browser","url","email_id","pass_word"})
    public void UserLogin(String browser,String url,String email_id,String pass_word) throws InterruptedException
    {
        BrowserSetup Login=new BrowserSetup();
        WebDriver driver=Login.SetUp(browser,url);
        User_Login log=new User_Login();
        log.Login_fail_Test(email_id,pass_word);
    }
}
