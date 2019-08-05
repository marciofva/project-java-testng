package com.herokuapp.page;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{
	
	private By inputSearch = By.id("searchbox");
	
	private By btnSearch = By.id("searchsubmit");
	private By btnAdd = By.id("add");
	private By btnPaginationPrevious = By.cssSelector(".prev > a");
	private By btnPaginationNext = By.cssSelector(".next > a");

	private By alertMessage = By.className("alert-message");
	
	private By lblResultFoundTitle = By.cssSelector("#main > h1");
	private By lblNoResultFound = By.cssSelector("#main > div.well > em");
	
	private By tableResult = By.cssSelector("#main > table > tbody > tr > td > a");

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public SearchPage fillSearchField(String text) {
		send(inputSearch, text);
		return this;
	}
	
	public SearchPage clickOnSearchBtn() {
		clickOn(btnSearch);
		return this;
	}
	
	public ComputerPage addNewComputer() {
		clickOn(btnAdd);
		return new ComputerPage(driver);
	}
	
	public SearchPage goToNextPage() {
		clickOn(btnPaginationNext);
		return this;
	}
	
	public SearchPage returnToPreviousPage() {
		clickOn(btnPaginationPrevious);
		return this;
	}
	
	public String getAlertMessage() {
		return getElement(alertMessage).getText();
	}
	
	public String getMessageForNoResultFound() {
		return getElement(lblNoResultFound).getText();
	}
	
	public String getNumberOfComputerFound() {
		return getElement(lblResultFoundTitle).getText().split(" ")[0];
	}
	
	public List<WebElement> getAllResultsOnTable(){
		return getManyElements(tableResult);
	}
	
	public ComputerPage selectFirstOption() {
		List<WebElement> list = getAllResultsOnTable();
		
		list.get(0).click();
		
		return new ComputerPage(driver);
	}
	
	
	public ComputerPage selectRandomItem() {
		List<WebElement> list = getAllResultsOnTable();
		
		int randomNumber = new Random().nextInt(list.size());
		
		list.get(randomNumber).click();
		
		return new ComputerPage(driver);
	}
}
