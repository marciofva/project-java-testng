package com.herokuapp.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComputerPage extends BasePage{

	private By inputName = By.id("name");
	private By inputIntroducedDate = By.id("introduced");
	private By inputDiscontinuedDate = By.id("discontinued");
	
	private By dropboxCompany = By.id("company");
	
	private By warningAlert = By.cssSelector("#main > form > fieldset > div.clearfix.error");
	
	private By btnSubmit = By.cssSelector("input[type='submit']");
	private By btnDelete = By.cssSelector("input.btn.danger");
	
	public ComputerPage(WebDriver driver) {
		super(driver);
	}
	
	public ComputerPage fillOutAllComputerForm(String name, String introduced_date, String discontinued_date, String company) {
		send(inputName, name);
		send(inputIntroducedDate, introduced_date);
		send(inputDiscontinuedDate, discontinued_date);
		selectDropBox(dropboxCompany, company);
		return this;
	}
	
	public ComputerPage fillComputerName(String name) {
		send(inputName, name);
		return this;
	}
	
	public ComputerPage fillIntroducedDate(String introduced_date) {
		send(inputIntroducedDate, introduced_date);
		return this;
	}
	
	public ComputerPage fillDiscontinuedDate(String discontinued_date) {
		send(inputDiscontinuedDate, discontinued_date);
		return this;
	}
	
	public ComputerPage fillCompany(String company) {
		selectDropBox(dropboxCompany, company);
		return this;
	}
	
	public ComputerPage clickOnSubmit() {
		clickOn(btnSubmit);
		return this;
	}
	
	public SearchPage clickOnDelete() {
		clickOn(btnDelete);
		return new SearchPage(driver);
	}
	
	public List<String> getAlertMessages() {
		
		List<WebElement> elements = getManyElements(warningAlert);
		List<String> list = new ArrayList<String>();
				
		for(WebElement element : elements) {
			list.add(element.getAttribute("innerText").replace("\n", ""));
		}
		return list;
	}
	
	public String getComputerName() {
		return getElement(inputName).getAttribute("value");
	}
	
	public String getIntroducedDate() {
		return getElement(inputIntroducedDate).getAttribute("value");
	}
	
	public String getDiscontinuedDate() {
		return getElement(inputDiscontinuedDate).getAttribute("value");
	}
	
	public String getCompanyName() {
		return getSelectedOptionOnCompany(dropboxCompany).getText();
	}
}
