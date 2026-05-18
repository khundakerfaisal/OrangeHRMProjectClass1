package Config;

import UtilsPages.UtilsFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BasePage {
    public static ExtentReports extent;
    public static ExtentTest test;
//    public static ExtentTest node;

    public WebDriver driver;
    @BeforeClass

    public void StartBrowser(){
        extent= UtilsFile.getInstance();
        test=extent.createTest("Browser Start Successfully");
        test.pass("Browser open successfully!!");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
@AfterClass
    public void CloseBrowser(){
        driver.quit();
        test=extent.createTest("Browser closed Successfully");
        test.pass("Browser Close successfully!!");
        extent.flush();


    }




}
