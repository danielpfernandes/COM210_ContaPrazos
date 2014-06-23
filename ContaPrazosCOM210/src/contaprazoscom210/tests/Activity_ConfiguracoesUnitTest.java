package contaprazoscom210.tests;

import com.example.contaprazoscom112.R;
import com.example.contaprazoscom210.Activity_Configuracoes;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

public class Activity_ConfiguracoesUnitTest extends ActivityUnitTestCase<Activity_Configuracoes>{
	public Activity_ConfiguracoesUnitTest() {
		super(Activity_Configuracoes.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent mLaunchIntent = new Intent (getInstrumentation().getTargetContext(), Activity_Configuracoes.class);
		startActivity(mLaunchIntent, null, null);
		final Button botaoEditar = (Button) getActivity().findViewById(R.id.btnEditar);
		botaoEditar.performClick();
		
		final Intent launchIntent = getStartedActivityIntent();
		assertNotNull("Intent não foi null", launchIntent);
		assertTrue(isFinishCalled());		
		
	}
	
	
	
	
	
}
