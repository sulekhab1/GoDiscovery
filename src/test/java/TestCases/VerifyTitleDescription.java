package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DiscoverPages.HomePage;
import DiscoverPages.MyVideos;
import Utility.BrowserFactory;
//import junit.framework.Assert;

public class VerifyTitleDescription {
	
	WebDriver driver;
	
	@BeforeTest
	public void openDiscoveryPage() {
		
		this.driver = BrowserFactory.startBrowser("chrome","https://go.discovery.com/");	
		
	}
	
	@Test
	public void verifyRecommended() {
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);//returns object
		MyVideos videos = PageFactory.initElements(driver, MyVideos.class);
		
		home.scrollToRecommendedVideos();
		home.addToFavorites();
		home.openMenu();
		
		videos.goToMyVideos();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		videos.scrollToMyFavorites();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Verifying title and description
		Assert.assertEquals(home.getTitle(), videos.getTitle());
		System.out.println("Title Verification successfull");
		Assert.assertEquals(home.getDescription(), videos.getDescription());
		System.out.println("Description Verification successfull");
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
