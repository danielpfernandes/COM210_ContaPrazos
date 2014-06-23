package contaprazoscom112.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.contaprazoscom112.Activity_CadProcesso;
import com.example.contaprazoscom112.R;

public class Activity_CadProcessoTest extends ActivityInstrumentationTestCase2<Activity_CadProcesso> {

				
	private Activity_CadProcesso mActivity_CadProcesso;
	private TextView mFirstTestText;
	
	public Activity_CadProcessoTest() {
		super(Activity_CadProcesso.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
			mActivity_CadProcesso = getActivity();
			mFirstTestText = (TextView) mActivity_CadProcesso.findViewById(R.id.textView1);
	}
	
	public void testActivity_Configuracoes_labelText() {
		final String expected =
				mActivity_CadProcesso.getString(R.string.hello_world);
		final String actual = mFirstTestText.getText().toString();
		assertEquals(expected, actual);
	}
}

