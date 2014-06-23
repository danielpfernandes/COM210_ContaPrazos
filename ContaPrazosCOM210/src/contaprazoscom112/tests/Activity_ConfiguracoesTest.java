package contaprazoscom112.tests;


import com.example.contaprazoscom112.*;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.widget.*;

public class Activity_ConfiguracoesTest 
			extends ActivityInstrumentationTestCase2<Activity_Configuracoes> {

				
	private Activity_Configuracoes mActivity_Configuracoes;
	private TextView mFirstTestText;
	
	public Activity_ConfiguracoesTest() {
		super(Activity_Configuracoes.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
			mActivity_Configuracoes = getActivity();
			mFirstTestText = (TextView) mActivity_Configuracoes.findViewById(R.id.textView1);
	}
	
	public void testActivity_Configuracoes_labelText() {
		final String expected =
				mActivity_Configuracoes.getString(R.string.hello_world);
		final String actual = mFirstTestText.getText().toString();
		assertEquals(expected, actual);
	}
}
