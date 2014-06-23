package contaprazoscom112.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.contaprazoscom112.*;
import com.example.contaprazoscom112.R;

public class Activity_ListaProcessosTest extends ActivityInstrumentationTestCase2<Activity_ListaProcessos> {

				
	private Activity_ListaProcessos mActivity_ListaProcessos;
	private TextView mFirstTestText;
	
	public Activity_ListaProcessosTest() {
		super(Activity_ListaProcessos.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
			mActivity_ListaProcessos = getActivity();
			mFirstTestText = (TextView) mActivity_ListaProcessos.findViewById(R.id.textView1);
	}
	
	public void testActivity_Configuracoes_labelText() {
		final String expected =
				mActivity_ListaProcessos.getString(R.string.hello_world);
		final String actual = mFirstTestText.getText().toString();
		assertEquals(expected, actual);
	}
}


