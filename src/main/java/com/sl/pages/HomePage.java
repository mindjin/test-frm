package com.sl.pages;
import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Page{
	
	@FindBy(css="[href='PromoContent/list']")
	protected WebElement promoContent;
	@FindBy(css="[href='PromoSchedule/list']")
	protected WebElement promoSchedule;
	@FindBy(css="[href='PromoInterfaceId/list']")
	protected WebElement promoInterfaceId;
	@FindBy(css="[href='InterfaceMenuItem/list']")
	protected WebElement interfaceMenuItem;
	@FindBy(css="[href='PromoAction/list']")
	protected WebElement promoAction;
	@FindBy(css="[href='Karaoke/list']")
	protected WebElement karaoke;
	@FindBy(css="[href='BroadcastChannel/list']")
	protected WebElement broadcastChannel;
	@FindBy(css="[href='VideoMovie/list']")
	protected WebElement videoMovie;
	@FindBy(css="[href='VodPackage/list']")
	protected WebElement vodPackage;
	
	@FindBy(css="[id='ListFilters'] [id='row.name']")
	protected WebElement name;	
	@FindBy(css="[class='btn btn-primary'][ng-click='refresh()']")
	protected WebElement refresh;
	@FindBy(css="[class='btn btn-primary'][ng-click='onCopyRow()']")
	protected WebElement copy;
	@FindBy(css="[class='btn btn-primary'][ng-click='addRow()']")																	
	protected WebElement addCard;	
	@FindBy(css="[class='btn btn-primary'][ng-click='switchBulkMode(!bulkMode)']")																	
	protected WebElement bulkMode;	
	
	public HomePage(PageManager pageManager) {
		super(pageManager);
		
	}	
	
	public enum Menu{
		KARAOKE("karaoke"),
		PROMOACTIONS("promoAction"),
		PROMOCONTENT("promoContent"),
		PROMOSHEDULE("promoSchedule"),
		PROMOINTERFACEID("promoInterfaceId"),
		INTERFACEMENUITEM("interfaceMenuItem"),
		BROADCASTCHANNEL("broadcastChannel"),
		VIDEOMOVIE("videoMovie"),
		VODPACKAGE("vodPackage");
		Menu(String text){
			this.text = text;
		}
		public String text;
		
	}	
	
	
	public HomePage setName(String value){
		type(name, value);
		return this;		
	}	
	public void openExistValue(String value){
		driver.findElement(By.cssSelector("[title='"+value+"'] a")).click();
		
	}
	public HomePage refresh(){
		refresh.click();
		return this;		
	}
	public HomePage selectExistValue(String value){
		driver.findElement(By.xpath("//*[@id='ListTableContainer']//tr[descendant::td[@title='"+value+"']]/td[@class='column-bool']")).click();
		return this;
	}
	public void clickCopy(){
		copy.click();		
	}


	public void addForm() {
		addCard.click();
		
	}
	
	
	 public HomePage clickPage(Menu menu){
			Field[] allFields = this.getClass().getDeclaredFields();			
			for(Field field : allFields){
				 
				 if(field.getName().equals(menu.text)){
					 WebElement element = null;
					 try {
						element = (WebElement) field.get(this);						
						js.clickOnInvisibleElement(element);
						System.out.println("");
						if(isAlertPresent())
							driver.switchTo().alert().accept();
						return this;
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
					 
				 
				 
			 	}
			} 
			return  this;
		}
	 
	 public HomePage ensurePageLoaded(){		 
		 wfe.waitHomePage();
		 return this;
	 }
	 
	 private boolean isAlertPresent() 
	 { 
	     try 
	     { 	        
	    	 driver.switchTo().alert(); 
	         return true; 
	     }   
	     catch (NoAlertPresentException Ex) 
	     { 
	         return false; 
	     }  
	 }


	
}
