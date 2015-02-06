package com.sl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sl.model.User;
import com.sl.popup.AudioPIDtv;
import com.sl.popup.DvbtURL;
import com.sl.popup.MulticastGroup;
import com.sl.popup.OttURL;
import com.sl.popup.Subtitles;
import com.sl.utils.Length;

public class BroadcastChannel extends AnyForm {

	@FindBy(css = "[id='RowForm'] [id='row.name']")
	protected WebElement row_name;

	@FindBy(css = "[id='RowForm'] [id='row.externalId']")
	protected WebElement row_externalId;

	@FindBy(css="[id='RowForm'] [name='row.description'] textarea")
	protected WebElement row_description;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.Locations']")
	protected WebElement states_Locations;
	
	@FindBy(css = "[id='RowForm'] section[name='row.__states.AudioPIDs']")
	protected WebElement states_AudioPIDs;

	@FindBy(css = "[id='RowForm'] [id='row.smExternalId']")
	protected WebElement row_smExternalId;

	@FindBy(css = "[id='RowForm'] [id='row.isCrypted']")
	protected WebElement row_isCrypted;

	@FindBy(css = "[id='RowForm'] [id='row.restrictTimeStart'] input")
	protected WebElement row_restrictTimeStart;

	@FindBy(css = "[id='RowForm'] [id='row.restrictTimeEnd'] input")
	protected WebElement row_restrictTimeEnd;

	@FindBy(css = "[id='RowForm'] [id='s2id_row.accessLevel'] span")
	protected WebElement row_accessLevel;

	@FindBy(css = "[id='RowForm'] [id='row.isErotic']")
	protected WebElement row_isErotic;

	@FindBy(css = "[id='RowForm'] [id='row.number']")
	protected WebElement row_number;

	@FindBy(css = "[id='RowForm'] [id='row.viewPVRChannelID']")
	protected WebElement row_viewPVRChannelID;

	@FindBy(css = "[id='RowForm'] [id='row.isBarker']")
	protected WebElement row_isBarker;

	@FindBy(css = "[id='RowForm'] [id='row.url']")
	protected WebElement row_url;

	@FindBy(css = "[id='RowForm'] [id='row.hqUrl']")
	protected WebElement row_hqUrl;

	@FindBy(css = "[id='RowForm'] [id='row.backupUrl1']")
	protected WebElement row_backupUrl1;

	@FindBy(css = "[id='RowForm'] [id='row.backupUrl2']")
	protected WebElement row_backupUrl2;

	@FindBy(css = "[id='RowForm'] [id='row.plcUrl']")
	protected WebElement row_plcUrl;

	@FindBy(css = "[id='RowForm'] [id='row.pipUrl']")
	protected WebElement row_pipUrl;

	@FindBy(css = "[id='RowForm'] [id='row.raptorPort']")
	protected WebElement row_raptorPort;

	@FindBy(css = "[id='RowForm'] [id='row.ottDvr']")
	protected WebElement row_ottDvr;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.ChannelOttUrlOverrides']")
	protected WebElement states_ChannelOttUrlOverrides;

	@FindBy(css = "[id='RowForm'] [id='row.tstvOttURL']")
	protected WebElement row_tstvOttURL;

	@FindBy(css = "[id='RowForm'] [id='row.plOttURL']")
	protected WebElement row_plOttURL;

	@FindBy(css = "[id='RowForm'] [id='row.promoUrl']")
	protected WebElement row_promoUrl;

	@FindBy(css = "[id='RowForm'] [id='row.smlOttURL']")
	protected WebElement row_smlOttURL;

	@FindBy(css = "[id='RowForm'] [id='s2id_row.videoServerProtocol'] span")
	protected WebElement row_videoServerProtocol;

	@Length(24)
	@FindBy(css = "[id='RowForm'] [id='row.epgOffset']")
	protected WebElement row_epgOffset;

	@FindBy(css = "[id='RowForm'] [id='row.tstvDuration']")
	protected WebElement row_tstvDuration;

	@FindBy(css = "[id='RowForm'] [id='row.segmentDuration']")
	protected WebElement row_segmentDuration;

	@FindBy(css = "[id='RowForm'] [id='row.isQualityMonitoring']")
	protected WebElement row_isQualityMonitoring;

	@FindBy(css = "[id='RowForm'] [id='row.isTestStreamQuality']")
	protected WebElement row_isTestStreamQuality;	

