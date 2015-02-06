package com.sl.data;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.sl.utils.Length;


/**
 * Класс записывает в базу данных рандомные значения.
 */
public class RandomValues {
	static Date date = new Date();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
	static Random random = new Random();;
	public String a;
	
	
	public static <T> List<Element> getValues(T t){
		String nameClass = null;
		try{
		
			nameClass = t.getClass().getSimpleName();
		List<Element> field = Factory.getInstance().getElementDAO().getAllField(nameClass);
		
		
		for(Element element:field){
			
			int	valueSize = getAnnotations(t, element.getNameVariable());
			switch(element.getType()){
			case "date": 
					if(element.getName().equals("Окончание")){
						
				String rndDate = generateDate();				
				Factory.getInstance().getElementDAO().updateField(element.getID(),rndDate);}
				
					if(element.getName().equals("Начало"))
					Factory.getInstance().getElementDAO().updateField(element.getID(), sdf.format(date));
					
				break;
			case "textfield":
				String getRandomText = generateText();
				Factory.getInstance().getElementDAO().updateField(element.getID(),"UI_Test_"+nameClass+"_"+getRandomText);
				break;
			case "integer":
				
				String  getRandomNumber = String.valueOf(generateNumber(valueSize));				
				Factory.getInstance().getElementDAO().updateField(element.getID(),getRandomNumber);
				break;
				
			case "double":
				
				String getRandomDouble = String.valueOf(generateDouble(valueSize));
				Factory.getInstance().getElementDAO().updateField(element.getID(),getRandomDouble+"0");
				
			break;
			
			default:
				break;
			}
			
				
			
			
		}
		
		field = Factory.getInstance().getElementDAO().getAllField(nameClass);
		
		
		if(field.isEmpty())
			throw new IllegalArgumentException();	
		return field;
		}catch(ParseException | SQLException e){
			e.printStackTrace();
		}catch(IllegalArgumentException e){
			System.out.println(nameClass+" not found in SQL table");
			e.printStackTrace();
		}
		return null;
		
		
		
	}



	private static String generateDate() throws ParseException {
		Date dateFrom2 = sdf.parse(sdf.format(date));
		Date dateFrom = sdf.parse("30.12.2015 24:24:24");
		long firstDate = dateFrom.getTime();		
		long endDate = dateFrom2.getTime();
		long getAllTime = firstDate - endDate;
		String rndDate = sdf.format(firstDate+random.nextGaussian()*getAllTime);
		return rndDate;
	}
	
	
	private static String generateText(){
	
		
		String getText = "0123456789asdfghjklqwertyuiopzxcvbnm";
		String  rndText = "";
		
	
		for(int i=0;i<10;i++){
			
			int getRandomLength = random.nextInt(getText.length());
			char getLetter = getText.charAt(getRandomLength);
			
			rndText = rndText+getLetter;
		
		
		
	}
		return rndText;
	}
	
	private static Integer generateNumber(int valueSize){
		int rndNumber = random.nextInt(valueSize);
		return rndNumber;		
	}
	
	private static Double generateDouble(int valueSize){
		int rndInt = random.nextInt(valueSize);
		double rndDouble = Double.valueOf(rndInt);
		return rndDouble;
	}
	
	public static String rndNumb(int value){
		String a = String.valueOf(generateNumber(value));
		return a;
	}
	
	private static <T> int getAnnotations(T t, String v){
		Field[] fields = t.getClass().getDeclaredFields();
				for(Field field:fields){
					if(field.getName().equals(v))
					if(field.isAnnotationPresent(Length.class)){
						Length length = field.getAnnotation(Length.class);
						return length.value();
					}
				}
		
		return 9999;
	}

}
