package com.sl.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sl.utils.JavaScripts;
import com.sl.utils.WaitForElement;
import com.sl.utils.WindowsStatus;

public abstract class Page {
	
	protected WebDriver driver;
	protected PageManager pageManager;
	protected JavaScripts js;
	protected WaitForElement wfe;
	
	public WindowsStatus ws;
	
	
	public Page(PageManager pageManager){
		
		this.pageManager = pageManager;
		driver = pageManager.getWebDriver();
		wfe = new WaitForElement(driver);
		js = new JavaScripts(driver);
		ws = WindowsStatus.getInstance();
		
	}
	
	public void type(WebElement webElement, String text){		
		webElement.clear();
		webElement.sendKeys(text);
	}
	
	
	public WebDriver getWebDriver(){
		return driver;
	}	
	

	public Page incPopup(){
		ws.incPC();
		wfe.waitForAddPopup(ws.getPC());
		return this;
	}

	public Page decPopup(){
		ws.decPC();
//		wfe.waitForClosePopup(ws.getPC());
		return this;
	
	}
	
	public void insideTab(WebElement element){
		
		try{
			if(!element.isDisplayed()){				
				List<WebElement> tabs = driver.findElements(By.cssSelector("ul[class='nav nav-tabs']>li"));
				for(WebElement tab : tabs){
					System.out.println("Element not visible. Get next TAB for search:");
					if(tab.isDisplayed())
					tab.click();
					if(element.isDisplayed())
						break;
				}
			 }
			
		}catch(Exception e) {
			
		}		
		
	}
	

	
}
