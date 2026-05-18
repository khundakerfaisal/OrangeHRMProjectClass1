package Pages;

import UtilsPages.UtilsFile;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPages {
    WebDriver driver;
    public ExtentTest test;
    @FindBy(name = "username")
    WebElement txtUserName;
    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;

    public LoginPages(WebDriver driver,ExtentTest test){

        this.test=test;
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void hrmLoginPage(String username,String password) throws InterruptedException, IOException {
        txtUserName.sendKeys(username);
        test.info("Username Found As Expected");
        test.pass("Enter Username Successfully");
        UtilsFile.getScreenShot(driver,"Enter Username Successfully",test);
        Thread.sleep(1000);
        txtPassword.sendKeys(password);
        test.info("Password Username Found As Expected");
        test.pass("Enter Password Successfully");
        UtilsFile.getScreenShot(driver,"Enter Password Successfully",test);

        Thread.sleep(1000);
        UtilsFile.getScreenShot(driver,"Login Successfully",test);
        loginButton.click();
        test.info("Submit Button Found As expected");
        test.pass("Login Successfully");
        Thread.sleep(2000);
    }
}
