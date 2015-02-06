package com.sl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.model.User;

public class PromoActions extends AnyForm {	
	
	@FindBy(css="[id='RowForm'] [id='row.name']")
	 protected WebElement row_name;	
	
	@FindBy(css="[id='RowForm'] [id='row.sortOrder']")
	 protected WebElement row_sortOrder;
	
	@FindBy(css="[id='RowForm'] [id='row.overloadServiceSpecParams']")
	 protected WebElement row_overloadServiceSpecParams;
	
	@FindBy(css ="[id='RowForm'] [id='row.externalId']")
	 protected WebElement row_externalId;
	
	@FindBy(css = "[id='RowForm'] [name='row.startDate'] input")
	 protected WebElement row_startDate;
	
	@FindBy(css = "[id='RowForm'] [name='row.endDate'] input")
	 protected WebElement row_endDate;
	
	@FindBy(css ="[id='RowForm'] [id='row.duration']")
	 protected WebElement row_duration;
	
	@FindBy(css = "[id='RowForm'] [id='s2id_row.durationType'] span")
	 protected WebElement row_durationType;
	
	@FindBy(css = "[id='RowForm'] [id='row.startMessage'] ul")
	 protected WebElement row_startMessage;
	
	@FindBy(css = "[id='RowForm'] [id='row.notifyThreshold']")
	 protected WebElement row_notifyThreshold;
	
	@FindBy(css ="[id='RowForm'] [id='row.notifyTimeout']")
	 protected WebElement row_notifyTimeout;
	
	@FindBy(css ="[id='RowForm'] [id='row.isCheckUserInFilter']")
	 protected WebElement row_isCheckUserInFilter;
	
	@FindBy(css = "[id='RowForm'] [id='row.description'] textarea")
	 protected WebElement row_description;
	
	@FindBy(css = "[id='RowForm'] [id='row.notifyStartText'] textarea")
	 protected WebElement row_notifyStartText;
	
	@FindBy(css = "[id='RowForm'] [id='row.notifyText'] textarea")
	 protected WebElement row_notifyText;
	
//	@FindBy(css="[id='RowForm'] section[name='row.__states.ServiceSpecs']")
//	 protected WebElement row_serviceSpecs;
	
	@FindBy(css="[id='RowForm'] section[name='row.__states.MessageFilters']")
	 protected WebElement states_messageFilters;
	

	public PromoActions(PageManager pageManager) {
		super(pageManager);	
	}
	
	public PromoActions setName(String value) {
		type(row_name, value);
		User.setNameForm(value);
		return this;
	}

	public PromoActions setSorting(String value) {
		type(row_sortOrder, value);	
		return this;
		
	}
	
}
