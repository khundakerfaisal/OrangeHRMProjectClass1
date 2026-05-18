package TestRunner;

import Config.BasePage;
import Pages.LoginPages;
import UtilsPages.UtilsFile;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginTest extends BasePage {

    @Test
    public void doLoginWithValidCred() throws InterruptedException, IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        test=extent.createTest("Login Functionalities check");
        test=test.createNode("Login Functionalities check");
        LoginPages loginPages=new LoginPages(driver,test);

        String username=System.getProperty("username");
        String password=System.getProperty("password");

//        loginPages.hrmLoginPage("Admin","admin123");
        loginPages.hrmLoginPage(username,password);
        UtilsFile.getScreenShot(driver,"Login Successfully",test);
        Thread.sleep(1000);
        String TextExpected=driver.findElement(By.xpath("//span/h6[text()='Dashboard']")).getText();
        String TextActual="Dashboard";
        Assert.assertEquals(TextActual,TextExpected);
        Thread.sleep(1000);
    }

}
