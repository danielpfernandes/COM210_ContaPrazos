package contaprazoscom112.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import com.example.contaprazoscom112.Activity_CadProcesso;
import com.example.contaprazoscom112.R;

public class Activity_CadProcessoTest extends ActivityInstrumentationTestCase2<Activity_CadProcesso> {

				
	private Activity_CadProcesso mActivity_CadProcesso;
	private EditText mFirstTestText;
	
	public Activity_CadProcessoTest() {
		super(Activity_CadProcesso.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
			mActivity_CadProcesso = getActivity();
			mFirstTestText = (EditText) mActivity_CadProcesso.findViewById(R.id.editnome);
	}
	
	public void testActivity_CadProcesso_labelText() {
		final String expected =
				mActivity_CadProcesso.getString(R.id.textnome);
		final String actual = mFirstTestText.getText().toString();
		assertEquals(expected, actual);
	}
}

