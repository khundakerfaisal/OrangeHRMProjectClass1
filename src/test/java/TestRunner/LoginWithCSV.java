package TestRunner;

import Config.BasePage;
import Pages.LoginPages;
import UtilsPages.UtilsFile;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginWithCSV extends BasePage {

    @Test(dataProvider = "csvData" ,dataProviderClass = UtilsFile.class)
    public void doLoginWithValidCred(String username,String password) throws InterruptedException, IOException {
        LoginPages loginPages=new LoginPages(driver,test);
        loginPages.hrmLoginPage(username,password);
        String TextExpected=driver.findElement(By.xpath("//span/h6[text()='Dashboard']")).getText();
        String TextActual="Dashboard";
        Assert.assertEquals(TextActual,TextExpected);
        Thread.sleep(2000);

    }
}
