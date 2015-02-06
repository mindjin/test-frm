package com.sl.conf;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

/**
 * Чтение конфигурационного файла
 *
 */
public class ConfigProperties {
private static Properties PROPERTIES;

static {
	PROPERTIES = new Properties();
	URL props = ClassLoader.getSystemResource("config.properties");
	try {
		
		
		PROPERTIES.load(new InputStreamReader(props.openStream(), "UTF-8"));
		}catch (IOException e){
			
		e.printStackTrace();
		}
}
public static String getProperty(String key){

	return PROPERTIES.getProperty(key);
	
}
}
