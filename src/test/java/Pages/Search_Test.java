package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Search_Test {
	WebDriver driver;
	String AssertText;
	ExtentTest test;
	
	public Search_Test(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	//Locators
	
	@FindBy(xpath = "//input[@id='header_search_text']")
	WebElement Search_TextBox;
	
	
	@FindBy(xpath = "//form[@id='header_search']//div[@class='search']//a[@href='javascript:autoSuggestion.headerSearch()']")
	WebElement Seach_Button;
	
	@FindBy(xpath = "//div[@class='errorMsg']")
	WebElement  Error_Msg;
	
	
	public void search_1(String data1) {
		test.log(LogStatus.PASS,"Testing search functionality via search data for Exercise Roller");
		Search_TextBox.sendKeys(data1);
		test.log(LogStatus.PASS,"clicking on search button");
		Seach_Button.click();
	}
	
	public void search2(String data2) {
		test.log(LogStatus.PASS,"Clearing search text box to perform second search");
		Search_TextBox.clear();
		test.log(LogStatus.PASS,"Testing search functionality via search data for               SIT     UP    STAND             BAR");
		Search_TextBox.sendKeys(data2);
		test.log(LogStatus.PASS,"clicking on search button");
		Seach_Button.click();
	}
	
	public void Search3(String data3) {
		test.log(LogStatus.PASS,"Clearing search text box to perform third search");
		Search_TextBox.clear();
		test.log(LogStatus.PASS,"Testing search functionality via search data for 12345%$#@12542");
		Search_TextBox.sendKeys(data3);
		test.log(LogStatus.PASS,"clicking on search button");
		Seach_Button.click();
	}
	
	
	public void Asserting_Err_Msg() {
		test.log(LogStatus.PASS,"Getting Error text message and storing in a variable");
		AssertText = Error_Msg.getText();
		test.log(LogStatus.PASS,"Asserting the invalid search input data");
		Assert.assertEquals(AssertText,"Either no product matches the word entered by you or please remove some of filter options selected to see products.");
	    System.out.println(AssertText);
	}

}
