package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

	public static Properties properties; 
	public static FileInputStream fis;
	
	public static Properties loadUserProperties() {
		properties = new Properties();
		try {
			fis = new FileInputStream(".\\src/test/resources/user.properties");
			properties.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}catch(IOException i) {
			System.out.println(i.getCause());
		}
		
		return properties;
	}
	
	public static Properties loadEnvironmentProperties() {
		properties = new Properties();
		File sourceFile = new File(".\\src/test/resources/env_configuration.properties");
		try {
		fis = new FileInputStream(sourceFile);
		properties.load(fis);
		}catch(FileNotFoundException i) {
			System.out.println(i.toString());
		}catch(IOException e) {
			System.out.println(e.toString());
		}
		return properties;
	}
}
