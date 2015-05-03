package ps.ktaha.inoculation;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Children extends Activity {

	
	String names[]={"محمد","عمر","خالد","يوسف","احمد"};
	
	ArrayList<Child> children = new ArrayList<Child>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_children);
		for (int i = 0; i < names.length; i++) {
			int n = i+1;
			Child x = new Child();
			x.setName(names[i]);
			x.setNumber(n);
			children.add(x);
		}
		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/arial.ttf");
		((TextView)findViewById(R.id.header)).setTypeface(tf);
		((TextView)findViewById(R.id.notif)).setTypeface(tf);
		final ListView list = (ListView)findViewById(R.id.childrenList);
		list.setAdapter(new MyAdapter(children));
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> ad, View v, int n,
					long l) {
				String name = (String)list.getItemAtPosition(n);
				Intent intent = new Intent(Children.this,ChildOptions.class);
				intent.putExtra("name", name);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.children, menu);
		return true;
	}
	private class MyAdapter extends BaseAdapter
	{
		ArrayList<Child> children;
		public MyAdapter(ArrayList<Child>childs)
		{
			children=childs;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return children.size();
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return children.get(position).getName();
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = getLayoutInflater().inflate(R.layout.child, null);
			((TextView)view.findViewById(R.id.name)).setText("الطفل "+children.get(position).getName());
			Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/arial.ttf");
			((TextView)view.findViewById(R.id.name)).setTypeface(tf);
			((TextView)view.findViewById(R.id.number)).setText(""+children.get(position).getNumber());
			return view;
		}
	}
	private class Child
	{
		private String name;
		private int number;
		//private String id;
		/*public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		*/
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		
	}
}
