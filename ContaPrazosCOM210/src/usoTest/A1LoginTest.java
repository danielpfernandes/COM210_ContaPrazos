package usoTest;
import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class A1LoginTest extends ActivityInstrumentationTestCase2<Activity> {

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
	public A1LoginTest() {
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
			solo.waitForActivity("Splash");
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editnomelogin) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editnomelogin",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editnomelogin"),
					"Daniel");
			solo.sleep(4700);
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editsenhalogin) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editsenhalogin",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editsenhalogin"),
					"123");
			assertTrue(
					"Wait for checkbox (id: com.example.contaprazoscom112.R.id.checkpermanecer) failed.",
					solo.waitForCheckBoxById(
							"com.example.contaprazoscom112.R.id.checkpermanecer",
							20000));
			solo.clickOnCheckBox((CheckBox) solo
					.findViewById("com.example.contaprazoscom112.R.id.checkpermanecer"));
			assertTrue(
					"Wait for button (id: com.example.contaprazoscom112.R.id.btnLogar) failed.",
					solo.waitForButtonById(
							"com.example.contaprazoscom112.R.id.btnLogar",
							20000));
			solo.clickOnButton((Button) solo
					.findViewById("com.example.contaprazoscom112.R.id.btnLogar"));
		} catch (AssertionFailedError e) {
			solo.fail("LoginTest.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("LoginTest.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
