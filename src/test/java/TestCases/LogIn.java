package TestCases;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;


@RunWith(SerenityRunner.class)
public class LogIn extends PageObject{
	
	@Managed ()
	WebDriver driver;

	//Verify whether the newly registered user was able to login to the application
	@Test
	public void doLogin() {
		
		driver.get("http://www.imdb.com");
	
		driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Sign in with IMDb')]")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("testingsom10@gmail.com");
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("testing1111");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		
		driver.findElement(By.xpath("//body/div[@id='__next']/nav[@id='imdbHeader']/div[2]/div[5]/div[1]/label[2]/*[1]")).click();
		WebElement Signout=driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
		Signout.isDisplayed();
		System.out.print("user has successfully logged in");
		
		
		driver.findElement(By.xpath("//*[@id='navUserMenu-contents']/ul/a[7]/span")).click();
		
		System.out.print("user has successfully logged out");
		driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Sign in with IMDb')]")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("testingsom10@gmail.com");
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("testing1111");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
				
		
}
}
