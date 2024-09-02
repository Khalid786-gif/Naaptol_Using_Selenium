package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Filter_Test {
	
	public WebDriver driver;
	Select sort_by;
	ExtentTest test;
	WebDriverWait W1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	public Filter_Test(WebDriver driver,ExtentTest test){
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//a[@class='sml_link']")
	WebElement Clear_All_Filter; 
	
	@FindBy(xpath = "//select[@id='sortByFilter']")
	WebElement Sort_By;
	
	@FindBy(xpath = "//input[@id='iscod']")
	WebElement Filter_Cod;
	
	@FindBy(xpath = "//input[@id='isexoutStock']")
	WebElement Filter_Out_Of_Stock;
	
	@FindBy(xpath = "//input[@id='pincode']")
	WebElement Filter_By_Pincode;
	
	@FindBy(css = "ul[id='personalisedFilter'] span")
	WebElement Filter_By_Pincode_Btn;
	
	@FindBy(xpath = "//input[@id='brandFilterBox8313']")
	WebElement Filter_By_Brands;
	
	@FindBy(xpath = "//a[normalize-space()='201 - 400 (13)']")
	WebElement Filter_By_Price;
	
	@FindBy(css = "ul[id='discountFilterBox'] li:nth-child(3) a:nth-child(1)")
	WebElement Filter_By_Discount;
	
	@FindBy(xpath = "//a[normalize-space()='Home Gym (3)']")
	WebElement Filter_By_Type;
	

	public void Filter_Remove() {
		
		W1.until(ExpectedConditions.visibilityOf(Clear_All_Filter));
		Clear_All_Filter.click();
		test.log(LogStatus.PASS, "Removed all the Filter");
	}
	
	public void Filter_Product_Popular(String sort_data) {
		W1.until(ExpectedConditions.visibilityOf(Sort_By));
		sort_by = new Select(Sort_By);
		sort_by.selectByVisibleText(sort_data);
		test.log(LogStatus.PASS, "Clicked on sort by filter and selected Most Popular");
	}
	
	public void Filter_Product_Cod() {
		W1.until(ExpectedConditions.visibilityOf(Filter_Cod));
		Filter_Cod.click();
		test.log(LogStatus.PASS, "Clicked on cash on delivery check box under filter optios");
	}
	
	public void Filter_Product_Out_Of_Stock() {
		W1.until(ExpectedConditions.visibilityOf(Filter_Out_Of_Stock));
		Filter_Out_Of_Stock.click();
		test.log(LogStatus.PASS, "Clicked on out of stock check box under filter options");
	}
	
	public void Filter_Product_Pincode(String pin_data) throws InterruptedException {
		Filter_By_Pincode.sendKeys(pin_data);
		test.log(LogStatus.PASS, "Entered Pincode");
		Filter_By_Pincode_Btn.click(); Thread.sleep(1000);
		test.log(LogStatus.PASS, "Clicked on Set button for filtering the product availability via pincode");
	}
	
	public void Filter_Product_Brands() throws InterruptedException {
		Filter_By_Brands.click(); Thread.sleep(1000);
		test.log(LogStatus.PASS, "Clicked on brand22 checkbox for filtering by brand");
	}
	
	public void Filter_Product_Price() throws InterruptedException {
		Filter_By_Price.click(); Thread.sleep(1000);
		test.log(LogStatus.PASS, "filter by price check box of price between 201 - 400");
	}
	
	public void Filter_Product_Discount() throws InterruptedException {
		Filter_By_Discount.click(); Thread.sleep(1000);
		test.log(LogStatus.PASS, "Clicked on filter by discount check box");
	}
	
	public void Filter_Product_Type() throws InterruptedException {
		Filter_By_Type.click(); Thread.sleep(1000);
		test.log(LogStatus.PASS, "Clicked on Home gym check box under filter by type ");
	}

}
