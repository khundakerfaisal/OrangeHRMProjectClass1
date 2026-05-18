package Pages;

import UtilsPages.UtilsFile;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class PIMPages {
    WebDriver driver;
    public ExtentTest test;
    @FindBy(className = "oxd-main-menu-item-wrapper")
    List<WebElement> pimMenu;
    @FindBy(className = "oxd-button")
    List<WebElement> clickAddButton;

    @FindBy(name = "firstName")
    WebElement inputFirstName;
    @FindBy(name = "middleName")
    WebElement inputMiddleName;
    @FindBy(name = "lastName")
    WebElement inputLastName;

    @FindBy(className = "oxd-switch-input")
    List<WebElement> checkBoxSelection;


    @FindBy(className = "oxd-input")
    List<WebElement> inputUsername;
    @FindBy(className = "oxd-input")
    List<WebElement> inputPassword;
    @FindBy(className = "oxd-input")
    List<WebElement> inputConfirmPassword;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement submitCreateAuthButton;
    public PIMPages(WebDriver driver,ExtentTest test){
        this.test=test;

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void pimMenuOperation(String firstName,String middleName,String lastName,String userName,String password,String confirmPassword) throws InterruptedException, IOException {
        pimMenu.get(1).click();
        Thread.sleep(1000);
        clickAddButton.get(2).click();
        Thread.sleep(1000);
        inputFirstName.sendKeys(firstName);
        test.info("FirstName Found As Expected");
        test.pass("Enter FirstName Successfully");
        UtilsFile.getScreenShot(driver,"Enter FirstName Successfully",test);
        Thread.sleep(1000);
        inputMiddleName.sendKeys(middleName);
        test.info("MiddleName Found As Expected");
        test.pass("Enter MiddleName Successfully");
        UtilsFile.getScreenShot(driver,"Enter MiddleName Successfully",test);
        Thread.sleep(1000);
        inputLastName.sendKeys(lastName);
        test.info("LastName Found As Expected");
        test.pass("Enter LastName Successfully");
        UtilsFile.getScreenShot(driver,"Enter LastName Successfully",test);
        Thread.sleep(1000);
        checkBoxSelection.get(0).click();
        Thread.sleep(1000);
        inputUsername.get(5).sendKeys(userName);
        test.info("Username Found As Expected");
        test.pass("Enter Username Successfully");
        UtilsFile.getScreenShot(driver,"Enter Username Successfully",test);
        Thread.sleep(1000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)");
        inputPassword.get(6).sendKeys(password);
        test.info("Password Found As Expected");
        test.pass("Enter Password Successfully");
        UtilsFile.getScreenShot(driver,"Enter Password Successfully",test);
        Thread.sleep(1000);
        inputConfirmPassword.get(7).sendKeys(confirmPassword);
        test.info("ConfirmPassword Found As Expected");
        test.pass("Enter ConfirmPassword Successfully");
        UtilsFile.getScreenShot(driver,"Enter ConfirmPassword Successfully",test);
        Thread.sleep(1000);
        submitCreateAuthButton.click();
        test.info("Submit button Found As Expected");
        test.pass("Submit Employee Successfully");
        UtilsFile.getScreenShot(driver,"Submit Employee Successfully",test);
        Thread.sleep(1000);


    }
}
