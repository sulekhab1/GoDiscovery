package DiscoverPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	WebDriver driver;
	String titleText;
	String descriptionText;
	
	//Constructor to initialize driver
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Required elements present in go discovery page
	
	@FindBy(xpath="//div[contains(text(),'Recommended')]") 
	@CacheLookup
	WebElement recommended;
	
	@FindBy(how=How.XPATH,using="//body/div[@id='react-root']/div[@class='app-main app__main umbrella']/div[@class='page-wrapper app__pageWrapper']/section[8]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement video1;
	
	@FindBy(how=How.XPATH,using="/body/div[@id='react-root']/div[@class='app-main app__main umbrella']/div[@class='page-wrapper app__pageWrapper']/section[8]/div[1]/div[1]/div[1]/div[1]/div[2]\"")
	WebElement video2;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/section[8]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[3]/a[1]/div[1]/h3[1]/div[1]")
	WebElement title;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/section[8]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[3]/a[1]/div[1]/div[1]/div[1]")
	WebElement description;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/section[8]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[3]/a[1]/div[1]/div[2]/div[1]/span[1]/i[1]")
	WebElement addToFav;
	
	@FindBy(how=How.XPATH,using="//*[@class='dscHeaderMain__iconMenu']")
	WebElement menu;
	
	// Method to scroll down to Recommended Videos 
	public void scrollToRecommendedVideos(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", recommended);	
	}
	
	//Method to add video to favorites
	public void addToFavorites() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(video1).perform();
		
		titleText = title.getText();
		System.out.println(titleText);	
		
		descriptionText = description.getText();
		System.out.println(descriptionText);
		
		addToFav.click();
	}
	
	//Method to open menu
	public void openMenu() {
		menu.click();
	}
	
	//Method to get title of the video
	public String getTitle() {
		return titleText;
	}
	
	//Method to get description of the video
	public String getDescription() {
		return descriptionText;
	}
		
}





	
	//Actions action = new Actions(driver);
	
	/*By recommended = By.xpath("//div[contains(text(),'Recommended')]");
	By video1 = By.xpath("//body/div[@id='react-root']/div[@class='app-main app__main umbrella']/div[@class='page-wrapper app__pageWrapper']/section[8]/div[1]/div[1]/div[1]/div[1]/div[1]");
	By video2 = By.xpath("//body/div[@id='react-root']/div[@class='app-main app__main umbrella']/div[@class='page-wrapper app__pageWrapper']/section[8]/div[1]/div[1]/div[1]/div[1]/div[2]");
	By add1 = By.xpath("//a[@id='z2usst-0']//i[contains(@class,'flipIconCore__icon icon-plus')]");
	By title = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[8]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[3]/a[1]/div[1]/h3[1]/div[1]");
	By description = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[8]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[3]/a[1]/div[1]/div[1]/div[1]");
	By addToFav =  By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[8]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[3]/a[1]/div[1]/div[2]/div[1]/span[1]/i[1]");
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void recommendedVideos() {
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].scrollIntoView();", recommended);
	}
	
	public void moveToVideo() {
		actions.moveToElement((WebElement) video1).perform();
	}
	
	public String getTitle() {
		String titleText = ((WebElement) title).getText();
		System.out.println(titleText);
		return titleText;
	}
	
	public String getDescription() {
		String descriptionText = ((WebElement) description).getText();
		System.out.println(descriptionText);
		return descriptionText;
	}
	
	public void addToFavourite() {
		((WebElement) addToFav).click();
	}*/

