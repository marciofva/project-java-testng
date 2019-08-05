package com.herokuapp.test;

import org.testng.annotations.Test;
import com.herokuapp.dataprovider.DataProvider_CreateComputer;
import com.herokuapp.page.SearchPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import java.util.List;

public class CreateComputerTest extends BaseTest{
	
  @Test(groups="regression", dataProviderClass = DataProvider_CreateComputer.class, dataProvider = "validComputerData")
  public void addNewItemFillingAllData(String name, String introduced_date, String discontinued_date, String company) {
	  
	  String formatted_name = concatenateRandomNumberInCompanyName(name);
	  
	  search.addNewComputer()
			.fillOutAllComputerForm(formatted_name, introduced_date, discontinued_date, company)
			.clickOnSubmit();
	  	  
	  assertThat(new SearchPage(driver).getAlertMessage(), is(equalTo("Done! Computer ".concat(formatted_name) + " has been created")));
	  assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	    
  }
  
  
  @Test(groups="regression", dataProviderClass = DataProvider_CreateComputer.class, dataProvider = "onlyComputerName")
  public void addNewItemInputtingComputerName(String name) {
	  
	  String formatted_name = concatenateRandomNumberInCompanyName(name);
	  
	  search.addNewComputer()
			.fillComputerName(formatted_name)
			.clickOnSubmit();
	  
	  assertThat(new SearchPage(driver).getAlertMessage(), is(equalTo("Done! Computer ".concat(formatted_name) + " has been created")));
	  assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	    
  }
  
  
  @Test(groups="regression", dataProviderClass = DataProvider_CreateComputer.class, dataProvider = "validComputerNameAndIntroducedDate")
  public void addNewItemInputtingComputerNameAndIntroducedDate(String name, String introduced_date) {
	  
	  String formatted_name = concatenateRandomNumberInCompanyName(name);
	  
	  search.addNewComputer()
			.fillComputerName(formatted_name)
			.fillIntroducedDate(introduced_date)
			.clickOnSubmit();
	  
	  assertThat(new SearchPage(driver).getAlertMessage(), is(equalTo("Done! Computer ".concat(formatted_name) + " has been created")));
	  assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	    
  }
  
  
  @Test(groups="regression", dataProviderClass = DataProvider_CreateComputer.class, dataProvider = "validComputerNameAndDiscontinuedDate")
  public void addNewItemInputtingComputerNameAndDiscontinuedDate(String name,  String discontinued_date) {
	  
	  String formatted_name = concatenateRandomNumberInCompanyName(name);
	  
	  search.addNewComputer()
			.fillComputerName(formatted_name)
			.fillDiscontinuedDate(discontinued_date)
			.clickOnSubmit();
	  
	  assertThat(new SearchPage(driver).getAlertMessage(), is(equalTo("Done! Computer ".concat(formatted_name) + " has been created")));
	  assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	    
  }
  
  
  @Test(groups="regression", dataProviderClass = DataProvider_CreateComputer.class, dataProvider = "validComputerNameAndCompany")
  public void addNewItemInputtingComputerNameAndCompany(String name, String company) {
	  
	  String formatted_name = concatenateRandomNumberInCompanyName(name);
	  
	  search.addNewComputer()
			.fillComputerName(formatted_name)
			.fillCompany(company)
			.clickOnSubmit();
	  
	  assertThat(new SearchPage(driver).getAlertMessage(), is(equalTo("Done! Computer ".concat(formatted_name) + " has been created")));
	  assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	    
  }

  
  @Test(groups="unsuccessful", dataProviderClass = DataProvider_CreateComputer.class, dataProvider = "emptyComputerName")
  public void enterEmptyComputerName(String introduced_date, String discontinued_date, String company) {
	  
	  List<String> listAlertMessages =  search.addNewComputer()
					  						.fillIntroducedDate(introduced_date)
					  						.fillDiscontinuedDate(discontinued_date)
					  						.fillCompany(company)
					  						.clickOnSubmit()
					  						.getAlertMessages();
	  
	  assertThat(listAlertMessages, hasItem("Computer name Required"));
	  assertThat(listAlertMessages, hasSize(1));	    
  }
  
  
  @Test(groups="unsuccessful",dataProviderClass = DataProvider_CreateComputer.class, dataProvider = "invalidIntroducedDate")
  public void enterInvalidIntroducedDate(String name, String introduced_date, String discontinued_date, String company) {
	  
	  List<String> listAlertMessages =  search.addNewComputer()
					  						.fillOutAllComputerForm(name, introduced_date, discontinued_date, company)
					  						.clickOnSubmit()
					  						.getAlertMessages();
	  
	  assertThat(listAlertMessages, hasItem("Introduced date Date ('yyyy-MM-dd')"));
	  assertThat(listAlertMessages, hasSize(1));	    
  }
  
  
  @Test(groups="unsuccessful",dataProviderClass = DataProvider_CreateComputer.class, dataProvider = "invalidDiscontinuedDate")
  public void enterInvalidDiscontinuedDate(String name, String introduced_date, String discontinued_date, String company) {
	  
	  List<String> listAlertMessages =  search.addNewComputer()
					  						.fillOutAllComputerForm(name, introduced_date, discontinued_date, company)
					  						.clickOnSubmit()
					  						.getAlertMessages();
	  
	  assertThat(listAlertMessages, hasItem("Discontinued date Date ('yyyy-MM-dd')"));
	  assertThat(listAlertMessages, hasSize(1));	    
  }
  
  
  @Test(groups="unsuccessful",dataProviderClass = DataProvider_CreateComputer.class, dataProvider = "emptyName_InvalidIntroduceDate_InvalidDiscontinuedDate")
  public void enterInvalid_Name_Introduce_Discontinued(String name, String introduced_date, String discontinued_date, String company) {
	  
	  List<String> listAlertMessages =  search.addNewComputer()
					  						.fillOutAllComputerForm(name, introduced_date, discontinued_date, company)
					  						.clickOnSubmit()
					  						.getAlertMessages();
	  
	  assertThat(listAlertMessages, hasItem("Computer name Required"));
	  assertThat(listAlertMessages, hasItem("Introduced date Date ('yyyy-MM-dd')"));
	  assertThat(listAlertMessages, hasItem("Discontinued date Date ('yyyy-MM-dd')"));
	  assertThat(listAlertMessages, hasSize(3));	    
	}
}
