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
public class TestKaraoke extends ConfigBase{	
	
	
		@Test
		public void createKaraokeWithFillForm() throws Exception{
		rndNum =RandomValues.rndNumb(999999);
			app.getNavigationHelper().openPage(Menu.KARAOKE);
			app.getHomePageHelper().addForm();		
			List<Element> randomValuesKaraoke = app.getDataHelper().getRandomValues(Form.KARAOKE);		
			app.getFormHelper().fillForm(randomValuesKaraoke, Form.KARAOKE);
			pageManager.karaoke.createAndClose();
			app.getHomePageHelper().openForm(ElementsForm.NAME.getValue());
			app.getFormHelper().verifyForm(randomValuesKaraoke, Form.KARAOKE);	
			app.getFormHelper().deleteCard(Form.KARAOKE);

	}
		@Test
		public void createAssetsWithFillForm() throws Exception{	
		rndNum =RandomValues.rndNumb(999999);	
			app.getNavigationHelper().openPage(Menu.KARAOKE);
			app.getHomePageHelper().addForm();	
			pageManager.karaoke
			.setName("wp_58.1_"+rndNum)
			.setExternalId(rndNum)
			.setLocations("Московский");			
			pageManager.karaoke.addAssets();
			List<Element> defaultValuesAssets = app.getDataHelper().getRandomValues(Form.ASSETS);
			app.getFormHelper().fillForm(defaultValuesAssets, Form.ASSETS);
			pageManager.assets.create();
			pageManager.karaoke.createAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke.openAsset(ElementsForm.NAME.getValue());
			app.getFormHelper().verifyForm(defaultValuesAssets, Form.ASSETS);
			pageManager.assets.close();
			app.getFormHelper().deleteCard(Form.KARAOKE);
		}
		
		@Test
		public void createAudioPIDWithFillForm() throws Exception{
		rndNum =RandomValues.rndNumb(999999);
			app.getNavigationHelper().openPage(Menu.KARAOKE);
			app.getHomePageHelper().addForm();	
			pageManager.karaoke
			.setName("wp_58.1_"+rndNum)
			.setExternalId(rndNum)
			.setLocations("Московский");			
			pageManager.karaoke.addAssets().setName(rndNum)
			.addAudioPID();
			List<Element> defaultValuesAudioPID = app.getDataHelper().getRandomValues(Form.AUDIOPID);
			app.getFormHelper().fillForm(defaultValuesAudioPID, Form.AUDIOPID);
			pageManager.audioPID.create();
			pageManager.assets.create();
			pageManager.karaoke.createAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke
			.openAsset(rndNum)
			.openAudioPID(ElementsForm.NAME.getValue());
			app.getFormHelper().verifyForm(defaultValuesAudioPID, Form.AUDIOPID);
			pageManager.audioPID.close();
			pageManager.assets.close();
			app.getFormHelper().deleteCard(Form.KARAOKE);			
		}
		
		@Test
		public void createAssetsOTTWithFillForm() throws Exception{
		rndNum =RandomValues.rndNumb(999999);
			app.getNavigationHelper().openPage(Menu.KARAOKE);
			app.getHomePageHelper().addForm();	
			pageManager.karaoke
			.setName("wp_58.1_"+rndNum)
			.setExternalId(rndNum)
			.setLocations("Московский");
			pageManager.karaoke.addAssertsOTT();
			List<Element> defaultValuesAssetsOTT = app.getDataHelper().getRandomValues(Form.ASSETSOTT);
			app.getFormHelper().fillForm(defaultValuesAssetsOTT, Form.ASSETSOTT);
			pageManager.assetsOTT.create();
			pageManager.karaoke.createAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke.openAssetOTT(ElementsForm.NAME.getValue());
			app.getFormHelper().verifyForm(defaultValuesAssetsOTT, Form.ASSETSOTT);
			pageManager.assetsOTT.close();
			app.getFormHelper().deleteCard(Form.KARAOKE);			
		}
		
		@Test
		public void saveKaraokeWithFillForm() throws Exception{
		rndNum =RandomValues.rndNumb(999999);
			app.getNavigationHelper().openPage(Menu.KARAOKE);
			app.getHomePageHelper().addForm();	
			pageManager.karaoke
			.setName("wp_58.1_"+rndNum)
			.setExternalId(rndNum)
			.setLocations("Московский");			
			pageManager.karaoke.createAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			List<Element> randomValuesKaraoke = app.getDataHelper().getRandomValues(Form.KARAOKE);		
			app.getFormHelper().fillForm(randomValuesKaraoke, Form.KARAOKE);
			pageManager.karaoke.saveAndClose();
			app.getHomePageHelper().openForm(ElementsForm.NAME.getValue());
			app.getFormHelper().verifyForm(randomValuesKaraoke, Form.KARAOKE);	
			app.getFormHelper().deleteCard(Form.KARAOKE);
	}
		
