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
public class TestPromo extends ConfigBase {
	
//	@Test
//	public void createPromoWithFillForm(){
//		app.getNavigationHelper().openPage(Menu.PROMOACTIONS);
//		app.getHomePageHelper().addForm();
//		List<Element> randomValuesPromo = app.getDataHelper().getRandomValues(Form.PROMOACTIONS);
//		app.getFormHelper().fillForm(randomValuesPromo, Form.PROMOACTIONS);
//		pageManager.promoActions.createAndClose();
//		app.getHomePageHelper().openForm(ElementsForm.NAME.getValue());
//		app.getFormHelper().verifyForm(randomValuesPromo, Form.PROMOACTIONS);
//		app.getFormHelper().deleteCard(Form.PROMOACTIONS);
//		
//	}
	
	@Test
	public void savePromoWithFillForm(){
		rndNum =RandomValues.rndNumb(999999);
		app.getNavigationHelper().openPage(Menu.PROMOACTIONS);
		app.getHomePageHelper().addForm();
		pageManager.promoActions
		.setName("wp58.1_"+rndNum)
		.setSorting(rndNum)
		.createAndClose();
		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
		List<Element> randomValuesPromo = app.getDataHelper().getRandomValues(Form.PROMOACTIONS);
		app.getFormHelper().fillForm(randomValuesPromo, Form.PROMOACTIONS);
		pageManager.promoActions.saveAndClose();
		app.getHomePageHelper().openForm(ElementsForm.NAME.getValue());
		app.getFormHelper().verifyForm(randomValuesPromo, Form.PROMOACTIONS);
		app.getFormHelper().deleteCard(Form.PROMOACTIONS);		
	}
	
}
