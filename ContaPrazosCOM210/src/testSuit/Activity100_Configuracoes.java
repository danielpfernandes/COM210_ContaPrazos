package testSuit;

import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;
import android.widget.ImageButton;


public class Activity100_Configuracoes extends ActivityInstrumentationTestCase2<Activity> {

	private static final String LAUNCHER_ACTIVITY_CLASSNAME = "com.example.contaprazoscom112.Splash";
	private static Class<?> launchActivityClass;
	static {
		try {
			launchActivityClass = Class.forName(LAUNCHER_ACTIVITY_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	private ExtSolo solo; // ExtSolo is an extension of Robotium Solo that helps collecting better test execution data during test runs

	@SuppressWarnings("unchecked")
	public Activity100_Configuracoes() {
		super((Class<Activity>) launchActivityClass);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		solo = new ExtSolo(getInstrumentation(), getActivity(), this.getClass()
				.getCanonicalName(), getName());
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
		solo.tearDown();
		super.tearDown();
	}

	public void testRecorded() throws Exception {
		try {
			
			solo.clickOnMenuItem("Configura\u00E7\u00F5es", true);
			solo.waitForActivity("Activity_Configuracoes");
			
			assertTrue(
					"Wait for image button (id: com.example.contaprazoscom112.R.id.imageSalvarConfiguracoes) failed.",
					solo.waitForImageButtonById(
							"com.example.contaprazoscom112.R.id.imageSalvarConfiguracoes",
							20000));
			solo.clickOnImageButton((ImageButton) solo
					.findViewById("com.example.contaprazoscom112.R.id.imageSalvarConfiguracoes"));
			solo.waitForActivity("Activity_ListaProcessos");
			
			solo.clickOnMenuItem("Configura\u00E7\u00F5es", true);
			solo.waitForActivity("Activity_Configuracoes");
			
			assertTrue(
					"Wait for image button (id: com.example.contaprazoscom112.R.id.imageSalvarConfiguracoes) failed.",
					solo.waitForImageButtonById(
							"com.example.contaprazoscom112.R.id.imageSalvarConfiguracoes",
							20000));
			solo.clickOnImageButton((ImageButton) solo
					.findViewById("com.example.contaprazoscom112.R.id.imageSalvarConfiguracoes"));
			solo.waitForActivity("Activity_ListaProcessos");
		} catch (AssertionFailedError e) {
			solo.fail("ConfigCor.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("ConfigCor.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
