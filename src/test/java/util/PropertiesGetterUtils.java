package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesGetterUtils {

	private Properties prop;
	private String fileExtention;
	private String separator;
	private String projDirectory;
	
	// Constructor
	// opens and loads the file
	// pre: filename without extension
	// post: properties file loaded 
	public PropertiesGetterUtils(String propFileName){

		prop = new Properties();
		fileExtention = ".properties";
		separator = System.getProperty("file.separator");
		projDirectory = System.getProperty("user.dir");
		
		try {
			prop.load(new FileInputStream(projDirectory + separator + "src"
					+ separator + "com" + separator + "webex" + separator
					+ "test" + separator + "config" + separator + propFileName
					+ fileExtention));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Loads property value from a file
	public String loadPropertie(String propName) {
		return prop.getProperty(propName);
	}
}