	@FindBy(css = "[id='RowForm'] [id='row.soundVolume']")
	protected WebElement row_soundVolume;

	@FindBy(css = "[id='RowForm'] [id='row.isDvrCrypted']")
	protected WebElement row_isDvrCrypted;

	@FindBy(css = "[id='RowForm'] [id='row.dvbtChannelName']")
	protected WebElement row_dvbtChannelName;

	@FindBy(css = "[id='RowForm'] [id='row.repChannelName']")
	protected WebElement row_repChannelName;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.SmartRecorders']")
	protected WebElement states_smartRecorders;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.ChannelPackages']")
	protected WebElement states_channelPackages;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.ChannelSubjects']")
	protected WebElement states_channelSubjects;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.ChannelRestrictLocations']")
	protected WebElement states_channelRestrictLocations;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.ChannelInStbFunction']")
	protected WebElement states_channelInStbFunction;

	@FindBy(css = "[id='RowForm'] section[name='row.__states.ChannelInNetworkType']")
	protected WebElement states_channelInNetworkType;	
	
	@FindBy(css = "[id='RowForm'] section[name='row.__states.SubtitlePIDs']")
	protected WebElement states_SubtitlePIDs;
	
	@FindBy(css = "[id='RowForm'] section[name='row.__states.ChannelUrlOverrides']")
	protected WebElement states_ChannelUrlOverrides;
	
	@FindBy(css = "[id='RowForm'] section[name='row.__states.DVBtUrls']")
	protected WebElement states_DVBtUrls;
	
	@FindBy(css = "[id='RowForm'] [id='row.nPVRChannelID']")
	protected WebElement row_nPVRChannelID;

	@FindBy(css = "[id='RowForm'] [id='row.tstvType']")
	protected WebElement row_tstvType;

	@FindBy(css = "[id='RowForm'] [id='row.isNpvrEnabled']")
	protected WebElement row_isNpvrEnabled;

	@FindBy(css = "[id='RowForm'] [id='row.isPauseLifeEnabled']")
	protected WebElement row_isPauseLifeEnabled;	

	@FindBy(css = "[id='RowForm'] [id='row.bitrate']")
	protected WebElement row_bitrate2;	
	
	public BroadcastChannel(PageManager pageManager) {
		super(pageManager);		
	}
	
	public BroadcastChannel setName(String value) {
		type(row_name, value);
		User.setNameForm(value);
		return this;		
	}
	
	public BroadcastChannel setNumber(String value){		
		type(row_number, value);
		return this;
		
	}
	
	public BroadcastChannel setLocations(String value) {
		pageManager.getList2List(states_Locations).addValue(value);
		return this;
	}		
	
	public AudioPIDtv addAudioPID() {	
		pageManager.getLinkedID(states_AudioPIDs).add();
		return pageManager.audioPIDtv;
	}

	public AudioPIDtv openAudioPID(String value) {
		pageManager.getLinkedID(states_AudioPIDs).openValue(value);
		return pageManager.audioPIDtv;
		
	}
	
	public Subtitles addSubtitles(){
		pageManager.getLinkedID(states_SubtitlePIDs).add();
		return pageManager.subtitles;
	}
	
	public Subtitles openSubtitles(String value){
		pageManager.getLinkedID(states_SubtitlePIDs).openValue(value);
		return pageManager.subtitles;
	}

	public MulticastGroup openMulticastGroup(String value) {
		pageManager.getLinkedID(states_ChannelUrlOverrides).openValue(value);
		return pageManager.multicastGroup;
		
	}

	public MulticastGroup addMulticastGroup() {
		pageManager.getLinkedID(states_ChannelUrlOverrides).add();
		return pageManager.multicastGroup;
		
	}
	
	public OttURL addOttURL(){
		pageManager.getLinkedID(states_ChannelOttUrlOverrides).add();
		return pageManager.ottUrl;
	}
	
	public OttURL openOttURL(String value){
		pageManager.getLinkedID(states_ChannelOttUrlOverrides).openValue(value);
		return pageManager.ottUrl;
	}
	
	public DvbtURL addDvbtURL(){
		pageManager.getLinkedID(states_DVBtUrls).add();
		return pageManager.dvbtUrl;
	}
	public DvbtURL openDvbtURL(String value){
		pageManager.getLinkedID(states_DVBtUrls).openValue(value);
		return pageManager.dvbtUrl;
	}

}
