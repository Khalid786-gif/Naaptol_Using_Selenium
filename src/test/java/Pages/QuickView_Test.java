package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QuickView_Test {
	WebDriver driver;
	Actions A1;
	ExtentTest test;
	

	public QuickView_Test(WebDriver driver,Actions A1,ExtentTest test) {
		this.driver=driver;
		this.A1=A1;
		this.test=test;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Shoulder & Arm Exercise Physiotherapy Pulley Set (PRS60)")
	WebElement Product_Hover1;
	
	@FindBy(xpath = "//a[@id='quickViewId2']//span[contains(text(),'Quick View')]")
	WebElement quick_view_btn;
	
	@FindBy(xpath = "//li[@id='thumb_1']//img[@title='Shoulder & Arm Exercise Physiotherapy Pulley Set (PRS60)']")
	WebElement image2;
	
	@FindBy(xpath = "//li[@id='thumb_2']//img[@title='Shoulder & Arm Exercise Physiotherapy Pulley Set (PRS60)']")
	WebElement image3;
	
	@FindBy(xpath = "//li[@id='thumb_3']//img[@title='Shoulder & Arm Exercise Physiotherapy Pulley Set (PRS60)']")
	WebElement image4;
	
	@FindBy(xpath = "//li[@id='thumb_4']//img[@title='Shoulder & Arm Exercise Physiotherapy Pulley Set (PRS60)']")
	WebElement image5;
	
	@FindBy(xpath = "//a[@class='thumb_BOTTOM']")
	WebElement down_arrow_btn;
	
	@FindBy(xpath = "//li[@id='thumb_5']//img[@title='Shoulder & Arm Exercise Physiotherapy Pulley Set (PRS60)']")
	WebElement image6;
	
	@FindBy(xpath = "//a[@id='qv_right_id']")
	WebElement next_btn;
	
	@FindBy(xpath = "//a[@id='qv_left_id']")
	WebElement prev_btn;
	
	@FindBy(xpath = "//input[@id='pincodeDeliveryId_0']")
	WebElement pincode_check;
	
	@FindBy(xpath = "//span[normalize-space()='Check']")
	WebElement pincode_check_btn;
	
	@FindBy(xpath = "//a[@class='terms_condition']")
	WebElement terms_of_use;
	
	@FindBy(xpath = "//a[normalize-space()='See More Details »']")
	WebElement see_more_details;
	
	
	public void Quick_View() {
		test.log(LogStatus.PASS, "Mouse hovered on product");
		A1.moveToElement(Product_Hover1).perform();
		test.log(LogStatus.PASS, "Clicled on a quick view button");
		quick_view_btn.click();
	}
	
	
	public void View_Images() throws InterruptedException {
		test.log(LogStatus.PASS, "Clicked on Image2");
        image2.click(); Thread.sleep(1000);
        test.log(LogStatus.PASS, "Clicked on Image3");
        image3.click(); Thread.sleep(1000);
        test.log(LogStatus.PASS, "Clicked on Image4");
        image4.click();
        test.log(LogStatus.PASS, "Clicked on Image5");
        image5.click();
        test.log(LogStatus.PASS, "Clicked on down arrow button");
        down_arrow_btn.click();
        test.log(LogStatus.PASS, "Clicked on Image6");
        image6.click(); 
	}
	
	public void Pincode_check(String pin) {
		pincode_check.sendKeys(pin); pincode_check_btn.click();
		test.log(LogStatus.PASS,"Fetching pincode from property file and entering it in pincode text box");
	}
	
	
	public void Next_Product_Quick_View() throws InterruptedException {
		Thread.sleep(1000); next_btn.click(); 
		test.log(LogStatus.PASS, "Clicked on next button in quick view");
	}
	
	public void Previous_Product_Quick_View() throws InterruptedException {
		Thread.sleep(1000); prev_btn.click(); 
		test.log(LogStatus.PASS, "Clicked on previous button in quick view");
	}
	
	public void Terms_Of_Use() {
		terms_of_use.click();
	}
	
	public void See_More_Details() {
		see_more_details.click();
		test.log(LogStatus.PASS, "Clicked on See more details on quick view window");
	}
	
	public void Page_back() {
		driver.navigate().back();
		test.log(LogStatus.PASS, "Clicked on back button");
	}
	
	public void Page_Refresh() {
		driver.navigate().refresh();
		test.log(LogStatus.PASS, "Refreshed the page");
	}

}
