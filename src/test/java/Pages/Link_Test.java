package Pages;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Link_Test {
	
	WebDriver driver;
	Actions A1;
	ExtentTest test;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	

	public Link_Test(WebDriver driver,Actions A1,ExtentTest test){
		
		this.driver=driver;
		this.A1=A1;
		this.test=test;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css = "div[class='cate_head']")
	WebElement Shopping_cat;
	
	@FindBy(xpath = "(//li[@id='cshow11'])[1]")
	WebElement Sports_Fitness;
	 	
	@FindBy(xpath = "//div[@id='mainMenuContent']//a[normalize-space()='Fitness Accessories']")
	WebElement Fitness_Acessories;
	
	@FindBy(xpath = "//div[@id='mainMenuContent']//a[normalize-space()='Hiking']")
	WebElement Hiking;
	
	@FindBy(xpath = "//div[@id='mainMenuContent']//a[normalize-space()='Fitness Equipment']")
	WebElement Fitness_Equipment;
	
	public void Test_shopping_cat() throws InterruptedException {
		
		test.log(LogStatus.PASS, "Mouse Hovered on Shopping Category");
		
		A1.moveToElement(Shopping_cat).perform();
		
		wait.until(ExpectedConditions.visibilityOf(Sports_Fitness));
		
		test.log(LogStatus.PASS, "Mouse Hovered on Sports&Fitness sub category under Shopping Category");
	
		A1.moveToElement(Sports_Fitness).perform(); 
	}

	public void Test_Fitness_Acc() {
		Fitness_Acessories.click();
		test.log(LogStatus.PASS, "Checking the link navigation by clicking on Fitness Accessories");
	}
	
	public void Test_Hiking() {
		Hiking.click();
		test.log(LogStatus.PASS, "clicked on hiking sub category");
	}
	
	
	public void Test_Fitness_Equipment() {
		Fitness_Equipment.click();
		test.log(LogStatus.PASS, "clicked on Fitness&Equipment sub category");
	}

}
