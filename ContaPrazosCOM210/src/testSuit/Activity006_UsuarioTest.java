package testSuit;
import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class Activity006_UsuarioTest extends ActivityInstrumentationTestCase2<Activity> {

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
	public Activity006_UsuarioTest() {
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
		try  {
			assertTrue(
					"Wait for image button (id: com.example.contaprazoscom112.R.id.imageUser) failed.",
					solo.waitForImageButtonById(
							"com.example.contaprazoscom112.R.id.imageUser",
							20000));
			solo.clickOnImageButton((ImageButton) solo
					.findViewById("com.example.contaprazoscom112.R.id.imageUser"));
			solo.waitForActivity("Activity_VisUsuario");
			solo.sleep(6900);
			assertTrue(
					"Wait for button (id: com.example.contaprazoscom112.R.id.btnEditar) failed.",
					solo.waitForButtonById(
							"com.example.contaprazoscom112.R.id.btnEditar",
							20000));
			solo.clickOnButton((Button) solo
					.findViewById("com.example.contaprazoscom112.R.id.btnEditar"));
			solo.waitForActivity("Activity_CadUsuario");			
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editcpf) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editnome", 20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editnome"),
					"Joao da Silva");
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editcpf) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editcpf", 20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editcpf"),
					"123.456.789-10");
			
			solo.drag(solo.toScreenX(0.817f), solo.toScreenX(0.854f),
					solo.toScreenY(0.595f), solo.toScreenY(0.374f), 13);
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editendereco) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editendereco",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editendereco"),
					"Rua dos Bobos, no. Zero");
			
			solo.drag(solo.toScreenX(0.560f), solo.toScreenX(0.606f),
					solo.toScreenY(0.454f), solo.toScreenY(0.273f), 14);
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editcelular) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editcelular",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editcelular"),
					"(12) 345-6789");
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editemail) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editemail",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editemail"),
					"foo@example.com");
			
			solo.drag(solo.toScreenX(0.502f), solo.toScreenX(0.525f),
					solo.toScreenY(0.352f), solo.toScreenY(0.207f), 14);
			
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editnumoab) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editnumoab",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editnumoab"),
					"234.987");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editapelido) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editapelido",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editapelido"),
					"Joao");
			assertTrue(
					"Wait for edit text (id: com.example.contaprazoscom112.R.id.editsenha) failed.",
					solo.waitForEditTextById(
							"com.example.contaprazoscom112.R.id.editsenha",
							20000));
			solo.enterText(
					(EditText) solo
							.findViewById("com.example.contaprazoscom112.R.id.editsenha"),
					"321");
			solo.sleep(1700);
			solo.drag(solo.toScreenX(0.429f), solo.toScreenX(0.529f),
					solo.toScreenY(0.465f), solo.toScreenY(0.246f), 22);
			assertTrue(
					"Wait for image button (id: com.example.contaprazoscom112.R.id.imageSalvarUsuario) failed.",
					solo.waitForImageButtonById(
							"com.example.contaprazoscom112.R.id.imageSalvarUsuario",
							20000));
			solo.clickOnImageButton((ImageButton) solo
					.findViewById("com.example.contaprazoscom112.R.id.imageSalvarUsuario"));
			solo.waitForActivity("Activity_ListaProcessos");
			assertTrue(
					"Wait for image button (id: com.example.contaprazoscom112.R.id.imageUser) failed.",
					solo.waitForImageButtonById(
							"com.example.contaprazoscom112.R.id.imageUser",
							20000));
			solo.clickOnImageButton((ImageButton) solo
					.findViewById("com.example.contaprazoscom112.R.id.imageUser"));
			solo.waitForActivity("Activity_VisUsuario");
			solo.sleep(6900);
		} catch (AssertionFailedError e) {
			solo.fail("Usuario.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("Usuario.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
