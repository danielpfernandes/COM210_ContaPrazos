package contaprazoscom112.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.contaprazoscom112.*;
import com.example.contaprazoscom112.R;

public class Activity_LoginTest extends ActivityInstrumentationTestCase2<Activity_Login> {

				
	private Activity_Login mActivity_Login;
	private TextView mFirstTestText;
	
	public Activity_LoginTest() {
		super(Activity_Login.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
			mActivity_Login = getActivity();
			mFirstTestText = (TextView) mActivity_Login.findViewById(R.id.textView1);
	}
	
	public void testActivity_Configuracoes_labelText() {
		final String expected =
				mActivity_Login.getString(R.string.hello_world);
		final String actual = mFirstTestText.getText().toString();
		assertEquals(expected, actual);
	}
}
