package contaprazoscom112.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.contaprazoscom112.*;
import com.example.contaprazoscom112.R;

public class Activity_VisUsuarioTest extends ActivityInstrumentationTestCase2<Activity_VisUsuario> {

				
	private Activity_VisUsuario mActivity_VisUsuario;
	private TextView mFirstTestText;
	
	public Activity_VisUsuarioTest() {
		super(Activity_VisUsuario.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
			mActivity_VisUsuario = getActivity();
			mFirstTestText = (TextView) mActivity_VisUsuario.findViewById(R.id.textView1);
	}
	
	public void testActivity_Configuracoes_labelText() {
		final String expected =
				mActivity_VisUsuario.getString(R.string.hello_world);
		final String actual = mFirstTestText.getText().toString();
		assertEquals(expected, actual);
	}
}
