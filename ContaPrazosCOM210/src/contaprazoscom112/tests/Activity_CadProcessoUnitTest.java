package contaprazoscom112.tests;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

import com.example.contaprazoscom112.Activity_CadProcesso;
import com.example.contaprazoscom112.Activity_Configuracoes;
import com.example.contaprazoscom112.R;

public class Activity_CadProcessoUnitTest extends ActivityUnitTestCase<Activity_CadProcesso>{
	public Activity_CadProcessoUnitTest() {
		super(Activity_CadProcesso.class);
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
