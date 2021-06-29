package TestCases;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;


@RunWith(SerenityRunner.class)
public class SearchMovie extends PageObject{
	
	@Managed ()
	WebDriver driver;

	
	@Test
	public void doSearch() {
		
		driver.get("http://www.imdb.com");
		
		driver.findElement(By.xpath("//Label[@id='imdbHeader-navDrawerOpen--desktop']")).click();
		
		driver.findElement(By.linkText("Top Rated Shows")).click();
		driver.findElement(By.id("suggestion-search")).sendKeys("Game of thrones");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//driver.findElement(By.xpath("//li[@id='react-autowhatever-1--item-8']")).click();

		driver.findElement(By.xpath("//div[contains(text(),'Game of Thrones: The Last Watch')]")).click();
		                            //div[contains(text(),'<Game of Thrones: The Last Watch>')]
		
		WebElement Title = driver.findElement(By.xpath("//h1[contains(text(),'Game of Thrones: The Last Watch')]"));
		
		//WebElement Title = driver.findElement(By.xpath("//h1[text()='Game of Thrones: The Last Watch']"));
		Assert.assertTrue(Title.isDisplayed());
		//Assert.assertEquals("Game of Thrones: The Last Watch", Title.getText());
		System.out.print("Movie Title matched :" + Title.getText());

		WebElement Rating = driver.findElement(By.xpath("//div[@class='AggregateRatingButton__ContentWrap-sc-1il8omz-0 cMcGnJ']"));
		Assert.assertTrue(Rating.isDisplayed());
		
		System.out.print("Movie Rating is :"+ Rating.getText());
		
		WebElement Reviews = driver.findElement(By.xpath("//span[@class='less-than-three-Elements']"));
		Assert.assertTrue(Reviews.isDisplayed());

		System.out.print("Total Number of Movie Review is :"+ Reviews.getText());
}
}
