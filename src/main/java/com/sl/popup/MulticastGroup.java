package com.sl.popup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.model.User;
import com.sl.pages.PageManager;

public class MulticastGroup extends AnyPopup {
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.url']")																
	protected WebElement row_url;
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.hqUrl']")																
	protected WebElement row_hqUrl;
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.backupUrl1']")																
	protected WebElement row_backupUrl1;
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.backupUrl2']")																
	protected WebElement row_backupUrl2;
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.plcUrl']")																
	protected WebElement row_plcUrl;
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.pipUrl']")																
	protected WebElement row_pipUrl;
//	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.bitrate']")																
//	protected WebElement row_bitrate;
	@FindBy (xpath="//*[@additional-view][last()]//input[@id='row.nPVRChannelID']")																
	protected WebElement row_nPVRChannelID;
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.externalId']")																
	protected WebElement row_externalId;
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='s2id_row.location']//span")																
	protected WebElement row_location;
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.viewPVRChannelID']")																
	protected WebElement row_viewPVRChannelID;
	@FindBy (xpath="//*[@additional-view][last()]//section[@name='row.__states.SmartRecorders']")																//*
	protected WebElement states_smartRecorders;
	
	public MulticastGroup(PageManager pageManager) {
		super(pageManager);		
	}
	
	public MulticastGroup setURL(String value){
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
