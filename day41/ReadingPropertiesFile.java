package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		// create object of properties class
		Properties propertiesObj = new Properties();
		
		// location of properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/testdata/config.properties");

		// loading properties file
		propertiesObj.load(file);
		
		// reading data from properties file - usually this method
		String url = propertiesObj.getProperty("appurl");
		String email = propertiesObj.getProperty("email");
		String password = propertiesObj.getProperty("password");
		String orderid = propertiesObj.getProperty("orderid");
		String customerid = propertiesObj.getProperty("customerid");
		
		System.out.println(url + " " + email + " " + password + " " + orderid + " " + customerid);
		
		// reading all the keys from properties file
		Set<String> keys = propertiesObj.stringPropertyNames(); // return string format -> set collection; keys should not be duplicated
		System.out.println(keys);
		
		Set<Object> keysObjSet = propertiesObj.keySet(); // this can be anything
		System.out.println(keysObjSet);
		
		// reading all the values from properties file
		Collection<Object> values = propertiesObj.values();
		System.out.println(values);
		
		file.close();
	}

}
