package data.bundle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class TestPropertyBundleControl extends ResourceBundle.Control {
	private HashMap<String, Class<?>> bundleClassMap = null;
	
	public TestPropertyBundleControl() {
		bundleClassMap = new HashMap<String, Class<?>>();
		Class<?>[] classes = TestPropertyBundle.class.getDeclaredClasses();
		for(Class<?> clas : classes) {
			bundleClassMap.put(clas.getSimpleName().toLowerCase(), clas);
		}
	}
	
	public Set<String> getBundleKeySet() {
		return bundleClassMap.keySet();
	}
	
	public TestPropertyBundle getBundleByKey(String bundleKey) {
		//System.out.println("bundleKey: " + bundleKey);
		//System.out.println(getBundleKeySet());
		if(bundleClassMap.containsKey(bundleKey)) {
			try {
				System.out.println("");
				return (TestPropertyBundle) bundleClassMap.get(bundleKey).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException, IOException {
		TestPropertyBundle propertyBundle = getBundleByKey(baseName);
		if(propertyBundle == null) {
			return new TestPropertyBundle();
		} else {
			return propertyBundle;
		}
	}

	
}
