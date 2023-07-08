package com.actitime.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage {

	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewBtn;
	
	
}
