package com.sl.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import ru.yandex.qatools.allure.annotations.Attachment;

import com.sl.conf.ConfigBase;

/**
 * Класс реализует снятие скриншота средствами селениум. Наследуется от TestListenerAdapter
 *
 */
public class ElementScreenshot extends TestListenerAdapter{
//	WebDriver driver;
//	
//	public ElementScreenshot(WebDriver driver){
//		this.driver = driver;
//	}
	@Override
	public void onTestFailure(ITestResult tr){
		System.out.println(tr.getName()+"================================");
		
		
		Object currentClass = tr.getInstance();
		WebDriver driver = ((ConfigBase) currentClass).getDriver();
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh_mm_ss");
		String value = sdf.format(date);
		File file = new File("target\\snapshot\\"+value+".png");
		File srcFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] srcByte =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		takeScreenshot(srcByte);
//		takeLog();
//		Reporter.log("<a href='../"+result.getName()+".jpg' <img src='../"+result.getName()+".jpg' hight='100' width='100'/> </a>"); 
		try {
			FileUtils.copyFile(srcFile, file);
			Reporter.log("screenshot saved at "+file.getAbsolutePath());
			Reporter.log("<a href='"+file.getAbsolutePath()+"' <img src='"+file.getAbsolutePath()+"' hight='100' width='100'/>"+value+"</a>"); 
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
	}
	
//	@Attachment()
//	private byte[] takeLog(){
//		String log = WebDriverLogger.log.getName();
//		return log.getBytes();
//	}
	
	@Attachment(value="",type="image/png")
	private byte[] takeScreenshot(byte [] screenshot){
		return screenshot;
	}
	
	
}
