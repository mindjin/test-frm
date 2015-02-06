package com.sl.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.model.User;
import com.sl.pages.PageManager;

public class Assets extends AnyPopup{

	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.internalFileName']")																
	protected WebElement row_name;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.smExternalId']")																
	protected WebElement row_smExternalId;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='s2id_row.assetType']//span")																
	protected WebElement row_assetType;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.bitrate']")																
	protected WebElement row_bitrate;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.containerType']")																
	protected WebElement row_containerType;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.duration']//input")																
	protected WebElement row_durationTime;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='s2id_row.status']//span")																
	protected WebElement row_status;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='s2id_row.priority']//span")																
	protected WebElement row_priority;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.isCrypted']")																
	protected WebElement row_isCrypted;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='row.isDeleted']")																
	protected WebElement row_isDeleted;
	
	@FindBy (xpath="//*[@additional-view][last()]//*[@id='s2id_row.transport']//span")																
	protected WebElement row_transport;
	
	@FindBy (xpath="//*[@additional-view][last()]//section[@name='row.__states.AvalabiltyOnVideoServers']")																//*
	protected WebElement states_AvalabiltyOnVideoServers;
	
	@FindBy (xpath="//*[@additional-view][last()]//section[@name='row.__states.ContentAudioPIDs']")																//*
	protected WebElement states_ContentAudioPIDs;
	
	public Assets(PageManager pageManager) {
		super(pageManager);		
	}
	
	public Assets setName(String value) {
		type(row_name, value);
		User.setNameForm(value);
		return this;
	}
	
	
	public AudioPID addAudioPID() {
		pageManager.getLinkedID(states_ContentAudioPIDs).add();
		return pageManager.audioPID;
	}
		
	public AudioPID openAudioPID(String value) {
		pageManager.getLinkedID(states_ContentAudioPIDs).openValue(value);
		return pageManager.audioPID;
	}
	public void close() {
		closePopup();
	}
	
	public void save(){
		savePopup();
	}
	public void create(){
		addPopup();
	}

}