		@Test
		public void saveAssetsWithFillForm()  throws Exception{
		rndNum =RandomValues.rndNumb(999999);
			app.getNavigationHelper().openPage(Menu.KARAOKE);
			app.getHomePageHelper().addForm();	
			pageManager.karaoke
			.setName("wp_58.1_"+rndNum)
			.setExternalId(rndNum)
			.setLocations("Московский");			
			pageManager.karaoke.addAssets().setName(rndNum);
			pageManager.assets.create();
			pageManager.karaoke.createAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke
			.openAsset(ElementsForm.NAME.getValue());
			List<Element> defaultValuesAssets = app.getDataHelper().getRandomValues(Form.ASSETS);
			app.getFormHelper().fillForm(defaultValuesAssets, Form.ASSETS);
			pageManager.assets.save();
			pageManager.karaoke.saveAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke.openAsset(ElementsForm.NAME.getValue());
			app.getFormHelper().verifyForm(defaultValuesAssets, Form.ASSETS);
			pageManager.assets.close();
			app.getFormHelper().deleteCard(Form.KARAOKE);	
		}
		
		@Test
		public void saveAudioPIDofAssetsWithFillForm()  throws Exception{
			rndNum =RandomValues.rndNumb(999999);
			app.getNavigationHelper().openPage(Menu.KARAOKE);
			app.getHomePageHelper().addForm();	
			pageManager.karaoke
			.setName("wp_58.1_"+rndNum)
			.setExternalId(rndNum)
			.setLocations("Московский");			
			pageManager.karaoke.addAssets().setName(rndNum).addAudioPID();
			pageManager.audioPID.setName(rndNum).setPID(rndNum).create();
			pageManager.assets.create();
			pageManager.karaoke.createAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke
			.openAsset(rndNum).openAudioPID(rndNum);			
			List<Element> defaultValuesAudioPID = app.getDataHelper().getRandomValues(Form.AUDIOPID);
			app.getFormHelper().fillForm(defaultValuesAudioPID, Form.AUDIOPID);
			pageManager.audioPID.save();			
			pageManager.assets.save();
			pageManager.karaoke.saveAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke.openAsset(rndNum).openAudioPID(ElementsForm.NAME.getValue());
			app.getFormHelper().verifyForm(defaultValuesAudioPID, Form.AUDIOPID);
			pageManager.audioPID.close();
			pageManager.assets.close();
			app.getFormHelper().deleteCard(Form.KARAOKE);	
		}
		
		@Test
		public void saveAssetsOTTWithFillForm() throws Exception{
			rndNum =RandomValues.rndNumb(999999);
			app.getNavigationHelper().openPage(Menu.KARAOKE);
			app.getHomePageHelper().addForm();	
			pageManager.karaoke
			.setName("wp_58.1_"+rndNum)
			.setExternalId(rndNum)
			.setLocations("Московский");
			pageManager.karaoke.addAssertsOTT().setName(rndNum).create();
			pageManager.karaoke.createAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke.openAssetOTT(rndNum);
			List<Element> defaultValuesAssetsOTT = app.getDataHelper().getRandomValues(Form.ASSETSOTT);
			app.getFormHelper().fillForm(defaultValuesAssetsOTT, Form.ASSETSOTT);
			pageManager.assetsOTT.save();
			pageManager.karaoke.saveAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke.openAssetOTT(ElementsForm.NAME.getValue());
			app.getFormHelper().verifyForm(defaultValuesAssetsOTT, Form.ASSETSOTT);
			pageManager.assetsOTT.close();
			app.getFormHelper().deleteCard(Form.KARAOKE);	
			
		}
		
		@Test
		public void saveAudioPIDofAssetsOTTWithFillForm() throws Exception{
			rndNum =RandomValues.rndNumb(999999);
			app.getNavigationHelper().openPage(Menu.KARAOKE);
			app.getHomePageHelper().addForm();	
			pageManager.karaoke
			.setName("wp_58.1_"+rndNum)
			.setExternalId(rndNum)
			.setLocations("Московский");
			pageManager.karaoke
			.addAssertsOTT()
			.setName(rndNum)
			.addAudioPID()
			.setName(rndNum)
			.setPID(rndNum)
			.create();
			pageManager.assetsOTT.create();
			pageManager.karaoke.createAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke.openAssetOTT(rndNum).openAudioPID(rndNum);
			List<Element> defaultValuesAudioPID = app.getDataHelper().getRandomValues(Form.AUDIOPID);
			app.getFormHelper().fillForm(defaultValuesAudioPID, Form.AUDIOPID);
			pageManager.audioPID.save();
			pageManager.assetsOTT.save();
			pageManager.karaoke.saveAndClose();
			app.getHomePageHelper().openForm("wp_58.1_"+rndNum);
			pageManager.karaoke.openAssetOTT(rndNum).openAudioPID(ElementsForm.NAME.getValue());
			app.getFormHelper().verifyForm(defaultValuesAudioPID, Form.AUDIOPID);
			pageManager.audioPID.close();
			pageManager.assetsOTT.close();
			app.getFormHelper().deleteCard(Form.KARAOKE);	
			
		}
		
}
