package com.sl.popup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.model.User;
import com.sl.pages.PageManager;

public class AudioPID extends AnyPopup {
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.name']")																
	protected WebElement row_name;	
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.PID']")																
	protected WebElement row_PID;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='s2id_row.audioPIDType']//span")			
	protected WebElement row_audioPIDType;
	
	public AudioPID(PageManager pageManager) {
		super(pageManager);
	}
	
	public void create(){		
		addPopup();
	}
	public void close(){
		closePopup();
	}
	public void save() {
		savePopup();	
	}

	public AudioPID setName(String value) {
		type(row_name, value);
		User.setNameForm(value);
		return this;
	}

	public AudioPID setPID(String value) {
		type(row_PID, value);
		return this;
	}

}
