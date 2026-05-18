package TestRunner;

import Config.BasePage;
import Pages.LoginPages;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginWithCLi extends BasePage {

    @Test
    public void doLoginWithValidCred() throws InterruptedException, IOException {
        LoginPages loginPages=new LoginPages(driver,test);
        String username= System.getProperty("username");
        String password= System.getProperty("password");
        loginPages.hrmLoginPage(username,password);
        String TextExpected=driver.findElement(By.xpath("//span/h6[text()='Dashboard']")).getText();
        String TextActual="Dashboard";
        Assert.assertEquals(TextActual,TextExpected);
        Thread.sleep(2000);

    }
}
