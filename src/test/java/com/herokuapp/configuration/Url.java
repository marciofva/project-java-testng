package com.herokuapp.configuration;

public enum Url {

	DEFAULT_WEB_SITE("http://computer-database.herokuapp.com/computers");

	public String value;

	Url(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
