package com.herokuapp.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProvider_UpdateComputer {
	
	@DataProvider(name = "updateAllData")
	public static Object[][] updateAllData() {
		return new Object[][] {{"game mario bros", "1996-08-04", "2022-12-25", "Nintendo"}};
	}
	
	@DataProvider(name = "onlyComputerName")
	public static Object[][] updateComputerName() {
		return new Object[][] {{"game mario bros"}};
	}
	
	@DataProvider(name = "updateComputerNameAndIntroducedDate")
	public static Object[][] updateComputerNameAndIntroducedDate() {
		return new Object[][] {{"game mario bros", "2019-05-21"}};
	}
	
	@DataProvider(name = "updateComputerNameAndDiscontinuedDate")
	public static Object[][] updateComputerNameAndDiscontinuedDate() {
		return new Object[][] {{"game mario bros", "2025-10-19"}};
	}
	
	@DataProvider(name = "updateComputerNameAndCompany")
	public static Object[][] updateComputerNameAndCompany() {
		return new Object[][] {{"White Notebook", "IBM"}};
	}
	
	@DataProvider(name = "emptyName")
	public static Object[][] emptyName() {
		return new Object[][] {{"  "}};
	}
	
	@DataProvider(name = "invalidDiscontinuedDate")
	public static Object[][] invalidDiscontinuedDate() {
		return new Object[][] {{"20170503"},
							   {"12345678"},
							   { "        "},
							   {"abdcfty4"}};
	}
	
	@DataProvider(name = "invalidIntroducedDate")
	public static Object[][] invalidIntroducedDate() {
		return new Object[][] {{"20170503"},
							   {"12345678"},
							   { "        "},
							   {"abdcfty4"}};
	}
	
	@DataProvider(name = "emptyName_InvalidIntroduceDate_InvalidDiscontinuedDate")
	public static Object[][] emptyName_InvalidIntroduceDate_InvalidDiscontinuedDate() {
		return new Object[][] {{"  ", "19840521", "abdcs"}};
	}
}
