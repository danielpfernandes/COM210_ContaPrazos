package com.example.contaprazoscom112.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.contaprazoscom112.*;
import com.example.contaprazoscom112.R;

public class Activity_CadUsuarioTest extends ActivityInstrumentationTestCase2<Activity_CadUsuario> {

				
	private Activity_CadUsuario mActivity_CadUsuario;
	private TextView mFirstTestText;
	
	public Activity_CadUsuarioTest() {
		super(Activity_CadUsuario.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
			mActivity_CadUsuario = getActivity();
			mFirstTestText = (TextView) mActivity_CadUsuario.findViewById(R.id.textView1);
	}
	
	public void testActivity_Configuracoes_labelText() {
		final String expected =
				mActivity_CadUsuario.getString(R.string.hello_world);
		final String actual = mFirstTestText.getText().toString();
		assertEquals(expected, actual);
	}
}


