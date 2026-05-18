package UtilsPages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class UtilsFile {



    public static void saveEmployee(String firstName, String middleName, String lastName, String userName, String password, String confirmPassword) throws IOException, ParseException {
        String filePath="./src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray addedArray= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject addedObject=new JSONObject();
        addedObject.put("FirstName",firstName);
        addedObject.put("MiddleName",middleName);
        addedObject.put("LastName",lastName);
        addedObject.put("UserName",userName);
        addedObject.put("Password",password);
        addedObject.put("ConfirmPassword",confirmPassword);
        addedArray.add(addedObject);
        FileWriter writer=new FileWriter(filePath);
        writer.write(addedArray.toJSONString());
        writer.flush();
        writer.close();

    }
    public static JSONObject getUser() throws IOException, ParseException {
        String filePath="./src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray lastAddedArray= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject lastAddedObject= (JSONObject) lastAddedArray.get(lastAddedArray.size()-1);
        return lastAddedObject;

    }


    @DataProvider(name = "csvData")
    public Object[][] getCsvData() throws IOException {
        String filePath="src/test/resources/login.csv";
        List<Object> getData=new ArrayList<>();
        CSVParser parser=new CSVParser(new FileReader(filePath),CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord getCsvData:parser){
            String username=getCsvData.get("username");
            String password=getCsvData.get("password");
            getData.add(new Object[]{username,password});
        }
        return getData.toArray(new Object[0][]);
    }

    @DataProvider(name = "csvEmpData")
    public Object[][] getCsvEmpData() throws IOException {
        String filePath="src/test/resources/emp.csv";
        List<Object> getData=new ArrayList<>();
        CSVParser parser=new CSVParser(new FileReader(filePath),CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord getCsvData:parser){
            String firstName=getCsvData.get("firstName");
            String MiddleName=getCsvData.get("MiddleName");
            String LastName=getCsvData.get("LastName");
            String Username=getCsvData.get("Username");
            getData.add(new Object[]{firstName,MiddleName,LastName,Username});
        }
        return getData.toArray(new Object[0][]);
    }

    public static ExtentReports extent;
    public static ExtentReports getInstance(){
        if (extent==null){
            ExtentSparkReporter sparkReporter=new ExtentSparkReporter("reports/ExtentReport.html");
            extent=new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;

    }

    public static void getScreenShot(WebDriver driver, String message,ExtentTest test) throws IOException {
        Random randNumber = new Random();
        int generateAutoNumber = randNumber.nextInt(9999) + 1111;
        File srcFilePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotDir = "reports/screenshots/";
        new File(screenshotDir).mkdirs(); // Ensure directory exists
        String imageFileName = "screenshot_" + generateAutoNumber + ".png";
        String fullScreenshotPath = screenshotDir + imageFileName;
        File destFile = new File(fullScreenshotPath);
        FileUtils.copyFile(srcFilePath, destFile);
        // Use RELATIVE path from HTML file (ExtentReport.html is in /reports/)
        String relativePath = "screenshots/" + imageFileName;
        test.pass(message,MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
    }





}
