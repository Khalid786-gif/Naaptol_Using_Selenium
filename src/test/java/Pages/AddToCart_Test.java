package Pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v125.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

public class AddToCart_Test {
	WebDriver driver;
	Actions A1;
	String ParentWindow;
	ExtentTest test;
	JavascriptExecutor js;
	
	public AddToCart_Test(WebDriver driver,Actions A1,JavascriptExecutor js,ExtentTest test) {
		this.driver = driver;
		this.A1=A1;
		this.js=js;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Shopping Categories']")
	WebElement shopping_category;
	
	@FindBy(xpath = "(//li[@id='cshow11'])[1]")
	WebElement dropdown_sports_fitness;
	
	@FindBy(xpath = "//div[@class='item ']//span[@title='Tummy Trimmer Full Body Exercise Home Gym (FAS24)']")
	WebElement product_video_btn;
	
	@FindBy(xpath = "//a[@title='Close']")
	WebElement close_video;
	
	@FindBy(css = "img[alt='Tummy Trimmer Full Body Exercise Home Gym (FAS24)'][lazy='true'][src='//images.naptol.com/usr/local/csp/staticContent/product_images/horizontal/185x185/Tummy-Trimmer-Full-Body-Exercise-Home-Gym---FAS24-1.jpg']")
	WebElement click_on_product1;
	
	@FindBy(xpath = "//span[normalize-space()='Click here to Buy']")
	WebElement click_here_to_buy_btn1;
	
	@FindBy(xpath = "(//a[@class='link_Continue'])[1]")
	WebElement continue_shopping;
	
	@FindBy(xpath = "//div[@class='item ']//a[@title='Sit up Stand Bar Abdominal Exercises Push up with Self Suction (FAS25)'][normalize-space()='Sit up Stand Bar Abdominal Exercises Push up with']")
	WebElement click_on_product2;
	
	@FindBy(xpath = "//span[normalize-space()='Click here to Buy']")
	WebElement click_here_to_buy_btn2;
	
	@FindBy(xpath = "(//input[@class='input_Special_2'])[1]")
	WebElement add_quantity;
	
	@FindBy(css = "span[class='errMsg']")
	WebElement quantity_err_msg;
	
	@FindBy(xpath = "//input[@id='cvName']")
	WebElement gift_voucher_text_box;
	
	@FindBy(css = "a[id='cvApplybtn'] span")
	WebElement gift_voucher_apply_btn;
	
	@FindBy(xpath = "//ul[@id='shopCartHead']//a[@class='red_button2'][normalize-space()='Proceed to Checkout']")
	WebElement check_out_btn;

	

	public void Selecting_Sports_Fitness() throws InterruptedException {
		A1.moveToElement(shopping_category).build().perform();
		dropdown_sports_fitness.click();
	}
	
	public void Product_Video() throws InterruptedException {
		Thread.sleep(1000);product_video_btn.click();
	}
	
	public void Close_Video() throws InterruptedException {
		Thread.sleep(9000); close_video.click();
	}
	
	public void Click_On_Product1() {
		click_on_product1.click();
	}
	
	public void Add_To_Cart1() {
		Set<String> WindowHandles = driver.getWindowHandles();
		ParentWindow = driver.getWindowHandle();
		for (String handle : WindowHandles) {
			if(!handle.equals(ParentWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		click_here_to_buy_btn1.click();
	}
	
	public void Continue_Shopping() throws InterruptedException {
		Thread.sleep(1000);continue_shopping.click(); 
		driver.switchTo().window(ParentWindow);
		
	}
	
	public void Click_On_Product2() {
		click_on_product2.click();
	}
	
	public void Add_To_Cart2(String page_title) {
		Set<String> WindowHandles = driver.getWindowHandles();
		for (String handle : WindowHandles) {
			String Title = driver.getTitle();
			if(Title.equals(page_title)) {
				break;
			} else {
				driver.switchTo().window(handle);
			}
		}
		click_here_to_buy_btn2.click();
	}
	
	public void Add_3_Quantity() throws InterruptedException {
		Thread.sleep(1000); js.executeScript("arguments[0].setAttribute('value', '3');", add_quantity); 
        A1.keyDown(add_quantity, Keys.ENTER).keyUp(add_quantity, Keys.ENTER).build().perform(); 
	}
	
	public void More_Than_2_Quantity_Err_Msg(String assert_text) {
		String Err_Msg = quantity_err_msg.getText();
		Assert.assertEquals(Err_Msg," "+assert_text);
	}
	
	public void Enter_Gift_Voucher() {
		gift_voucher_text_box.sendKeys("12345");
	}
	
	public void Apply_Gift_Voucher() {
		gift_voucher_apply_btn.click();
	}
	
	public void Proceed_To_Checkout() {
		check_out_btn.click();
	}
}
