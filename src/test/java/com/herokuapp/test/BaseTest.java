package com.herokuapp.test;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.herokuapp.configuration.Url;
import com.herokuapp.page.SearchPage;

public class BaseTest {
	
	protected WebDriver driver;
	protected SearchPage search;
	private static final int RANGE_NUMBER	= 1000000000;

  @BeforeMethod
  public void setUp() {
	  manageBrowser();
	  search = new SearchPage(driver);
  }
  
  public void manageBrowser() {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") 
					  								+ "/src/test/resources/drivers/chromedriver");

	  driver = new ChromeDriver();
	  driver.navigate().to(Url.DEFAULT_WEB_SITE.getValue());
	  driver.manage().window().maximize(); 
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }
  
  /***
   * This method aimed at concatenating a random number in company name in order to become unique and
   * ensure that the item has been created, read, updated or deleted successfully
   * @param companyName
   * @return company name + random number
   */
  public String concatenateRandomNumberInCompanyName(String companyName) {
	  return companyName.concat("_" + Integer.toString(new Random().nextInt(RANGE_NUMBER)));  
  }
}
