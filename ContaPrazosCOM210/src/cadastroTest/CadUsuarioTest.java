package cadastroTest;
import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;
import android.widget.EditText;
import android.widget.ImageButton;


public class CadUsuarioTest extends ActivityInstrumentationTestCase2<Activity> {

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
	public CadUsuarioTest() {
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
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editnome) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editnome",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editnome"),
					"Daniel");
			solo.sleep(800);
			solo.drag(solo.toScreenX(0.467f), solo.toScreenX(0.429f),
					solo.toScreenY(0.801f), solo.toScreenY(0.204f), 15);
			solo.sleep(6600);
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editapelido) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editapelido",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editapelido"),
					"Daniel");
			solo.sleep(3000);
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editsenha) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editsenha",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editsenha"),
					"123");
			assertTrue(
					"Wait for image button (id: com.example.contaprazoscom112.R.id.imageSalvarUsuario) failed.",
					solo.waitForImageButtonById(
							"com.example.contaprazoscom112.R.id.imageSalvarUsuario",
							20000));
			solo.clickOnImageButton((ImageButton) solo
					.findViewById("com.example.contaprazoscom112.R.id.imageSalvarUsuario"));
			solo.waitForActivity("Activity_ListaProcessos");
			
		} catch (AssertionFailedError e) {
			solo.fail("SplashTest.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("SplashTest.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
