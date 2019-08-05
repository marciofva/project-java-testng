package com.herokuapp.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import java.util.List;
import org.testng.annotations.Test;
import com.herokuapp.dataprovider.DataProvider_UpdateComputer;
import com.herokuapp.page.ComputerPage;
import com.herokuapp.page.SearchPage;

public class UpdateComputerTest extends BaseTest{
	
	private ComputerPage computer;
	
	@Test(groups="regression", dataProviderClass = DataProvider_UpdateComputer.class, dataProvider = "updateAllData")
	public void updateAllData(String name, String introduced_date, String discontinued_date, String company) {
		
		String formatted_name = concatenateRandomNumberInCompanyName(name);
		
		search.selectRandomItem()
		.fillOutAllComputerForm(formatted_name, introduced_date, discontinued_date, company)
		.clickOnSubmit();
		
		//check if the computer is returned after updating with an unique name
		assertThat(new SearchPage(driver).getAlertMessage(), is(equalTo("Done! Computer ".concat(formatted_name) + " has been updated")));
		assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	
		
		//access computer page again
		computer = search.selectFirstOption();
		
		//check if all fields are updated 
		assertThat(computer.getComputerName(), is(equalTo(formatted_name)));
		assertThat(computer.getIntroducedDate(), is(equalTo(introduced_date)));
		assertThat(computer.getDiscontinuedDate(), is(equalTo(discontinued_date)));
		assertThat(computer.getCompanyName(), is(equalTo(company)));
	}
	
	
	@Test(groups="regression", dataProviderClass = DataProvider_UpdateComputer.class, dataProvider = "onlyComputerName")
	public void updateComputerName(String name)  {
		
		String formatted_name = concatenateRandomNumberInCompanyName(name);
		
		search.selectRandomItem()
		.fillComputerName(formatted_name)
		.clickOnSubmit();
		
		//check if the computer is returned after updating with an unique name
		assertThat(new SearchPage(driver).getAlertMessage(), is(equalTo("Done! Computer ".concat(formatted_name) + " has been updated")));
		assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	
		
		//access computer page again
		computer = search.selectFirstOption();
		
		//check if the field is updated
		assertThat(computer.getComputerName(), is(equalTo(formatted_name)));
	}
	
	
	@Test(groups="regression", dataProviderClass = DataProvider_UpdateComputer.class, dataProvider = "updateComputerNameAndIntroducedDate")
	public void updateComputerNameAndIntroducedDate(String name, String introduced_date)  {
		
		String formatted_name = concatenateRandomNumberInCompanyName(name);
		
		search.selectRandomItem()
		.fillComputerName(formatted_name)
		.fillIntroducedDate(introduced_date)
		.clickOnSubmit();
		
		//check if the computer is returned after updating with an unique name
		assertThat(new SearchPage(driver).getAlertMessage(), is(equalTo("Done! Computer ".concat(formatted_name) + " has been updated")));
		assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	
		
		//access computer page again
		computer = search.selectFirstOption();
		
		//check if the fields are updated
		assertThat(computer.getComputerName(), is(equalTo(formatted_name)));
		assertThat(computer.getIntroducedDate(), is(equalTo(introduced_date)));
	}
	

	@Test(groups="regression", dataProviderClass = DataProvider_UpdateComputer.class, dataProvider = "updateComputerNameAndDiscontinuedDate")
	public void updateComputerNameAndDiscontinuedDate(String name, String discontinued_date) throws InterruptedException {
		
		String formatted_name = concatenateRandomNumberInCompanyName(name);
		
		search.selectRandomItem()
		.fillComputerName(formatted_name)
		.fillDiscontinuedDate(discontinued_date)
		.clickOnSubmit();
		
		//check if the computer is returned after updating with an unique name
		assertThat(new SearchPage(driver).getAlertMessage(), is(equalTo("Done! Computer ".concat(formatted_name) + " has been updated")));
		assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	
		
		//access computer page again
		computer = search.selectFirstOption();
		
		//check if the fields are updated
		assertThat(computer.getComputerName(), is(equalTo(formatted_name)));
		assertThat(computer.getDiscontinuedDate(), is(equalTo(discontinued_date)));
	}
	

	@Test(groups="regression", dataProviderClass = DataProvider_UpdateComputer.class, dataProvider = "updateComputerNameAndCompany")
	public void updateComputerNameAndCompany(String name, String company)  {
		
		String formatted_name = concatenateRandomNumberInCompanyName(name);
		
		search.selectRandomItem()
		.fillComputerName(formatted_name)
		.fillCompany(company)
		.clickOnSubmit();
		
		//check if the computer is returned after updating with an unique name
		assertThat(new SearchPage(driver).getAlertMessage(), is(equalTo("Done! Computer ".concat(formatted_name) + " has been updated")));
		assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	
		
		//access computer page again
		computer = search.selectFirstOption();
		
		//check if the fields are updated
		assertThat(computer.getComputerName(), is(equalTo(formatted_name)));
		assertThat(computer.getCompanyName(), is(equalTo(company)));
	}


	@Test(groups="unsuccessful", dataProviderClass = DataProvider_UpdateComputer.class, dataProvider = "emptyName")
	public void updateWithEmptyComputerName(String name)  {
		
		List<String> listAlertMessages = search.selectRandomItem()
											.fillComputerName(name)
											.clickOnSubmit()
											.getAlertMessages();
		
		 assertThat(listAlertMessages, hasItem("Computer name Required"));
		 assertThat(listAlertMessages, hasSize(1));	 		
	}
	

	@Test(groups="unsuccessful", dataProviderClass = DataProvider_UpdateComputer.class, dataProvider = "invalidIntroducedDate")
	public void updateWithInvalidIntroducedDate(String introduced_date)  {
		
		List<String> listAlertMessages = search.selectRandomItem()
											.fillIntroducedDate(introduced_date)
											.clickOnSubmit()
											.getAlertMessages();
		
		  assertThat(listAlertMessages, hasItem("Introduced date Date ('yyyy-MM-dd')"));
		  assertThat(listAlertMessages, hasSize(1));	   		
	}
	

	@Test(groups="unsuccessful", dataProviderClass = DataProvider_UpdateComputer.class, dataProvider = "invalidDiscontinuedDate")
	public void updateWithInvalidDiscontinuedDate(String discontinued_date)  {
		
		List<String> listAlertMessages = search.selectRandomItem()
											.fillDiscontinuedDate(discontinued_date)
											.clickOnSubmit()
											.getAlertMessages();
		
		  assertThat(listAlertMessages, hasItem("Discontinued date Date ('yyyy-MM-dd')"));
		  assertThat(listAlertMessages, hasSize(1));	   		
	}
	
	
	@Test(groups="unsuccessful", dataProviderClass = DataProvider_UpdateComputer.class, dataProvider = "emptyName_InvalidIntroduceDate_InvalidDiscontinuedDate")
	public void updateWithEmptyName_InvalidIntroduceDate_InvalidDiscontinuedDate(String name, String introduced_date, String discontinued_date)  {
		
		List<String> listAlertMessages = search.selectRandomItem()
											.fillComputerName(name)
											.fillIntroducedDate(introduced_date)
											.fillDiscontinuedDate(discontinued_date)
											.clickOnSubmit()
											.getAlertMessages();
		
		  assertThat(listAlertMessages, hasItem("Computer name Required"));
		  assertThat(listAlertMessages, hasItem("Introduced date Date ('yyyy-MM-dd')"));
		  assertThat(listAlertMessages, hasItem("Discontinued date Date ('yyyy-MM-dd')"));
		  assertThat(listAlertMessages, hasSize(3));	   		
	}
}
