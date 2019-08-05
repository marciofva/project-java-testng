package com.herokuapp.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProvider_CreateComputer {
	
	@DataProvider(name = "validComputerData")
	public static Object[][] validComputerData() {
		return new Object[][] {{"machine 2.0 power", "2019-05-21", "2019-09-16", "ASUS"}};
	}
	
	@DataProvider(name = "onlyComputerName")
	public static Object[][] onlyComputerName() {
		return new Object[][] {{"White Notebook"}};
	}
	
	@DataProvider(name = "validComputerNameAndIntroducedDate")
	public static Object[][] validComputerNameAndIntroducedDate() {
		return new Object[][] {{"White Notebook", "2019-05-21"}};
	}

	@DataProvider(name = "validComputerNameAndDiscontinuedDate")
	public static Object[][] validComputerDataAndDiscontinuedDate() {
		return new Object[][] {{"White Notebook", "2019-09-16"}};
	}
	
	@DataProvider(name = "validComputerNameAndCompany")
	public static Object[][] validComputerNameAndCompany() {
		return new Object[][] {{"Black Notebook", "IBM"}};
	}
	
	@DataProvider(name = "emptyComputerName")
	public static Object[][] emptyComputerName() {
		return new Object[][] {{"2018-11-10", "2019-09-16", "Sony"}};
	}
	
	@DataProvider(name = "invalidIntroducedDate")
	public static Object[][] invalidIntroducedDate() {
		return new Object[][] {{"notebook premium", "20170503", "2019-09-16", "Sony"},
							   {"notebook premium", "12345678", "2019-09-16", "Sony"},
							   {"notebook premium", "        ", "2019-09-16", "Sony"},
							   {"notebook premium", "abdcfty4", "2019-09-16", "Sony"}};
	}
	
	@DataProvider(name = "invalidDiscontinuedDate")
	public static Object[][] invalidDiscontinuedDate() {
		return new Object[][] {{"celular", "2019-03-19", "20171229", "Nokia"},
							   {"celular", "2019-03-19", "12345678", "Nokia"},
							   {"celular", "2019-03-19", "        ", "Nokia"},
							   {"celular", "2019-03-19", "kdld7pdf", "Nokia"}};
	}
	
	@DataProvider(name = "emptyName_InvalidIntroduceDate_InvalidDiscontinuedDate")
	public static Object[][] emptyName_InvalidIntroduceDate_InvalidDiscontinuedDate() {
		return new Object[][] {{"  ", "19840521", "abdcs", "Atari"}};
	}
}
