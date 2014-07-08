package testSuit;

import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;


public class Activity005_VisProcessoTest extends ActivityInstrumentationTestCase2<Activity> {

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
	public Activity005_VisProcessoTest() {
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
			assertTrue("Wait for view (index: 12) failed.",
					solo.waitForView(12, 20000));
			solo.clickOnView(12);
			solo.waitForActivity("Activity_VisProcesso");
			solo.sleep(10000);
		} catch (AssertionFailedError e) {
			solo.fail("VisProcesso.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("VisProcesso.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
