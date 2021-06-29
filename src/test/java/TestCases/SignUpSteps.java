package TestCases;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;


@RunWith(SerenityRunner.class)
public class SignUpSteps extends PageObject{
	
	@Managed ()
	WebDriver driver;
	
	@Test
	@When("^user clicks on the ‘Create a New Account’ button$")
	public void user_clicks_on_the_Create_a_New_Account_button() {
		driver.findElement(By.xpath("//a[contains(text(),'Create a New Account')]")).click();
	 
	}

	@Test
	@And("^user enters signing up details (.*) ,(.*) and (.*)$")
	public void user_enters_signing_up_details_Name_ID_and_password(String name,String uid , String pass) {
		
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(uid);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='ap_password_check']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		
		
		//Type the entered captcha to the text box
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(captchaVal);	
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/span[1]/span[1]/input[1]")).click();
		
		//Ask user to enter email OTP in the prompt
		String emailOTP = JOptionPane.showInputDialog("Please enter the Email OTP:");
		
		//Type the entered OTP to the text box
		driver.findElement(By.xpath("//input[@id='cvf-input-code']")).sendKeys(emailOTP);	
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[7]/span[1]/span[1]/input[1]")).click();
		
	   
	}

	@Test
	@Then("^user should be able to sign in to the website$")
	public void user_should_be_able_to_sign_in_to_the_website() {
		
		WebElement profileicon=driver.findElement(By.xpath("//body/div[@id='__next']/nav[@id='imdbHeader']/div[2]/div[5]/div[1]/label[2]/*[1]"));
		profileicon.isDisplayed();
		System.out.print("user has successfully signed up");
	   
	}
	

}
