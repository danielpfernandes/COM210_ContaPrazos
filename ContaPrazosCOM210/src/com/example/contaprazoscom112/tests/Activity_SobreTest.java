package com.example.contaprazoscom112.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.contaprazoscom112.*;
import com.example.contaprazoscom112.R;

public class Activity_SobreTest extends ActivityInstrumentationTestCase2<Activity_Sobre> {

				
	private Activity_Sobre mActivity_Sobre;
	private TextView mFirstTestText;
	
	public Activity_SobreTest() {
		super(Activity_Sobre.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
			mActivity_Sobre = getActivity();
			mFirstTestText = (TextView) mActivity_Sobre.findViewById(R.id.textView1);
	}
	
	public void testActivity_Configuracoes_labelText() {
		final String expected =
				mActivity_Sobre.getString(R.string.hello_world);
		final String actual = mFirstTestText.getText().toString();
		assertEquals(expected, actual);
	}
}
