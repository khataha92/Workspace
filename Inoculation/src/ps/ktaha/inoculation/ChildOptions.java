package ps.ktaha.inoculation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildOptions extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_options);
		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/arial.ttf");
		((TextView)findViewById(R.id.header)).setTypeface(tf);
		((Button)findViewById(R.id.appointments)).setTypeface(tf);
		((Button)findViewById(R.id.setNextAppointment)).setTypeface(tf);
		((Button)findViewById(R.id.vaccineRecords)).setTypeface(tf);
		
	}
	public void goToAppointments(View v)
	{
		Intent intent = new Intent(this,Appointments.class);
		startActivity(intent);
	}
	public void setNextAppointment(View v)
	{
		Intent intent = new Intent(this,SetAppointment.class);
		startActivity(intent);
	}
	public void records(View s)
	{
		Intent intent = new Intent(this,Records.class);
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_options, menu);
		return true;
	}

}
