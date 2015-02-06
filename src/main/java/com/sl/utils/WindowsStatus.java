package com.sl.utils;

public class WindowsStatus {
	
	
	/**
	 * Класс необходим для подсчета количества попапов во время выполнения тестов
	 */
	private static WindowsStatus instance = new WindowsStatus();

	private static int popupCount = -1;

	private WindowsStatus(){};

	public int getPC(){ return popupCount;}
	public void defPC(){ popupCount = -1;} 
	public void incPC(){ popupCount++;} 
	public void decPC(){ 
		popupCount--;
	
		try{
		if(popupCount<-1)
			throw new Exception();
		
		}catch(Exception e){
			System.out.println("Popup does not exist. Check you last method"+ this.getClass());
			popupCount = -1;
		}
		
		
	} 
	
	public static  WindowsStatus getInstance(){return instance;}

}
