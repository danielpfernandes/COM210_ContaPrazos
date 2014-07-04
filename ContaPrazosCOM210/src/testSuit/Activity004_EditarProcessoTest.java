package testSuit;
import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class Activity004_EditarProcessoTest extends
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
	public Activity004_EditarProcessoTest() {
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
			assertTrue("Wait for view (index: 12) failed.",
					solo.waitForView(12, 20000));
			solo.clickOnView(12);
			solo.waitForActivity("Activity_VisProcesso");
			
			assertTrue(
					"Wait for button (id: com.example.contaprazoscom112.R.id.btneditarprocesso) failed.",
					solo.waitForButtonById(
							"com.example.contaprazoscom112.R.id.btneditarprocesso",
							20000));
			solo.clickOnButton((Button) solo
					.findViewById("com.example.contaprazoscom112.R.id.btneditarprocesso"));
			solo.waitForActivity("Activity_CadProcesso");			
			
			solo.drag(solo.toScreenX(0.042f), solo.toScreenX(0.033f),
					solo.toScreenY(0.225f), solo.toScreenY(0.754f), 14);			
			
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
					"000111");
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editvara) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editvara",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editvara"),
					"Vara editada");
			
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
					"Jornal editado");
			
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
					"Tribunal editado");
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editcidade) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editcidade",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editcidade"),
					"Cidade editada");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editexpediente) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editexpediente",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editexpediente"),
					"01/10/2014");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.edittitulo) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.edittitulo",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.edittitulo"),
					"Título editado");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editautor) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editautor",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editautor"),
					"Autor editado");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editreu) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editreu",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editreu"),
					"Réu editado");
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
					"Despacho editado");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editprazo) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editprazo",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editprazo"),
					"15");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editdespacho) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editadvogado",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editadvogado"),
					"Advogado editado");
			solo.clickOnImageButton((ImageButton) solo
					.findViewById("com.example.contaprazoscom112.R.id.imageSalvarProcesso"));
			solo.waitForActivity("Activity_ListaProcessos");
			solo.sleep(15000);
		} catch (AssertionFailedError e) {
			solo.fail("EditarProcessoTest.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("EditarProcessoTest.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
