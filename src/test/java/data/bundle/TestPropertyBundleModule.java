package data.bundle;

import java.util.Locale;
import java.util.ResourceBundle.Control;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class TestPropertyBundleModule extends AbstractModule {
	Control control;
	
	public TestPropertyBundleModule() {
		control = new TestPropertyBundleControl();
	}
	
	@Override
	protected void configure() {
		bindProperties();
		// Note: to enable country-specific property injection, uncomment the code below
		bindProperties("us", getUs());
		bindProperties("ca", getCa());
		bindProperties("ru", getRu());
	}
	
	// binds a test property bundle class to the generic test property bundle
	private void bindProperties() {
		binder().bind(TestPropertyBundle.class).toInstance(getTestPropertyBundle());
	}

	// binds a test property bundle class to the test property bundle annotated with a particular name
	private void bindProperties(String form, TestPropertyBundle properties) {
		binder().bind(TestPropertyBundle.class).annotatedWith(Names.named(form)).toInstance(properties);
	}
	
	// test property bundle constructors
	private TestPropertyBundle getTestPropertyBundle() { return new TestPropertyBundle(); }
	private TestPropertyBundle getUs() { return (TestPropertyBundle) TestPropertyBundle.getBundle("us", Locale.US, control); }
	private TestPropertyBundle getCa() { return (TestPropertyBundle) TestPropertyBundle.getBundle("ca", Locale.US, control); }
	private TestPropertyBundle getRu() { return (TestPropertyBundle) TestPropertyBundle.getBundle("ru", Locale.US, control); }
}
