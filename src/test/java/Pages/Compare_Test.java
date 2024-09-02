package Pages;

import java.util.Set;

import javax.swing.text.html.CSS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Compare_Test {
	WebDriver driver;
	ExtentTest test;
	
	public Compare_Test(WebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "#cpid12613250")
	WebElement Product1;
	
	@FindBy(css = "#cpid12613009")
	WebElement Product2;
	
	@FindBy(css = "#cpid12613213")
	WebElement Product3;
	
	@FindBy(css = "#cpid12612962")
	WebElement Product4;
	
	@FindBy(css = "#cpid12612945")
	WebElement Product5;
	
	@FindBy(xpath = "//span[normalize-space()='Compare Now']")
	WebElement Compare_Btn;
	
	@FindBy(xpath = "//tbody/tr/th[5]/a[1]")
	WebElement Remove_Btn;
	
	
	public void Add_Product1() throws InterruptedException {
		Product1.click();	Thread.sleep(500);
		test.log(LogStatus.PASS, "Added 1st product to compare ");
	}
	
	public void Add_Product2() throws InterruptedException {
		Product2.click();   Thread.sleep(500);
		test.log(LogStatus.PASS, "Added 2nd product to compare ");
	}


	public void Add_Product3() throws InterruptedException {
		Product3.click();  Thread.sleep(500);
		test.log(LogStatus.PASS, "Added 3rd product to compare ");
	}
	
	public void Add_Product4() throws InterruptedException {
		Product4.click();  Thread.sleep(500);
		test.log(LogStatus.PASS, "Added 4th product to compare ");
	}
	
	public void Add_Product5() throws InterruptedException {
		Product5.click();  Thread.sleep(500);
		test.log(LogStatus.PASS, "on trying to add 5th product");
	}
	
	public void Checking_Assertion() {
		 Alert alert = driver.switchTo().alert();
		 test.log(LogStatus.PASS, "alert message is poped stating only 4 products can be added for comparison");
		 String alert_text = alert.getText();
		 String expected_text="You can compare only 4 products at a time";
		 Assert.assertEquals(alert_text, expected_text);
		 test.log(LogStatus.PASS, "Asserted the alert text");
		 alert.accept();
		 test.log(LogStatus.PASS, "Clicked on ok on alert message");
	}
	
	public void Compare_Window() throws InterruptedException {
		Compare_Btn.click();Thread.sleep(1000);
		test.log(LogStatus.PASS, "Clicked on compare button");
        Remove_Btn.click();
        test.log(LogStatus.PASS, "Removed one of the product from the comparison");
        driver.navigate().refresh();
	}

}
