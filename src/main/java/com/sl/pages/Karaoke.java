package com.sl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.model.User;
import com.sl.popup.Assets;
import com.sl.popup.AssetsOTT;



public class Karaoke extends AnyForm{
	
	@FindBy(css = "[id='RowForm'] [id='row.name']")
	protected WebElement row_name;
	
	@FindBy(css = "[id='RowForm'] section[name='row.__states.Locations']")
	protected  WebElement states_Locations;
	
//	@FindBy(css = "section[name='row.__states.Genres']")
//	  WebElement states_Genres;
	
	@FindBy(css = "[id='RowForm'] section[name='row.__states.KaraokePackages']")
	protected  WebElement states_KaraokePackages;
	
	@FindBy(css = "[id='RowForm'] section[name='row.__states.ContentAssets']")
	protected  WebElement states_ContentAssets;
	
	@FindBy(css = "[id='RowForm'] section[name='row.__states.OttContentAssets']")
	protected  WebElement states_OttContentAssets;

	@FindBy(css = "[id='RowForm'] [id='s2id_row.performer'] span")
	protected WebElement row_performer;

	@FindBy(css = "[id='RowForm'] [name='row.startDate'] input")
	protected WebElement row_startDate;
	
	@FindBy(css = "[id='RowForm'] [name='row.endDate'] input")
	protected WebElement row_endDate;

 	@FindBy(css = "[id='RowForm'] [id='row.description'] textarea")
 	protected WebElement row_descriptionOrInstruction;

 	@FindBy(css = "[id='RowForm'] [id='s2id_row.contractor'] span")
 	protected WebElement row_contractor;
 	
 	
 	@FindBy(css = "[id='RowForm'] [id='row.externalId']")
 	protected WebElement row_externalId;
 	
	public Karaoke(PageManager pageManager) {
		super(pageManager);		
	}
	
	public Karaoke setName(String value) {
		type(row_name, value);
		User.setNameForm(value);
		return this;
	}

	public Karaoke setExternalId(String value){
		type(row_externalId, value);
		return this;
	}
	
	
	public AssetsOTT addAssertsOTT(){
		pageManager.getLinkedID(states_OttContentAssets).add();
		return pageManager.assetsOTT;
	}


	public Assets addAssets(){		
		pageManager.getLinkedID(states_ContentAssets).add();
		return pageManager.assets;
	}
	
	public Assets openAsset(String value){
		insideTab(states_ContentAssets);
		pageManager.getLinkedID(states_ContentAssets).openValue(value);
		return pageManager.assets;
		
	}
	
	public AssetsOTT openAssetOTT(String value){
		pageManager.getLinkedID(states_OttContentAssets).openValue(value);
		return pageManager.assetsOTT;
		
	}

	public Karaoke setLocations(String value) {
		pageManager.getList2List(states_Locations).addValue(value);
		return this;
	}
	
	
	
}
