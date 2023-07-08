package com.actitime.testscript;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;

@Listeners(com.actitime.generic.ListenerImplement.class)
public class CustomerModule extends BaseClass {
	
@Test
public void CreateCustomer() {
	Reporter.log("Create Customer", false);
}

}
