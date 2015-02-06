package com.sl.popup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.model.User;
import com.sl.pages.PageManager;

public class Subtitles extends AnyPopup {

	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.name']")																
	protected WebElement row_name;	
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.PID']")																
	protected WebElement row_PID;
	
	@FindBy (xpath="//*[@additional-view][last()]//input[@id='row.teletextPage']")																
	protected WebElement row_teletextPage;
	
	@FindBy (xpath="//*[@additional-view][last()]//section[@name='row.__states.Locations']")																//*
	protected WebElement states_Locations;
	
	public Subtitles(PageManager pageManager) {
		super(pageManager);		
	}
	
	public void create(){		
		addPopup();
	}
	public void close(){
		closePopup();
	}

	public Subtitles setName(String value) {
		type(row_name, value);
		User.setNameForm(value);
		return this;
	}

	public void save() {
		savePopup();	
	}

	public Subtitles setPID(String value) {
		type(row_PID, value);
		return this;
	}
	
	public Subtitles setTeletext(String value){
		type(row_teletextPage, value);
		return this;
	}
	
	public Subtitles setLocations(String value) {
		pageManager.getList2List(states_Locations).addValue(value);
		return this;
	}

}
