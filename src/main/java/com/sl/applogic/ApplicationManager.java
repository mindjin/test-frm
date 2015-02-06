package com.sl.applogic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import ru.stqa.selenium.factory.WebDriverFactory;

import com.sl.conf.ConfigProperties;
import com.sl.pages.PageManager;
import com.sl.utils.WebDriverLogger;

/**
 * 
 *Мэнеджер который содержит в себе настройки драйвера
 *и инициализацию всех помощников. Для запуска драйвера используется
 *обертка EventFiringWebDriver.
 *
 */
public class ApplicationManager {
	private String baseUrl;
	private Capabilities firefox;
	private WebDriver webdriver;
	private EventFiringWebDriver driver;
	private FormHelper formHelper;
	private NavigationHelper navigationHelper;
	private DataHelper dataHelper;
	private UserHelper userHelper;
	private HomePageHelper homePageHelper;
	
	public ApplicationManager(){
		
		firefox = DesiredCapabilities.firefox();		
		webdriver = WebDriverFactory.getDriver(firefox);
		driver = new EventFiringWebDriver(webdriver);
		driver.register(new WebDriverLogger());
		baseUrl =ConfigProperties.getProperty("url");		
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl); 
		
		formHelper = new FormHelper(this);
		navigationHelper = new NavigationHelper(this);
		dataHelper = new DataHelper(this);
		userHelper = new UserHelper(this);		
		homePageHelper = new HomePageHelper(this);
		
		
		
	}
	
	public HomePageHelper getHomePageHelper(){		
		return homePageHelper;
	}

	public NavigationHelper getNavigationHelper(){
		return navigationHelper;
	}
	
	public FormHelper getFormHelper(){
		return formHelper;
	}
	
	public DataHelper getDataHelper(){
		return dataHelper;
		
	}
	
	public WebDriver getWebDriver(){
		return driver;
	}

	public String getBaseUrl() {
		return baseUrl;
	}
	
	public UserHelper getUserHelper(){
		return userHelper;
	}
	
	public void stop(){
		if(driver != null){
			driver.quit();
		}
	}
	
	public PageManager getPageManager(){
		return new PageManager(getWebDriver());
	}
	

}
