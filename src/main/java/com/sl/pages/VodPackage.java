package com.sl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.model.User;

public class VodPackage extends AnyForm{

	@FindBy(css = "[id='RowForm'] [id='row.name']")
	protected WebElement row_name;

	@FindBy(css = "[id='RowForm'] [id='s2id_row.resourceFunc'] span")
	protected WebElement row_resourceFunc;

	@FindBy(css = "[id='RowForm'] [id='row.externalId']")
	protected WebElement row_externalId;

	@FindBy(css = "[id='RowForm'] [id='row.bundledGrp']")
	protected WebElement row_bundledGrp;

	@FindBy(css = "[id='RowForm'] [id='row.internalId']")
	protected WebElement row_internalId;

	@FindBy(css = "[id='RowForm'] [id='row.repPkgName']")
	protected WebElement row_repPkgName;

	@FindBy(css = "[id='RowForm'] [id='row.forSubscribe']")
	protected WebElement row_forSubscribe;

	@FindBy(css = "[id='RowForm'] [id='row.isAccessByLock']")
	protected WebElement row_isAccessByLock;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.VideoMovies']")
	protected WebElement states_videoMovies;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.BundlePackages']")
	protected WebElement states_bundlePackages;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.ServiceProviders']")
	protected WebElement states_serviceProviders;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.StbFunctions']")
	protected WebElement states_stbFunctions;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.NetworkTypes']")
	protected WebElement states_NetworkTypes;

	@FindBy(css = "[id='RowForm'] [id='s2id_row.type'] span")
	protected WebElement row_type;

	@FindBy(css = "[id='RowForm'] [id='row.appleId']")
	protected WebElement row_appleId;

	@FindBy(css = "[id='RowForm'] [id='row.androidId']")
	protected WebElement row_androidId;

	@FindBy(css = "[id='RowForm'] [id='row.smarttvId']")
	protected WebElement row_smarttvId;

	@FindBy(css="[id='RowForm'] [name='row.description'] textarea")
	protected WebElement description;

	public VodPackage(PageManager pageManager) {
		super(pageManager);	
	}
	
	public VodPackage setName(String value) {
		type(row_name, value);
		User.setNameForm(value);
		return this;
		
	}
	
	

}
