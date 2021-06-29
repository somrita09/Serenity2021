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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@RunWith(SerenityRunner.class)
public class SearchAMovieSteps extends PageObject {
	
	@Managed ()
	WebDriver driver;

	
	@Test
	@When("^user click on Menu button$")
	public void user_click_on_Menu_button() {
		
		driver.findElement(By.xpath("//Label[@id='imdbHeader-navDrawerOpen--desktop']")).click();
	    
	}

	@And("^user select Top Rated Shows link under TV Shows category$")
	public void user_select_Top_Rated_Shows_link_under_TV_Shows_category() {
		driver.findElement(By.linkText("Top Rated Shows")).click();
	  
	}
	
	@And("^user search for a (.*) in searchbox$")
	public void user_search_for_a_movie_in_searchbox(String mviesearch) {
		driver.findElement(By.id("suggestion-search")).sendKeys(mviesearch);
	}

	@And("^Click on a (.*) from the suggestion window$")
	public void click_on_a_Movie_link_from_the_suggestion_window(String mvl) {
		driver.findElement(By.xpath("//div[contains(text(),'"+mvl+"')]")).click();
	   
	}

	@Then("^(.*) should be correctly displayed$")
	public void movie_title_should_be_correctly_displayed(String movieTitle) {
		
		WebElement Title = driver.findElement(By.xpath("//h1[contains(text(),'"+movieTitle+"')]"));
		Assert.assertTrue(Title.isDisplayed());
	}

	@Then("^Movie (.*) should be displayed$")
	public void movie_rating_should_be_displayed(String rt) {
		//WebElement Rating = driver.findElement(By.xpath("//div[@class='AggregateRatingButton__ContentWrap-sc-1il8omz-0 cMcGnJ']"));
		WebElement Rating = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[1]/div[2]/div/div[1]/div[1]/div[1]/strong/span"));
		Assert.assertTrue(Rating.isDisplayed());
		Assert.assertEquals(rt, Rating.getText());

	
	}

	@Then("^number of (.*) and (.*) for the Movie should be displayed$")
	public void number_of_User_Reviews_and_Critic_Reviews_for_the_Movie_should_be_displayed(String ur, String cr) {
		
		WebElement UserReviews = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[3]/div/div[2]/span/a[1]"));
		Assert.assertTrue(UserReviews.isDisplayed());
		Assert.assertEquals(ur, UserReviews.getText());
		WebElement CriticReviews = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[3]/div/div[2]/span/a[2]"));
		Assert.assertTrue(CriticReviews.isDisplayed());
		Assert.assertEquals(cr, CriticReviews.getText());
		
		
	}




}
