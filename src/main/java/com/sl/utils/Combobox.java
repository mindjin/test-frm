package com.sl.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sl.pages.Page;
import com.sl.pages.PageManager;


/**
 * Класс для работы с combobox
 *
 */
public class Combobox extends Page{	
	
	
	private WebElement element;
	public Combobox(PageManager pageManager, WebElement element){
		super(pageManager);
		this.element = element;
		insideTab(element);
	}
	
	public void findValue(String value) {													
		element.click();
		driver.findElement(By.cssSelector("[id='select2-drop'] input")).sendKeys(value);										
		driver.findElement(By.xpath("//div/span[@class='select2-match'][normalize-space(text())='"+value+"']")).click();		
	}	

}
