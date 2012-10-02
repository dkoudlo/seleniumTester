package data.bundle;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
public class TestPropertyBundle extends ResourceBundle{
	protected Properties properties;
	JsonParser parser = new JsonParser();
	Enumeration<String> keys;
	
	public TestPropertyBundleGetter<String> strings;
	public TestPropertyBundleGetter<Integer> integers;
	public TestPropertyBundleGetter<Boolean> booleans;
	public TestPropertyBundleGetter<Long> longs;
	public TestPropertyBundleGetter<String[]> stringArrays;
	
	Gson gson;
	private static final String PATH_TO_CONFIG = "/data/",
			BASE_PROPERTIES_FILE_NAME = "test.properties";
	
	public TestPropertyBundle() {
		this(BASE_PROPERTIES_FILE_NAME);
	}
	
	private TestPropertyBundle(String propertiesFilePath) {
		gson = new Gson();
		addProperties(propertiesFilePath);
		
		strings = new TestPropertyBundleGetter<String>(this, String.class);
		integers = new TestPropertyBundleGetter<Integer>(this, Integer.class);
		booleans = new TestPropertyBundleGetter<Boolean>(this, Boolean.class);
		longs = new TestPropertyBundleGetter<Long>(this, Long.class);
		stringArrays = new TestPropertyBundleGetter<String[]>(this, String[].class);
	}

	@Override
	public Enumeration<String> getKeys() {
		return keys;
	}

	@Override
	protected Object handleGetObject(String key) {
		return properties.getProperty(key);
	}
	
	protected JsonPrimitive getAsPrimitive(String key) {
		JsonPrimitive primitive;
		if(containsKey(key)) {
			primitive = (JsonPrimitive) getObject(key);
		} else {
			primitive = (JsonPrimitive) super.getObject(key);
		}
		return primitive;
	}
	
	public String getAsString(String key) {
		return getAsPrimitive(key).getAsString();
	}
	
	public boolean getAsBoolean(String key) {
		return getAsPrimitive(key).getAsBoolean();
	}
	
	public void addProperties(String propertiesFilePath) {
		URL propertiesFileUrl = this.getClass().getResource(PATH_TO_CONFIG + propertiesFilePath);
		try {
			properties = new Properties();
			properties.load(propertiesFileUrl.openStream());
			Set<Object> objectKeys = properties.keySet();
			String[] sKeys = new String[objectKeys.size()];
			objectKeys.toArray(sKeys);
			Set<String> sKeySet = new HashSet<String>();
			for(int i = 0; i < sKeys.length; i++) {
				sKeySet.add(sKeys[i]);
			}
			keys = Collections.enumeration(sKeySet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public class TestPropertyBundleGetter<T> {
		TestPropertyBundle bundle;
		Class<T> clas;
		public TestPropertyBundleGetter(TestPropertyBundle bundle, Class<T> clas) {
			this.bundle = bundle;
			this.clas = clas;
		}
		
		public T get(String key) {
			T t = (T) bundle.gson.fromJson((String) bundle.getObject(key), clas);
			return t;
		}
		
		@SuppressWarnings("unchecked")
		public List<T> getList(String key) {
			Type listType = new TypeToken<ArrayList<T>>(){}.getType();
			List<T> list = (List<T>) bundle.gson.fromJson((String) bundle.getObject(key), listType);
			return list;
		}
		
		public List<List<T>> getListOfLists(String key) {
			Type listType = new TypeToken<ArrayList<ArrayList<T>>>(){}.getType();
			List<List<T>> list = (List<List<T>>) bundle.gson.fromJson((String) bundle.getObject(key), listType);
			return list;
		}
	}
	
	public static class Salon extends TestPropertyBundle {
		public Salon() {
			super("test_salon.properties");
		}
	}
	
	public static class SalonCa extends TestPropertyBundle {
		public SalonCa() {
			super("salon_ca.properties");
		}
	}
	
	public static class SalonRu extends TestPropertyBundle {
		public SalonRu() {
			super("salon_ru.properties");
		}
	}
	
	public static class SalonRu extends TestPropertyBundle {
		public SalonRu() {
			super("salon_ru.properties");
		}
	}
	
	public static class SalonRu extends TestPropertyBundle {
		public SalonRu() {
			super("salon_ru.properties");
		}
	}
	
	
	
	
}
