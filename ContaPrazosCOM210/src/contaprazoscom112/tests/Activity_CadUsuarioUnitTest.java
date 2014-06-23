package contaprazoscom112.tests;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

import com.example.contaprazoscom112.Activity_CadUsuario;
import com.example.contaprazoscom112.R;

public class Activity_CadUsuarioUnitTest extends ActivityUnitTestCase<Activity_CadUsuario>{
	public Activity_CadUsuarioUnitTest() {
		super(Activity_CadUsuario.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent mLaunchIntent = new Intent (getInstrumentation().getTargetContext(), Activity_CadUsuario.class);
		startActivity(mLaunchIntent, null, null);
		final Button botaoEditar = (Button) getActivity().findViewById(R.id.btnEditar);
		botaoEditar.performClick();
		
		final Intent launchIntent = getStartedActivityIntent();
		assertNotNull("Intent não foi null", launchIntent);
		assertTrue(isFinishCalled());		
		
	}	
}
