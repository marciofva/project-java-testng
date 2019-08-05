package com.herokuapp.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import org.testng.annotations.Test;
import com.herokuapp.dataprovider.DataProvider_DeleteComputer;
import com.herokuapp.page.SearchPage;

public class DeleteComputerTest extends BaseTest{
	
	private static final String	SUCCESS_DELETE_MESSAGE	= "Done! Computer has been deleted";
	
  @Test(groups="regression", invocationCount = 2)
  public void deleteRandomComputer() {
	  assertThat(search.selectFirstOption().clickOnDelete().getAlertMessage(), is(equalTo(SUCCESS_DELETE_MESSAGE)));
  }
  
  @Test(groups="regression", dataProviderClass = DataProvider_DeleteComputer.class, dataProvider = "addItemToDelete")
  public void deleteSpecificComputer(String name) {
	  
	  String formatted_name = concatenateRandomNumberInCompanyName(name);
	  search.addNewComputer()
			.fillComputerName(formatted_name)
			.clickOnSubmit();
	  
	  //Check delete message
	  assertThat(new SearchPage(driver).fillSearchField(formatted_name).clickOnSearchBtn().selectFirstOption().clickOnDelete().getAlertMessage(), is(equalTo(SUCCESS_DELETE_MESSAGE)));
	  
	//Check if the computer has been deleted by searching it again
	  assertThat(search.fillSearchField(formatted_name).clickOnSearchBtn().getMessageForNoResultFound(), is(equalToIgnoringCase("Nothing to display")));	    
  }
  
  
  @Test(groups="regression")
  public void deleteComputerFromNextPage() {
	  assertThat(search.goToNextPage().selectFirstOption().clickOnDelete().getAlertMessage(), is(equalTo(SUCCESS_DELETE_MESSAGE)));
  }
}
