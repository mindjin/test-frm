package com.sl.popup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.model.User;
import com.sl.pages.PageManager;
import com.sl.utils.Length;

public class OttURL extends AnyPopup {

	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.url']")																
	protected WebElement row_url;
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.externalId']")																
	protected WebElement row_externalId;
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='s2id_row.location']//span")																
	protected WebElement row_location;
	@Length(24)
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.epgOffset']")																
	protected WebElement row_epgOffset;
	
	
	public OttURL(PageManager pageManager) {
		super(pageManager);		
	}
	
	public OttURL setURL(String value){
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
