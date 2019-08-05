package com.herokuapp.page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver;
	private WebDriverWait wait;
	private static final int MAX_TIMEOUT = 15;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, MAX_TIMEOUT);
	}
	
	public WebElement getElement(By element) {
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return this.driver.findElement(element);
	}

	public List<WebElement> getManyElements(By element) {
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return driver.findElements(element);
	}

	public void send(By element, String text) {
		this.wait.until(ExpectedConditions.presenceOfElementLocated(element));
		this.getElement(element).clear();
		this.getElement(element).sendKeys(text);
	}

	public void clickOn(By element) {
		this.wait.until(ExpectedConditions.elementToBeClickable(element));
		this.getElement(element).click();
	}

	public void selectDropBox(By element, String search) {
		Select drp = new Select(driver.findElement(element));
		drp.selectByVisibleText(search);
	}
	
	public WebElement getSelectedOptionOnCompany(By element) {
		Select drp = new Select(driver.findElement(element));
		return  drp.getFirstSelectedOption();
	}
}
