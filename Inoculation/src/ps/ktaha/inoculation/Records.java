package ps.ktaha.inoculation;

import java.util.ArrayList;

import ps.ktaha.inoculation.Appointments.Appointment;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class Records extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_records);
		ListView records = (ListView)findViewById(R.id.records);
		ArrayList<Appointment> list = new ArrayList<Appointment>();
		Appointment a = new Appointment();
		a.setDate("1/1/2015");
		a.setName("السل");
		a.setNumber("1");
		a.setStatus("Done");
		a.setTime("12:40:00");
		list.add(a);
		a = new Appointment();
		a.setDate("1/2/2015");
		a.setName("انفلونزا");
		a.setNumber("1");
		a.setStatus("Missed");
		a.setTime("-:-:-");
		list.add(a);
		a = new Appointment();
		a.setDate("2/4/2015");
		a.setName("التهاب الكبد");
		a.setNumber("1");
		a.setStatus("Done");
		a.setTime("9:45:00");
		list.add(a);
		records.setAdapter(new AppointmentAdapter(list, this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.records, menu);
		return true;
	}
	
}
