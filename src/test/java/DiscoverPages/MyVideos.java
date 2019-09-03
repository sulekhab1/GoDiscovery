package DiscoverPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyVideos {
	
	WebDriver driver;
	String titleText;
	String descriptionText;
	
	//Constructor to initialize driver
	public MyVideos(WebDriver driver) {
		this.driver = driver;
	}
	
	//Required elements present in go.discovery.myvideos page
	@FindBy(xpath="//span[contains(text(),'My Videos')]") 
	WebElement myVideos;
	
	@FindBy(xpath="//div[contains(text(),'Favorite Shows')]") 
	WebElement myFavourite;
	
	@FindBy(xpath="//body/div[@id='react-root']/div[@class='app-main app__main umbrella']/div[@class='page-wrapper app__pageWrapper']/div[@class='myVideosLayout__wrapper']/main[@class='myVideosLayout__container']/div[@class='myVideosLayout__blocksWrapper']/div[@class='myVideosLayout__localStorageCarousels']/section[contains(@class,'layout-section FavoriteShowsCarousel layoutSection__main')]/div[@class='localStorageCarousel__wrapper']/div[@class='show-carousel showCarousel__main']/div[@class='carousel carousel__main showCarousel__carousel is-mouse-experience']/div/div[@class='content carousel__content showCarousel__content']/div[1]")
	WebElement video1;
	
	@FindBy(xpath="//body/div[@id='react-root']/div[@class='app-main app__main umbrella']/div[@class='page-wrapper app__pageWrapper']/div[@class='myVideosLayout__wrapper']/main[@class='myVideosLayout__container']/div[@class='myVideosLayout__blocksWrapper']/div[@class='myVideosLayout__localStorageCarousels']/section[contains(@class,'layout-section FavoriteShowsCarousel layoutSection__main')]/div[@class='localStorageCarousel__wrapper']/div[@class='show-carousel showCarousel__main']/div[@class='carousel carousel__main showCarousel__carousel is-mouse-experience']/div/div[@class='content carousel__content showCarousel__content']/div[2]")
	WebElement video2;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[3]/a[1]/div[1]/h3[1]/div[1]")
	WebElement title;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[3]/a[1]/div[1]/div[1]/div[1]")
	WebElement description;
	
	//Method to to go to My Videos
	public void goToMyVideos() {
		myVideos.click();
	}
	
	// Method to scroll down to Favorites Videos 
	public void scrollToMyFavorites() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", myFavourite);
		js.executeScript("window.scrollBy(0,250)");
	}
	
	//Method to get title of the video
	public String getTitle() {
		Actions actions = new Actions(driver);
		actions.moveToElement(video1).perform();
		
		titleText=title.getText();
		System.out.println(titleText);
		return titleText;
	}
	
	//Method to get description of the video
	public String getDescription() {
		descriptionText=description.getText();
		System.out.println(descriptionText);
		return descriptionText;
	}
	
}
