package com.sl.popup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.pages.PageManager;

public class Delete extends AnyPopup{
	
	@FindBy(css="[additional-view='0'] [class='btn']")															
	protected WebElement no;

	@FindBy(css="[additional-view='0'] [class='btn btn-danger']")															
	protected WebElement yes;
	
	
	public Delete(PageManager pageManager) {
		super(pageManager);		
	}
	
	
	public void clickNo(){
		wfe.waitElementsClickable(no);
		no.click();
	}
	public void clickYes(){
		wfe.waitElementsClickable(yes);
		yes.click();
	}

}
