package com.sl.applogic;

import ru.yandex.qatools.allure.annotations.Step;

import com.sl.pages.HomePage;

/**
 * 
 * Класс работает с домашней страницей любого из пункта меню
 *
 */
public class HomePageHelper extends DriverBasedHelper {

	public HomePageHelper(ApplicationManager applicationManager) {
		super(applicationManager.getWebDriver());
		
	}
	
	/**
	 * Метод ищет в фильтре значение 
	 * и открывает найденный в таблице результат
	 * @param value
	 */
	@Step("Open form")
	public void openForm(String value){
		pageManager.homePage.setName(value)
		.refresh()
		.openExistValue(value);		
	}
	
	/**
	 * Метод находит и копирует найденную форму
	 * @param value
	 */
	@Step("Copy form")
	public void copyForm(String value){
		pageManager.homePage.setName(value)
		.refresh();	
		pageManager.homePage.selectExistValue(value)
		.clickCopy();
		pageManager.paramCopy.clickCopyWithNewParam();
				
	}

	@Step("Create new form")
	public void addForm() {
	HomePage homePage = pageManager.homePage;
	homePage.addForm();	
	}

}
