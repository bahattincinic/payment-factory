package Adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public abstract class PaymentAbstract {
	
	/**
     * Bank  Authenticate information
     * 
     * @return Map<String, String>
    */
	protected Map<String, String> getConfig(String path){
		try {
			Map<String, String> map = new HashMap<String, String>();
			File file = new File(path);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.loadFromXML(fileInput);
			fileInput.close();
			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				map.put(key, value);
			}
			return map;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
