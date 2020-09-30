package Flipkart_Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Login_Function
{
    @Test
    @Parameters({"browser","url","emailid","password"})
    public void UserLogin(String browser,String url,String emailid,String password) throws InterruptedException
    {
        BrowserSetup Login=new BrowserSetup();
        WebDriver driver=Login.SetUp(browser,url);
        User_Login log=new User_Login();
        log.Login_Test(browser,url,emailid,password);

            }



}
