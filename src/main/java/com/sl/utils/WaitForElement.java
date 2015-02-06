package com.sl.utils;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Класс использует методы для ожидания событий
 */
public class WaitForElement{


	protected WebDriver driver;
	

	public WaitForElement(WebDriver driver) {
	this.driver = driver;	
	}

	public void waitElementsClickable(WebElement waitOfElement){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(waitOfElement));
		
	}
	
	public void waitEnableButton(WebElement element){	
		
			for(int i = 0; i<10; i++){
				String atr = element.getAttribute("disabled");
				if(!(atr==null)){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else{
					break;
				}			
		}
	}
	
	public void waitElementsVisible(WebElement waitOfElement){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(waitOfElement));
		
	}
	
	public void waitHomePage(){
		(new WebDriverWait(driver, 10)).until(presenceOfElementLocated(By.id("ListFilters")));
	}
	
	public void waitForm(){
		(new WebDriverWait(driver, 10)).until(presenceOfElementLocated(By.id("RowForm")));
	}
	
	public boolean waitForAddPopup(int getPC){
		try{
			waitElementsVisible(driver.findElement(By.cssSelector("[additional-view='"+getPC+"']")));
			return true;
		}catch(Exception e){
			System.out.println("Popup "+getPC+" is not open");
			return false;
		}		
	}
	
	public void waitForClosePopup(int getPC){
		int a =getPC+1;
		if(a>=0){
			
		}
		
	}
	
}
