package com.sl.applogic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.sl.pages.PageManager;
import com.sl.utils.JavaScripts;


/**
 * 
 * Класс создает экземпляр класса PageManager
 *
 */
public class DriverBasedHelper {
	
	WebDriver driver;
	PageManager pageManager;
	
	public DriverBasedHelper(WebDriver driver){
		this.driver = driver;
		pageManager = new PageManager(driver);		
	}
	

}
