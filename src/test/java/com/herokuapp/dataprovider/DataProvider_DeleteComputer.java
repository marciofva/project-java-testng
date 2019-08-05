package com.herokuapp.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProvider_DeleteComputer {

	@DataProvider(name = "addItemToDelete")
	public static Object[][] addItemToDelete() {
		return new Object[][] {{"Computer to Delete"}};
	}
}
