package TestCases;

import cucumber.api.java.en.And;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;


@RunWith(SerenityRunner.class)
public class LoginSteps extends PageObject{
	
	@Managed ()
	WebDriver driver;


@Test
	@Given("^user navigates to the website$")
	public void user_navigates_to_the_website() {
	open();
	 
	}

@Test	
@When("^user click on sign in link$")
	public void user_click_on_sign_in_link() {
		driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).click();
	   
	}

@Test
@And("^user click on Sign in with IMDb button$")
	public void user_click_on_Sign_in_with_IMDb_button() {
		driver.findElement(By.xpath("//span[contains(text(),'Sign in with IMDb')]")).click();
	   
	}

@Test
@And("^user types in (.*) and (.*)$")
	public void user_types_in_emailID_and_password(String uid , String pass) {

		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(uid);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(pass);
	  
	}

@Test
@And("^clicks on the Sign In button$")
	public void clicks_on_the_Sign_In_button() {
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	    
	}

@Test
@Then("^user should be able to log in to the website$")
	public void user_should_be_able_to_log_in_to_the_website() {
		driver.findElement(By.xpath("//body/div[@id='__next']/nav[@id='imdbHeader']/div[2]/div[5]/div[1]/label[2]/*[1]")).click();
		WebElement Signout=driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
		Signout.isDisplayed();
		System.out.print("user has successfully logged in");
	   
	}



}
