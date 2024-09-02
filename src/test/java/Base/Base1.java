package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Pages.AddToCart_Test;
import Pages.Compare_Test;
import Pages.Filter_Test;
import Pages.Link_Test;
import Pages.QuickView_Test;
import Pages.Search_Test;

public class Base1 {
	
	public WebDriver driver;
	public String InputData1;
	public String InputData2;
	public String InputData3;
	public String Sort_InputData4;
	public String Pincode_InputData5;
	public String Add_To_Cart_Page_Title;
	public String Add_To_Quantity_Err_Msg;
	public Link_Test p1;
	public Search_Test S1;
	public Filter_Test F1;
	public QuickView_Test Q1;
	public Compare_Test C1;
	public AddToCart_Test ATC1;
	public Actions A1;
	public JavascriptExecutor js;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void Report_config() {
		report = new ExtentReports("S:\\Contruct_Week_Project_Unit_3\\Naaptol\\REeports.html");
		test = report.startTest("Naaptol Sports and Fitness Categories Testing");
	}
	public void Take_Screenshot(WebDriver driver,int n) throws IOException {
		TakesScreenshot SS = (TakesScreenshot) driver;
		File Image = SS.getScreenshotAs(OutputType.FILE);
		File Img = new File("S:\\Contruct_Week_Project_Unit_3\\Naaptol\\Naaptol_Screenshot\\Image"+n+".png");
		FileUtils.copyFile(Image, Img);
	}

	@BeforeMethod
	public void SetUp() throws IOException {
		
		driver = new ChromeDriver();
		
		A1 = new Actions(driver);
		
		Properties pr = new Properties();
		
		FileInputStream fl = new FileInputStream("S:\\Contruct_Week_Project_Unit_3\\Naaptol\\src\\test\\resources\\Properties_File\\Config.properties");
		
		pr.load(fl);
		
		p1 = new Link_Test(driver,A1,test);
		
		S1 = new Search_Test(driver,test);
		
		js = (JavascriptExecutor) driver;
		
		F1 = new Filter_Test(driver,test);
		
		C1 = new Compare_Test(driver,test);
		
		Q1 = new QuickView_Test(driver,A1,test);
		
		ATC1 = new AddToCart_Test(driver,A1,js,test);
		
		String web_url = pr.getProperty("url");
		
		InputData1 = pr.getProperty("InputData");
		
		InputData2 = pr.getProperty("InputData2");
		
		InputData3 = pr.getProperty("InputData3");
		
		Sort_InputData4 = pr.getProperty("Sort");
		
		Pincode_InputData5 = pr.getProperty("Pincode");
		
		Add_To_Cart_Page_Title = pr.getProperty("AddToCart_Title");
		
		Add_To_Quantity_Err_Msg = pr.getProperty("Add_Quantity_Err_Msg");
		
		driver.get(web_url);  
		
		driver.manage().window().maximize();	
		
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
	
	@AfterClass
	public void Flush_Report() {
		report.flush();
		report.endTest(test);
	}
	

}
