package com.sl.test;

import static com.sl.applogic.DataHelper.ElementsForm.NAME;
import static com.sl.applogic.DataHelper.ElementsForm.URL;
import static com.sl.pages.PageManager.Form.AUDIOPIDtv;
import static com.sl.pages.PageManager.Form.BROADCASTCHANNEL;
import static com.sl.pages.PageManager.Form.DVBTURL;
import static com.sl.pages.PageManager.Form.MULTICASTGROUP;
import static com.sl.pages.PageManager.Form.OTTURL;
import static com.sl.pages.PageManager.Form.SUBTITLES;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sl.conf.ConfigBase;
import com.sl.data.Element;
import com.sl.data.RandomValues;
import com.sl.pages.HomePage.Menu;
import com.sl.utils.ElementScreenshot;


@Listeners(ElementScreenshot.class)
public class TestBroadcastChannel extends ConfigBase {

	@Test
	public void createBCwithFillForm(){
		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
		assertTrue(1<0);
		app.getHomePageHelper().addForm();
		pageManager.broadcastChannel.setName("123");
		List<Element> randomBC = app.getDataHelper().getRandomValues(BROADCASTCHANNEL);
		app.getFormHelper().fillForm(randomBC, BROADCASTCHANNEL);
		pageManager.promoActions.createAndClose();
		app.getHomePageHelper().openForm(NAME.getValue());
		app.getFormHelper().verifyForm(randomBC, BROADCASTCHANNEL);
		app.getFormHelper().deleteCard(BROADCASTCHANNEL);
	}
	
//	@Test
//	public void createAudioPIDinBCwithFillForm(){
//		rndNum =RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		app.getHomePageHelper().addForm();
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum)
//		.addAudioPID();
//		List<Element> randomAP = app.getDataHelper().getRandomValues(AUDIOPIDtv);
//		app.getFormHelper().fillForm(randomAP, AUDIOPIDtv);
//		pageManager.audioPIDtv.create();
//		pageManager.broadcastChannel.createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openAudioPID(NAME.getValue());
//		app.getFormHelper().verifyForm(randomAP, AUDIOPIDtv);
//		pageManager.audioPIDtv.close();
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);		
//		
//	}
//	
//	@Test
//	public void createSubtitlesInBCWithFillForm(){
//		rndNum =RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		app.getHomePageHelper().addForm();
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum)
//		.addSubtitles();
//		List<Element> randomSubtitles = app.getDataHelper().getRandomValues(SUBTITLES);
//		app.getFormHelper().fillForm(randomSubtitles, SUBTITLES);
//		pageManager.subtitles.create();
//		pageManager.broadcastChannel.createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openSubtitles(NAME.getValue());
//		app.getFormHelper().verifyForm(randomSubtitles, SUBTITLES);
//		pageManager.subtitles.close();
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);		
//	}
//	
//	@Test
//	public void createMulticastGroupinBCWithFillForm(){
//		rndNum =RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		
//		app.getHomePageHelper().addForm();
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum)
//		.addMulticastGroup();
//		List<Element> randomMG = app.getDataHelper().getRandomValues(MULTICASTGROUP);
//		
//		app.getFormHelper().fillForm(randomMG, MULTICASTGROUP);
//		pageManager.multicastGroup.create();
//		pageManager.broadcastChannel.createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openMulticastGroup(URL.getValue());
//		app.getFormHelper().verifyForm(randomMG, MULTICASTGROUP);
//		pageManager.multicastGroup.close();
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);		
//		
//	}
//	
//	@Test
//	public void createOttURl(){
//		rndNum = RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		app.getHomePageHelper().addForm();
//		assertTrue(1<0);
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum)
//		.addOttURL();
//		List<Element> randomMG = app.getDataHelper().getRandomValues(OTTURL);
//		app.getFormHelper().fillForm(randomMG, OTTURL);
//		pageManager.ottUrl.create();
//		pageManager.broadcastChannel.createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openOttURL(URL.getValue());
//		app.getFormHelper().verifyForm(randomMG, OTTURL);
//		pageManager.ottUrl.close();
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);	
//	}
//	
//	@Test
//	public void createDvbtURL(){
//		rndNum =RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		app.getHomePageHelper().addForm();
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum)
//		.addDvbtURL();
//		List<Element> randomMG = app.getDataHelper().getRandomValues(DVBTURL);
//		app.getFormHelper().fillForm(randomMG, DVBTURL);
//		pageManager.dvbtUrl.create();
//		pageManager.broadcastChannel.createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openDvbtURL(URL.getValue());
//		app.getFormHelper().verifyForm(randomMG, DVBTURL);
//		pageManager.dvbtUrl.close();
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);	
//	}
//
//	@Test
//	public void saveTV(){
//		rndNum =RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		app.getHomePageHelper().addForm();
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum).createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);		
//		List<Element> randomBC = app.getDataHelper().getRandomValues(BROADCASTCHANNEL);
//		app.getFormHelper().fillForm(randomBC, BROADCASTCHANNEL);
//		pageManager.broadcastChannel.saveAndClose();
//		app.getHomePageHelper().openForm(NAME.getValue());	
//		app.getFormHelper().verifyForm(randomBC, BROADCASTCHANNEL);
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);
//	}
//	
//	@Test
//	public void saveAudioPID(){
//		rndNum =RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		app.getHomePageHelper().addForm();
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum)
//		.addAudioPID().setName(rndNum).setPID(rndNum).setLocations("Все").create();
//		pageManager.broadcastChannel.createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openAudioPID(rndNum);
//		List<Element> randomAP = app.getDataHelper().getRandomValues(AUDIOPIDtv);
//		app.getFormHelper().fillForm(randomAP, AUDIOPIDtv);
//		pageManager.audioPID.save();
//		pageManager.broadcastChannel.saveAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openAudioPID(NAME.getValue());
//		app.getFormHelper().verifyForm(randomAP, AUDIOPIDtv);
//		pageManager.audioPIDtv.close();
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);		
//		
//	}
//	
//	@Test
//	public void saveSubtitle(){
//		rndNum =RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		app.getHomePageHelper().addForm();
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum)
//		.addSubtitles().setName(rndNum).setPID(rndNum).setLocations("Все").create();
//		pageManager.broadcastChannel.createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openSubtitles(rndNum);
//		List<Element> randomSubtitles = app.getDataHelper().getRandomValues(SUBTITLES);
//		app.getFormHelper().fillForm(randomSubtitles, SUBTITLES);
//		pageManager.subtitles.save();
//		pageManager.broadcastChannel.saveAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openSubtitles(NAME.getValue());
//		app.getFormHelper().verifyForm(randomSubtitles, SUBTITLES);
//		pageManager.subtitles.close();
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);		
//		
//	}
//	
//	@Test
//	public void saveMulticastGroup(){
//		rndNum =RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		app.getHomePageHelper().addForm();
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum)
//		.addMulticastGroup().setURL(rndNum).create();
//		pageManager.broadcastChannel.createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openMulticastGroup(rndNum);
//		List<Element> randomMG = app.getDataHelper().getRandomValues(MULTICASTGROUP);
//		app.getFormHelper().fillForm(randomMG, MULTICASTGROUP);
//		pageManager.multicastGroup.save();
//		pageManager.broadcastChannel.saveAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openMulticastGroup(URL.getValue());
//		app.getFormHelper().verifyForm(randomMG, MULTICASTGROUP);
//		pageManager.multicastGroup.close();
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);		
//		
//	}
//	
//	@Test
//	public void saveOttURL(){
//		rndNum =RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		app.getHomePageHelper().addForm();
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum)
//		.addOttURL().setURL(rndNum).create();
//		pageManager.broadcastChannel.createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openOttURL(rndNum);
//		List<Element> randomOttURL = app.getDataHelper().getRandomValues(OTTURL);
//		app.getFormHelper().fillForm(randomOttURL, OTTURL);
//		pageManager.ottUrl.save();
//		pageManager.broadcastChannel.saveAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openOttURL(URL.getValue());
//		app.getFormHelper().verifyForm(randomOttURL, OTTURL);
//		pageManager.ottUrl.close();
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);		
//		
//	}
//	
//	@Test
//	public void saveDvbtURL(){
//		rndNum =RandomValues.rndNumb(999999);
//		app.getNavigationHelper().openPage(Menu.BROADCASTCHANNEL);
//		app.getHomePageHelper().addForm();
//		pageManager.broadcastChannel
//		.setName("wp58.1_"+rndNum)
//		.setLocations("Московский")
//		.setNumber(rndNum)
//		.addDvbtURL().setURL(rndNum).create();
//		pageManager.broadcastChannel.createAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openDvbtURL(rndNum);
//		List<Element> randomDvbtURL = app.getDataHelper().getRandomValues(DVBTURL);
//		app.getFormHelper().fillForm(randomDvbtURL, DVBTURL);
//		pageManager.dvbtUrl.save();
//		pageManager.broadcastChannel.saveAndClose();
//		app.getHomePageHelper().openForm("wp58.1_"+rndNum);
//		pageManager.broadcastChannel.openDvbtURL(URL.getValue());
//		app.getFormHelper().verifyForm(randomDvbtURL, DVBTURL);
//		pageManager.dvbtUrl.close();
//		app.getFormHelper().deleteCard(BROADCASTCHANNEL);		
//		
//	}

}
