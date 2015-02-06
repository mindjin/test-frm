package com.sl.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScripts {
	
	
	JavascriptExecutor executor;																
	WebDriver driver;
	public JavaScripts(WebDriver driver) {	
		this.driver = driver;
		this.executor  = (JavascriptExecutor)driver;										
			
		}
	
	public void clickOnInvisibleElement(WebElement element) {
	    
	    String script = "var object = arguments[0];"
	            + "var theEvent = document.createEvent(\"MouseEvent\");"
	            + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
	            + "object.dispatchEvent(theEvent);"
	            ;
	         
	    executor.executeScript(script, element);
	}
	
	public void cleaningTabs(WebElement element){
		String script = "$('[form-tab] [ng-click=\"removeAll()\"],[ng-click=\"removeRow(row)\"]:visible').click();"; 
		executor.executeScript(script);
		
	}

}
