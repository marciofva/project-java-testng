package com.herokuapp.test;

import org.testng.annotations.Test;
import com.herokuapp.dataprovider.DataProvider_ReadComputer;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class ReadComputerTest extends BaseTest{

	@Test(groups="regression", dataProviderClass = DataProvider_ReadComputer.class, dataProvider = "showOnlyOnePage")
	public void showLessThan10Items(String inputText) {		
		assertThat(Integer.valueOf(search.fillSearchField(inputText).clickOnSearchBtn().getNumberOfComputerFound()), is(lessThanOrEqualTo(10)));	    
  }
	
	
	@Test(groups="regression", dataProviderClass = DataProvider_ReadComputer.class, dataProvider = "showOneItem")
	public void showOnlyOneItem(String inputText) {		
			assertThat(search.fillSearchField(inputText).clickOnSearchBtn().getNumberOfComputerFound(), is(equalToIgnoringCase("One")));	    
   }
	
	
	@Test(groups="regression", dataProviderClass = DataProvider_ReadComputer.class, dataProvider = "noComputersFound")
	public void NoComputersFound(String inputText) {		
			assertThat(search.fillSearchField(inputText).clickOnSearchBtn().getMessageForNoResultFound(), is(equalToIgnoringCase("Nothing to display")));	    
	}

	
	@Test(groups="regression", dataProviderClass = DataProvider_ReadComputer.class, dataProvider = "showMoreThan10Items")
	public void paginateToNextPageAndPreviousPage(String inputText) {		
		assertThat(Integer.valueOf(search.fillSearchField(inputText).clickOnSearchBtn().goToNextPage().getNumberOfComputerFound()), is(greaterThanOrEqualTo(1)));	
		assertThat(Integer.valueOf(search.returnToPreviousPage().getNumberOfComputerFound()), is(greaterThan(10)));	
	}
}
