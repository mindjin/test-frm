package com.sl.popup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.pages.PageManager;

public class ParamCopy extends AnyPopup {
	
	@FindBy (xpath="//*[@additional-view][last()]//div[@class='controls']/input")																
	protected WebElement param;
	
	@FindBy (xpath="//*[@additional-view][last()]//button[@ng-click='viewStackServices.popView()']")																
	protected WebElement close;
	
	@FindBy (xpath="//*[@additional-view][last()]//button[@ng-click='onCopyClick()']")																
	protected WebElement copy;

	public ParamCopy(PageManager pageManager) {
		super(pageManager);
	}
	
	public void close(){
		close.click();
	}
	public void clickParam(){		
		param.click();
	}
	public void clickCopyWithNewParam(){
		copy.click();		
	}
}
