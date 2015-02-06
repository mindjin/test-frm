package com.sl.popup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.model.User;
import com.sl.pages.PageManager;

public class DvbtURL extends AnyPopup {

	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.url']")																
	protected WebElement row_url;
	
	public DvbtURL(PageManager pageManager) {
		super(pageManager);
		// TODO Auto-generated constructor stub
	}
	
	public DvbtURL setURL(String value){
	type(row_url, value);
	User.setNameForm(value);
	return this;
}
	
	public void close(){
		closePopup();
	}
	public void save(){
		savePopup();
	}
	public void create(){
		addPopup();
	}

}
