package testSuit;
import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;
import android.widget.EditText;
import android.widget.ImageButton;


public class Activity002_CadProcessosTest extends
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
	public Activity002_CadProcessosTest() {
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
			/*solo.drag(solo.toScreenX(0.042f), solo.toScreenX(0.033f),
					solo.toScreenY(0.225f), solo.toScreenY(0.754f), 14);*/			
			
			solo.drag(solo.toScreenX(0.304f), solo.toScreenX(0.221f),
					solo.toScreenY(0.335f), solo.toScreenY(0.999f), 16);
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editnumprocesso) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editnumprocesso",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editnumprocesso"),
					"000001");
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editvara) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editvara",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editvara"),
					"1a. Vara Cível");
			
			solo.drag(solo.toScreenX(0.590f), solo.toScreenX(0.617f),
					solo.toScreenY(0.335f), solo.toScreenY(0.045f), 26);
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editjornal) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editjornal",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editjornal"),
					"DJ-TRF1");
			
			solo.drag(solo.toScreenX(0.688f), solo.toScreenX(0.710f),
					solo.toScreenY(0.349f), solo.toScreenY(0.126f), 15);
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.edittribunal) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.edittribunal",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.edittribunal"),
					"TRF1");
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editcidade) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editcidade",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editcidade"),
					"Alpinopolis");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editexpediente) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editexpediente",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editexpediente"),
					"01/07/2014");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.edittitulo) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.edittitulo",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.edittitulo"),
					"ALIENACAO PARENTAL");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editautor) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editautor",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editautor"),
					"Alberto Roberto");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editreu) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editreu",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editreu"),
					"Adrieli Adriane");
			solo.drag(solo.toScreenX(0.688f), solo.toScreenX(0.710f),
					solo.toScreenY(0.349f), solo.toScreenY(0.126f), 15);
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editdespacho) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editdespacho",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editdespacho"),
					"Ao autor, para se manifestar sobre a contestacao");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editprazo) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editprazo",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editprazo"),
					"10");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editdespacho) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editadvogado",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editadvogado"),
					"Adalberto Afonso");
			solo.drag(solo.toScreenX(0.640f), solo.toScreenX(0.735f),
					solo.toScreenY(0.796f), solo.toScreenY(0.324f), 20);
			solo.clickOnImageButton((ImageButton) solo
					.findViewById("com.example.contaprazoscom112.R.id.imageSalvarProcesso"));
			solo.waitForActivity("Activity_ListaProcessos");
			solo.sleep(5200);
		} catch (AssertionFailedError e) {
			solo.fail("CadProcessosTest.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("CadProcessosTest.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
