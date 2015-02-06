package com.sl.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс реализует запись в лог информации, а также реализована задержка для ajax запросов. Наследуется от AbstractWebDriverEventListener.
 */
public class WebDriverLogger extends AbstractWebDriverEventListener {
	public static final Logger log = LoggerFactory.getLogger(WebDriverLogger.class);
	
	
	@Override
    public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("WebDriver navigated to '" + url + "'");
		
    }
	
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {	
		log.info("WebDriver find By '" + by + "'");
		waitCounter(driver);
		  }
		 
		 
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
	        log.info("WebDriver changed value for element - "
	                            + elementDescription(element));
	   }
	    
	public void onException(Throwable throwable, WebDriver driver) {
	    	Writer writer = new StringWriter();
	    	PrintWriter error = new PrintWriter(writer);	    	
	    	throwable.printStackTrace(error);
	    	log.info(writer.toString());	    	
	    	((EventFiringWebDriver) driver).register(new WebDriverLogger());
	    	
	      }
	  
	private String elementDescription(WebElement element) {
	        String description = "tag:" + element.getTagName();
	        if (element.getAttribute("id") != null) {
	            description += " id: " + element.getAttribute("id");
	        }
	        else if (element.getAttribute("name") != null) {
	            description += " name: " + element.getAttribute("name");
	        } 
	        else if (element.getAttribute("ng-click") != null) {
	            description += " ng-click: " + element.getAttribute("ng-click");
	        } 
	         
	        description += " ('" + element.getAttribute("value") + "')";
	         
	        return description;
	    }
	
	private void waitCounter(WebDriver driver){
		(new WebDriverWait(driver, 25).ignoring(NoSuchElementException.class)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[request-count='0']")));	
	}
	
	
}
