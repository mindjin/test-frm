package com.sl.test;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sl.applogic.DataHelper.ElementsForm;
import com.sl.conf.ConfigBase;
import com.sl.data.Element;
import com.sl.data.RandomValues;
import com.sl.pages.HomePage.Menu;
import com.sl.pages.PageManager.Form;
import com.sl.utils.ElementScreenshot;
@Listeners(ElementScreenshot.class)
public class TestVodPackage extends ConfigBase {
	
	@Test
	public void createVoDPackageWithFillForm(){
		app.getNavigationHelper().openPage(Menu.VODPACKAGE);
		app.getHomePageHelper().addForm();
		List<Element> randomValuesVodPackage = app.getDataHelper().getRandomValues(Form.VODPACKAGE);
		app.getFormHelper().fillForm(randomValuesVodPackage, Form.VODPACKAGE);
		pageManager.vodPackage.createAndClose();
		app.getHomePageHelper().openForm(ElementsForm.NAME.getValue());
		app.getFormHelper().verifyForm(randomValuesVodPackage, Form.VODPACKAGE);
		app.getFormHelper().deleteCard(Form.VODPACKAGE);		
	}
	
	@Test
	public void saveVoDPackageWithFillForm(){
		rndNum =RandomValues.rndNumb(999999);
		app.getNavigationHelper().openPage(Menu.VODPACKAGE);
		app.getHomePageHelper().addForm();
		pageManager.vodPackage
		.setName("wp58.1_"+rndNum)		
		.createAndClose();
		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
		List<Element> randomValuesVodPackage = app.getDataHelper().getRandomValues(Form.VODPACKAGE);
		app.getFormHelper().fillForm(randomValuesVodPackage, Form.VODPACKAGE);
		pageManager.vodPackage.saveAndClose();
		app.getHomePageHelper().openForm(ElementsForm.NAME.getValue());
		app.getFormHelper().verifyForm(randomValuesVodPackage, Form.VODPACKAGE);
		app.getFormHelper().deleteCard(Form.VODPACKAGE);		
	}

}
