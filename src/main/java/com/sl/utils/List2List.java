package com.sl.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sl.pages.Page;
import com.sl.pages.PageManager;

/**
 * Класс реализует функционал работы с list2list
 */
public class List2List extends Page{
	
	protected WebElement element,leftFilter,rightFilter,listElement;	
	protected Actions actions;

	public List2List(PageManager pageManager, WebElement element) {
		super(pageManager);
		this.element = element;
		insideTab(element);
		leftFilter = element.findElement(By.cssSelector("input[ng-change='updateLeftFilter()']"));
		rightFilter = element.findElement(By.cssSelector("input[ng-change='updateRightFilter()']"));
		actions = new Actions(pageManager.getWebDriver());
	}	
		

	public void addAll(){
		element.findElement(By.cssSelector("[ng-click='addAll()']")).click();
	}
		
	public void deleteAll(){
		element.findElement(By.cssSelector("[ng-click='deleteAll()']")).click();
	}
	
	public void addValue(String value){
		
		
		type(leftFilter, value);
		listElement = element.findElement(By.xpath(".//td[normalize-space(.)='"+value+"']/input"));
		if(!listElement.isSelected())
			listElement.click();
	}
	
	public void deleteValue(String value){	
		
		type(rightFilter, value);		
		listElement = element.findElement(By.xpath(".//table[@id='rightListTable']//td[normalize-space(.)='"+value+"']"));
		actions.moveToElement(listElement).doubleClick().perform();
		}


	public boolean getLeftFilter(String value) {
		try{
		type(leftFilter, value);		
		listElement = element.findElement(By.xpath(".//td[normalize-space(.)='"+value+"']/input"));
		if(listElement.isSelected())
			return true;		
		}catch(Exception e){
			return false;
		}
			return false;
	}
	
	public boolean getRightFilter(String value) {
		try{
		type(rightFilter, value);
		listElement = element.findElement(By.xpath(".//table[@id='rightListTable']//td[normalize-space(.)='"+value+"']"));
		if(listElement.getText().equals(value))
			return true;
		}catch(Exception e){
			return false;
		}
			return false;
	}

}
