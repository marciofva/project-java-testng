package com.herokuapp.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProvider_ReadComputer {

	@DataProvider(name = "showOnlyOnePage")
	public static Object[][] showOnlyOnePage() {
		return new Object[][] {{"ACE"}};
	}
	
	@DataProvider(name = "showOneItem")
	public static Object[][] showOneItem() {
		return new Object[][] {{"nintendo 64"}};
	}
	
	@DataProvider(name = "noComputersFound")
	public static Object[][] noComputersFound() {
		return new Object[][] {{"123"}};
	}
	
	@DataProvider(name = "showMoreThan10Items")
	public static Object[][] showMoreThan10Items() {
		return new Object[][] {{"machine"}};
	}
}
