package TestRunner;

import Config.BasePage;
import Pages.LoginPages;
import Pages.PIMPages;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import UtilsPages.UtilsFile;

import java.io.IOException;



public class PIMTest extends BasePage {
    public ExtentTest parentTest;
    @Test(priority=1)
    public void doLoginWithValidCred() throws InterruptedException, IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        parentTest=extent.createTest("Login Functionalities check");
        test=parentTest.createNode("Login Successfully");
        LoginPages loginPages=new LoginPages(driver,test);
        loginPages.hrmLoginPage("Admin","admin123");
        Thread.sleep(1000);
        String TextExpected=driver.findElement(By.xpath("//span/h6[text()='Dashboard']")).getText();
        String TextActual="Dashboard";
        Assert.assertEquals(TextActual,TextExpected);
        Thread.sleep(1000);
    }
    @Test(priority=2)
    public void createEmployee() throws InterruptedException, IOException, ParseException {
        test=parentTest.createNode("Employee Create Successfully");
        PIMPages pimPages=new PIMPages(driver,test);

        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String middleName=faker.name().nameWithMiddle();
        String lastName=faker.name().lastName();
        String userName=faker.name().username();
        String password="Pa@ssord123";
        String confirmPassword="Pa@ssord123";


        pimPages.pimMenuOperation(firstName,middleName,lastName,userName,password,confirmPassword);
        Thread.sleep(1000);
        UtilsFile.saveEmployee(firstName,middleName,lastName,userName,password,confirmPassword);


        String TextExpected=driver.findElement(By.xpath("//h6[text()='Personal Details']")).getText();
        String TextActual="Personal Details";
        Assert.assertEquals(TextActual,TextExpected);
        Thread.sleep(1000);
    }
}
