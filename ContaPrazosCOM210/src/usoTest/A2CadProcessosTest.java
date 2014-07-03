package usoTest;
import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;
import android.widget.EditText;
import android.widget.ImageButton;


public class A2CadProcessosTest extends
		ActivityInstrumentationTestCase2<Activity> {

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
	public A2CadProcessosTest() {
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
					"Wait for image button (id: com.example.contaprazoscom112.R.id.imageAdd) failed.",
					solo.waitForImageButtonById(
							"com.example.contaprazoscom112.R.id.imageAdd",
							200));
			solo.clickOnImageButton((ImageButton) solo
					.findViewById("com.example.contaprazoscom112.R.id.imageAdd"));
			solo.waitForActivity("Activity_CadProcesso");			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editadvogado) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editadvogado",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editadvogado"),
					"Daniel");			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editprazo) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editprazo",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editprazo"),
					"10");						
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editnumprocesso) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editnumprocesso",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editnumprocesso"),
					"6789");			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editvara) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editvara",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editvara"),
					"Civel");
			/*assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.txtdata) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.txtdata",
							200));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.txtdata"),
					"10/07/2014");*/
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editjonral) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editjornal",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editjornal"),
					"DJMG");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.edittribunal) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.edittribunal",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.edittribunal"),
					"TJMG");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editcidade) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editcidade",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editcidade"),
					"Itajubá");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editautor) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editautor",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editautor"),
					"Fulano de Tal");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editreu) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editreu",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editreu"),
					"Beltrano de tal");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editreu) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editreu",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editdespacho"),
					"Vista ao autor, para se manifestar sobre a defesa");
			assertTrue(
					"Wait for image button (id: com.example.contaprazoscom112.R.id.imageSalvarProcesso) failed.",
					solo.waitForImageButtonById(
							"com.example.contaprazoscom112.R.id.imageSalvarProcesso",
							20));
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editreu) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editexpediente",
							20));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editexpediente"),
					"10/07/2014");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editreu) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.edittitulo",
							200));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.edittitulo"),
					"Ação de Usucapião");
			solo.clickOnImageButton((ImageButton) solo
					.findViewById("com.example.contaprazoscom112.R.id.imageSalvarProcesso"));
			solo.waitForActivity("Activity_ListaProcessos");
			solo.sleep(19200);
		} catch (AssertionFailedError e) {
			solo.fail("CadProcessosTest.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("CadProcessosTest.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
