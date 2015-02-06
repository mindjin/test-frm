package com.sl.utils;

import org.openqa.selenium.WebElement;

import com.sl.pages.Page;
import com.sl.pages.PageManager;

/**
 * Класс необходимый в основном для метода fillForm
 *
 */
public class Checkbox extends Page {
	private WebElement element;
	public Checkbox(PageManager pageManager, WebElement element) {
		super(pageManager);		
		this.element = element;
		insideTab(element);
	}
	
public void editCheckbox(String value){
		
		if(element != null){
			
			if(value.equals("1"))
			{
				if(!element.isSelected()){
				
					element.click();
			}

			}
			if(value.equals("0"))
				if(element.isSelected())
				
					element.click();
		}
}

}
