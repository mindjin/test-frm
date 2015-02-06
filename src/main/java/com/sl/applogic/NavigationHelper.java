package com.sl.applogic;

import org.openqa.selenium.UnhandledAlertException;

import ru.yandex.qatools.allure.annotations.Step;

import com.sl.pages.HomePage.Menu;

/**
 * Класс использует методы для навигации по админке 
 */
public class NavigationHelper extends DriverBasedHelper{
	private String baseUrl;	
	
	
	
	
	public NavigationHelper(ApplicationManager applicationManager) {
		super(applicationManager.getWebDriver());
		this.baseUrl = applicationManager.getBaseUrl();
		
		
	}
	
	@Step("Open main page")
	public void openMainPage(){
		try{
		driver.get(baseUrl);	
		}catch(UnhandledAlertException e){
			driver.switchTo().alert().accept();			
		}
	}	
	
	@Step("Open relative url")
	public void openRelativeUrl(String url){
		driver.get(baseUrl+url);
	}
	
	@Step("Open internal page")
	public void openPage(Menu menu){		
		pageManager.homePage.clickPage(menu);
	}
	
	
	
	

}
