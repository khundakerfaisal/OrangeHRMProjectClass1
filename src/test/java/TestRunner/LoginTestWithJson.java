package TestRunner;

import Config.BasePage;
import Pages.LoginPages;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import UtilsPages.UtilsFile;

import java.io.IOException;

public class LoginTestWithJson extends BasePage {
    @Test
    public void doLoginWithValidCred() throws InterruptedException, IOException, ParseException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        test=extent.createTest("Login With Json check");
        test=test.createNode("Json Login Function work as expected" );
        LoginPages loginPages=new LoginPages(driver,test);

        String username= UtilsFile.getUser().get("UserName").toString();
        String password= UtilsFile.getUser().get("Password").toString();

        loginPages.hrmLoginPage(username,password);
        Thread.sleep(1000);
        String TextExpected=driver.findElement(By.xpath("//span/h6[text()='Dashboard']")).getText();
        String TextActual="Dashboard";
        Assert.assertEquals(TextActual,TextExpected);
        Thread.sleep(1000);
    }
}
