package ps.ktaha.inoculation;


import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

	public static String URL="http://vaccination.azurewebsites.net/WebService/VaccineService.asmx?WSDL"; // this is the url for the web service
	public static ProgressDialog dlg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_login);
		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/arial.ttf");
		((EditText)findViewById(R.id.username)).setTypeface(tf);
		((EditText)findViewById(R.id.password)).setTypeface(tf);
		((Button)findViewById(R.id.login)).setTypeface(tf);
		((TextView)findViewById(R.id.header)).setTypeface(tf);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	public void login(View v)
	{
		new Thread(){
			public void run()
			{
				Login.this.runOnUiThread(new Runnable(){
					public void run()
					{
						dlg = new ProgressDialog(Login.this);
						dlg.setTitle("Loading...");
						dlg.show();
						
					}
				});
				WebService ws = new WebService(Login.this,"http://tempuri.org/","checkLogin",URL);
				String username = ((EditText)findViewById(R.id.username)).getText().toString();
				String password = ((EditText)findViewById(R.id.password)).getText().toString();
				ws.addProperty("id_NO",username);
				ws.addProperty("password", password);
		        try
		        {
		        	String result = ws.execute("http://tempuri.org/checkLogin").get();
		        	JSONArray jsonArray = new JSONArray(result);
		        	JSONObject statusObj = jsonArray.getJSONObject(0);
		        	String status = statusObj.getString("Status");
		        	if(status.equalsIgnoreCase("Success"))
		        		startActivity(new Intent(Login.this,Children.class));
		        	else
		        	{
		        		Login.this.runOnUiThread(new Runnable(){
							public void run()
							{
								Toast.makeText(getBaseContext(), "Username or password is incorrect", Toast.LENGTH_SHORT).show();
							}
						});
		        		
		        	}
		        }catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
			}
		}.start();
		
		
	}
	
}
