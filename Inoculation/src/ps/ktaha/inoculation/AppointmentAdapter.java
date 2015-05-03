package ps.ktaha.inoculation;

import java.util.ArrayList;

import ps.ktaha.inoculation.Appointments.Appointment;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class AppointmentAdapter extends BaseAdapter
{
	Activity act;
	ArrayList<Appointment> appointments;
	public AppointmentAdapter(ArrayList<Appointment> app,Activity a)
	{
		appointments=app;
		act=a;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return appointments.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return appointments.get(position).getName();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		convertView = act.getLayoutInflater().inflate(R.layout.appointment, null);
		String status = appointments.get(position).getStatus();
		if(status.equalsIgnoreCase("Missed"))
		{
			int red = Color.parseColor("#9C0000");
			((TextView)convertView.findViewById(R.id.name)).setTextColor(red);
			((TextView)convertView.findViewById(R.id.date)).setTextColor(red);
			((TextView)convertView.findViewById(R.id.time)).setTextColor(red);
			((TextView)convertView.findViewById(R.id.numx)).setTextColor(red);
			((TextView)convertView.findViewById(R.id.number)).setTextColor(red);
		}
		else
		{
			int green = Color.parseColor("#00ff00");
			((TextView)convertView.findViewById(R.id.name)).setTextColor(green);
			((TextView)convertView.findViewById(R.id.numx)).setTextColor(green);
			((TextView)convertView.findViewById(R.id.date)).setTextColor(green);
			((TextView)convertView.findViewById(R.id.time)).setTextColor(green);
			((TextView)convertView.findViewById(R.id.number)).setTextColor(green);
		}
		Typeface typeface = Typeface.createFromAsset(act.getAssets(), "fonts/arial.ttf");

		((TextView)convertView.findViewById(R.id.name)).setTypeface(typeface);
		((TextView)convertView.findViewById(R.id.name)).setText(appointments.get(position).getName());
		((TextView)convertView.findViewById(R.id.date)).setText(appointments.get(position).getDate());
		((TextView)convertView.findViewById(R.id.time)).setText(appointments.get(position).getTime());
		((TextView)convertView.findViewById(R.id.number)).setText(appointments.get(position).getNumber());
		return convertView;
	}
	
}

