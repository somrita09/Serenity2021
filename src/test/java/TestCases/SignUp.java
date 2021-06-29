package TestCases;


import javax.swing.JOptionPane;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;


@RunWith(SerenityRunner.class)
public class SignUp extends PageObject{
	
	@Managed ()
	WebDriver driver;
	

	
	@Test
	public void doSignUp() {
		
		driver.get("http://www.imdb.com");
		
		//SIGNING IN FOR A NEW ACCOUNT
		
		driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create a New Account')]")).click();
		
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("test user 1");
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("testing9184@gmail.com");
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("testing111");
		driver.findElement(By.xpath("//input[@id='ap_password_check']")).sendKeys("testing111");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		//WebElement ele = driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/img[1]"));
		//System.out.print(ele.getText());
		
		//Ask user to enter captcha in the prompt
		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		
		
		//Type the entered captcha to the text box
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(captchaVal);	
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/span[1]/span[1]/input[1]")).click();
		
		//Ask user to enter email OTP in the prompt
		String emailOTP = JOptionPane.showInputDialog("Please enter the Email OTP:");
		
		//Type the entered OTP to the text box
		driver.findElement(By.xpath("//input[@id='cvf-input-code']")).sendKeys(emailOTP);	
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[7]/span[1]/span[1]/input[1]")).click();
		
	
		WebElement profileicon=driver.findElement(By.xpath("//body/div[@id='__next']/nav[@id='imdbHeader']/div[2]/div[5]/div[1]/label[2]/*[1]"));
		profileicon.isDisplayed();
		System.out.print("user has successfully signed up");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
}
}
