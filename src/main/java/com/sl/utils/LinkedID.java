package com.sl.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sl.pages.Page;
import com.sl.pages.PageManager;
/**
 * Класс реализует методы для работы с linkedID 
 */
public class LinkedID extends Page{

	
	WebElement element;
	public LinkedID(PageManager pageManager, WebElement element) {
		super(pageManager);
		this.element = element;
		insideTab(element);
	}
	
	public void openValue(String value){
		element.findElement(By.cssSelector("[title='"+value+"'] a")).click();
		incPopup();
	}
	
	public void add(){		
		element.findElement(By.cssSelector("[ng-click='onAddRow()']")).click();
		incPopup();
	}

}
