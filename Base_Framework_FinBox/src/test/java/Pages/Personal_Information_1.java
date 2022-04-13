package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Personal_Information_1 extends UtilityMethods {
	
	
	public Personal_Information_1(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
     @FindBy(xpath ="//input[@placeholder=\"Enter your full name as per PAN\"]")
     WebElement yourFullName; 
	public void enterYourFullName(String name)
	{
		enter_value(yourFullName, name);
	}
	
	 @FindBy(xpath ="//input[@placeholder=\"Enter your email address\"]")
     WebElement email_Address;
	 public void enterEmailAddress(String email)
		{
			enter_value(email_Address, email);
		}
	
	 
	 @FindBy(xpath ="//input[@type=\"checkbox\"]")
     WebElement checkBox;
	 public void clickCheckBox()
		{
			clickAction(checkBox);
		}
	 public boolean isEnable()
	 {
		boolean enable = checkBox.isEnabled();
		return enable;
	 }
		
	 
	 
	 @FindBy(xpath ="//button[contains(text(),'Next')]")
     WebElement nextButton;
	 public void clicknextButton()
		{
			clickAction(nextButton);
		}
	
}
