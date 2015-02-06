package com.sl.applogic;


import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.allure.annotations.Step;

import com.sl.data.Element;
import com.sl.model.User;
import com.sl.pages.AnyForm;
import com.sl.pages.PageManager.Form;
import com.sl.utils.List2List;

import static org.junit.Assert.assertTrue;
public class FormHelper extends DriverBasedHelper{

/**
 * 
 * Класс используется для выполнения общих задач с формами
 */
	
	public FormHelper(ApplicationManager applicationManager){
		super(applicationManager.getWebDriver());		
	}
	
	
	/**
	 * Метод проставляет значения в форме
	 * @param getElement - значения базы данных
	 * @param form
	 * @return
	 */
	@Step("Fill form")
	public AnyForm fillForm(List<Element> getElement, Form form){	
		AnyForm page = pageManager.getPage(form);
		WebElement element = null;
		String value, type;
		Field[] field = page.getClass().getDeclaredFields();
		
		for (Element line : getElement){
			value = line.getValue();
			type = line.getType();
			
			for(Field fieldOfPage : field)
			{
				fieldOfPage.setAccessible(true);
				if(fieldOfPage.getType().equals(WebElement.class)){
					
					if(fieldOfPage.getName().equals(line.getNameVariable())) {
						
						try {
							element = (WebElement)fieldOfPage.get(page);
						} catch (IllegalArgumentException
								| IllegalAccessException e) {							
							e.printStackTrace();
						}
						if(fieldOfPage.getName().equals("row_name")||fieldOfPage.getName().equals("row_url"))
							User.setNameForm(value);						
						page.insideTab(element);
						
						
						switch(type){
						case "textfield":
							page.type(element, value);
							break;
						case "checkbox":
							pageManager.getCheckbox(element)
							.editCheckbox(value);
							break;
						case "integer":
							page.type(element, value);
							break;
						case "double":
							page.type(element, value);
							break;
						case "date":
							page.type(element, value);
							break;
						case "combobox":							
							pageManager.getCombobox(element)
							.findValue(value);
							break;
						case "list2list":							
							pageManager
							.getList2List(element)
							.addValue(value);
							break;
						case "finder":
							element.click();							
							pageManager.finder.incPopup();
							pageManager.finder.setName(value)
							.selectExistValue(value)
							.clickCreate();				
							break;
						case "time":
							page.type(element, value);
							break;
							default:
								break;
						
						}
					}
				}
			}
		}
		return page;
}


	/**
	 * Метод сверяет значения в форме со значениями в базе данных
	 * @param getElement - значения базы данных
	 * @param form
	 */
	@Step("Verify form")
	public void verifyForm(List<Element> getElement, Form form){
		AnyForm page = pageManager.getPage(form);
		WebElement element = null;
		String value, type;
		
		Field[] field = page.getClass().getDeclaredFields();
		
		
		for (Element line : getElement){
			value = line.getValue();
			type = line.getType();
			
			
			for(Field fieldOfPage : field)
			{
				if(fieldOfPage.getType().equals(WebElement.class)){
					fieldOfPage.setAccessible(true);
					if(fieldOfPage.getName().equals(line.getNameVariable())) {

						try {
							element = (WebElement)fieldOfPage.get(page);
						} catch (IllegalArgumentException
								| IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						page.insideTab(element);
						if(line.getName().equals("Сортировка"))
							break;
						
						switch(type){
						case "textfield":
							assertTrue(line.getName()+" not equal "+value,element.getAttribute("value").equals(value));
							break;
						case "integer":
							assertTrue(line.getName()+" not equal "+value,element.getAttribute("value").equals(value));
							break;
						case "double":
							assertTrue(line.getName()+" not equal "+value,element.getAttribute("value").equals(value));
							break;
						case "checkbox":
							if(value.equals("1"))
								assertTrue("Checkbox "+line.getName()+" is not selected",element.isSelected());
							if(value.equals("0"))
								assertTrue("Checkbox "+line.getName()+" is selected",!element.isSelected());
							break;
						case "date":
							assertTrue(line.getName()+" not equal "+value,element.getAttribute("value").equals(value));
							break;
						case "time":
							assertTrue(line.getName()+" not equal "+value,element.getAttribute("value").equals(value));
							break;
						case "combobox":
							assertTrue(line.getName()+" not equal "+value,element
									.getText()
									.equals(line
											.getValue()));
							break;
						case "list2list":
							List2List list2list= pageManager.getList2List(element);
							assertTrue(line.getName()+" not equal "+value,list2list.getRightFilter(value));
							assertTrue(line.getName()+" not equal "+value,list2list.getLeftFilter(value));
							
							break;
						case "finder":
							 WebElement getFinderText = element.findElement(By.cssSelector("li>div"));
							 assertTrue(line.getName()+" not equal "+value,getFinderText.getText().equals(value));
										
							break;
							default:
								break;
						
						}
						
					}
				}
			}			
		}
}
	
	/**
	 * Удаление любой из форм
	 * @param form
	 */
	@Step("Deleted card")
	public void deleteCard(Form form){
		AnyForm page = pageManager.getPage(form);
		page
		.clearningTabs()
		.delete()
		.clickYes();
	}
}

