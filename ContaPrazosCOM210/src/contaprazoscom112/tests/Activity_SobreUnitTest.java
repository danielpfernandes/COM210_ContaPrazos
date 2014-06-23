package contaprazoscom112.tests;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

import com.example.contaprazoscom112.*;
import com.example.contaprazoscom112.R;

public class Activity_SobreUnitTest extends ActivityUnitTestCase<Activity_Sobre>{
	public Activity_SobreUnitTest() {
		super(Activity_Sobre.class);
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

