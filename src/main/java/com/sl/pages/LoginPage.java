package com.sl.pages;

//import org.hibernate.sql.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

	@FindBy(id = "row.login") 																			
	protected  WebElement login; 
	
	@FindBy(id = "row.password")																			
	protected  WebElement password;	
	
	@FindBy(id="btnSignIn")												
	protected  WebElement buttonAutorization;
	
	@FindBy(css = "[value='row.language'] span")
	protected  WebElement row_language;
	
	public LoginPage(PageManager pageManager) {
		super(pageManager);
		
	}
	
	public LoginPage setLogin(String value){
		type(login, value);
		return this;
	}
	
	public LoginPage setPassword(String value){
		type(password, value);
		return this;
	}
	
	public void clickButtonAutorization(){
		buttonAutorization.click();
	}
	
	public void setLanguage(String value){
		pageManager.getCombobox(row_language).findValue(value);		
		
	}
	
	public WebElement getButtonAutorization(){	
		return driver.findElement(By.id("btnSignIn"));
	}
}
