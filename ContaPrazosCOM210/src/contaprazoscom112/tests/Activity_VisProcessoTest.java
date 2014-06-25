package contaprazoscom112.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.contaprazoscom112.*;
import com.example.contaprazoscom112.R;

public class Activity_VisProcessoTest extends ActivityInstrumentationTestCase2<Activity_VisProcesso> {

				
	private Activity_VisProcesso mActivity_VisProcesso;
	private TextView mFirstTestText;
	
	public Activity_VisProcessoTest() {
		super(Activity_VisProcesso.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
			mActivity_VisProcesso = getActivity();
			mFirstTestText = (TextView) mActivity_VisProcesso.findViewById(R.id.textView1);
	}
	
	public void testActivity_Configuracoes_labelText() {
		final String expected =
				mActivity_VisProcesso.getString(R.string.hello_world);
		final String actual = mFirstTestText.getText().toString();
		assertEquals(expected, actual);
	}
}
