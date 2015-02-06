package com.sl.pages;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sl.popup.Assets;
import com.sl.popup.AssetsOTT;
import com.sl.popup.AudioPID;
import com.sl.popup.AudioPIDtv;
import com.sl.popup.Delete;
import com.sl.popup.DvbtURL;
import com.sl.popup.Finder;
import com.sl.popup.MulticastGroup;
import com.sl.popup.OttURL;
import com.sl.popup.ParamCopy;
import com.sl.popup.Subtitles;
import com.sl.utils.Checkbox;
import com.sl.utils.Combobox;
import com.sl.utils.LinkedID;
import com.sl.utils.List2List;

public class PageManager {
	
public enum Form{
	KARAOKE("karaoke"),
	PROMOACTIONS("promoActions"),
	PROMOCONTENT("promoContent"),
	PROMOSHEDULE("promoSchedule"),
	PROMOINTERFACEID("promoInterfaceId"),
	INTERFACEMENUITEM("interfaceMenuItem"),
	BROADCASTCHANNEL("broadcastChannel"),
	VIDEOMOVIE("videoMovie"),
	VODPACKAGE("vodPackage"),
	ASSETS("assets"),
	AUDIOPID("audioPID"),
	AUDIOPIDtv("audioPIDtv"),
	ASSETSOTT("assetsOTT"),
	SUBTITLES("subtitles"),
	MULTICASTGROUP("multicastGroup"),
	OTTURL("ottUrl"),
	DVBTURL("dvbtUrl");
		Form(String text){
			this.text = text;
		}
		public String text;
		
	}

private WebDriver driver;
public Karaoke karaoke;
public LoginPage loginPage;
public Assets assets;
public AudioPID audioPID;
public AudioPIDtv audioPIDtv;
public BroadcastChannel broadcastChannel;
public PromoActions promoActions;
public VodPackage vodPackage;
public AnyForm anyForm;
public AssetsOTT assetsOTT;
public Subtitles subtitles;
public MulticastGroup multicastGroup;
public OttURL ottUrl;
public DvbtURL dvbtUrl;

public HomePage homePage;
public ParamCopy paramCopy;
public Finder finder;
public Delete delete;

private List2List list2List;
private Combobox combobox;
private Checkbox checkbox;
private LinkedID linkedID;




	
	public PageManager(WebDriver driver){
		this.driver = driver;			
		karaoke = initElements(new Karaoke (this));
		assets = initElements(new Assets (this));
		audioPID = initElements(new AudioPID (this));
		audioPIDtv = initElements(new AudioPIDtv (this));
		broadcastChannel = initElements(new BroadcastChannel(this));
		promoActions = initElements(new PromoActions(this));
		assetsOTT = initElements(new AssetsOTT (this));
		loginPage = initElements(new LoginPage(this));
		homePage = initElements(new HomePage(this));	
		paramCopy = initElements(new ParamCopy(this));
		finder = initElements(new Finder(this));
		delete = initElements(new Delete(this));
		vodPackage =  initElements(new VodPackage(this));
		subtitles = initElements(new Subtitles(this));
		multicastGroup = initElements(new MulticastGroup(this));
		ottUrl = initElements(new OttURL(this));
		dvbtUrl = initElements(new DvbtURL(this));
	}
	
	
	 	private <T extends Page> T initElements(T page) {
		    PageFactory.initElements(driver, page);		   
		    return page;
		  }
		  
		  public WebDriver getWebDriver() {
		    return driver;
		  }
		  public PageManager init(){
			  return new PageManager(getWebDriver());
		  }
		  
		  public List2List getList2List(WebElement element){				 
				  list2List = new List2List(this, element);
			  return list2List;
			 
		  }
		  
		  public Combobox getCombobox(WebElement element){
			  combobox = new Combobox(this, element);
			  return combobox;
		  }
		  
		  public Checkbox getCheckbox(WebElement element){
			  checkbox = new Checkbox(this, element);
			  return checkbox;
		  }
		  public LinkedID getLinkedID(WebElement element){
			  linkedID = new LinkedID(this, element);
			  return linkedID;
		  }
		  
		  
		  
		 public AnyForm getPage(Form form){
			Field[] allFields = this.getClass().getDeclaredFields();			
			for(Field field : allFields){			
				 
				 if(field.getName().equals(form.text)){
					 try {
						return (AnyForm) field.get(this);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						
						e.printStackTrace();
					}					 
				 }			 	
			} 
			return  null;
		}
}
