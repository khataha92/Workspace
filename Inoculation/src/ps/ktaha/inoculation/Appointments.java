package ps.ktaha.inoculation;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class Appointments extends Activity {

	ArrayList<Appointment> appointments=new ArrayList<Appointment>();
	String []names={"السل","التهاب الكبد","الحصبة","اليرقان","انفلونزا"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointments);
		for(int i=0;i<names.length;i++)
		{
			Appointment x = new Appointment();
			x.setName(names[i]);
			x.setDate("19/5/2015");
			x.setTime("12:00:00");
			x.setStatus("Comming");
			x.setNumber(""+(i+1));
			appointments.add(x);
		}
		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/arial.ttf");
		((TextView)findViewById(R.id.header)).setTypeface(tf);
		ListView apps = (ListView)findViewById(R.id.appointments);
		apps.setAdapter(new AppointmentAdapter(appointments,this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appointments, menu);
		return true;
	}
	public static class Appointment
	{
		private String name,date,time,number,status;

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}
		
	}
}
