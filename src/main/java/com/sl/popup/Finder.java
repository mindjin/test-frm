package com.sl.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.pages.PageManager;

public class Finder extends AnyPopup {

	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.name']")																
	protected WebElement row_name;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@class='btn pull-right']")																
	protected WebElement btnCreate;
	
	@FindBy(xpath="//*[@additional-view][last()]//*[@class='slider container-fluid in']/button")
	protected WebElement openFilter;
	
	public Finder(PageManager pageManager) {
		super(pageManager);		
	}
	
	public Finder setName(String value){
		if(row_name.isDisplayed())
			type(row_name, value);
		else{
			openFilter();
		}
		return this;
	}
	public void clickCreate(){
		btnCreate.click();
		decPopup();
	}
	private Finder openFilter(){
		openFilter.click();
		return this;
	}	
	public Finder selectExistValue(String value){
		driver.findElement(By.cssSelector("[value='row.name'][title='"+value+"'] a")).click();
		decPopup();
		
		return this;
		
	}

}
