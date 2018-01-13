// mainAct.java
 public class MainActivity 	extends AppCompatActivity
 {
 	@Override
 	protected void onCreate(Bundle savedInstanceState)
 	{
 		super.onCreate(savedInstanceState);
 		setContentView(R.layout.activity_main);
 		Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
 		setSupportActionBar(toolbar);

 		final EditText editText=(EditText) findViewById(R.id.editText);
 		Button button=(Button) findViewById(R.id.button);

 		button.setOnClickListener(new View.OnClickListener()
 		{
 			@Override
 			public void onClick(View v)
 			{
 				new SendMessage().execute(editText.getText().toString());
 				editText.getText().clear();
 			}
 		});
 	}
 }