package ps.ktaha.inoculation;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

public class WebService extends AsyncTask<String,String,String> 
{
	public String NameSpace="";
	public String MethodName="";
	SoapObject request;
	SoapSerializationEnvelope envelope;
	HttpTransportSE androidHttpTransport;
	String URL="";
	Activity context;
	public WebService(Activity c,String nameSpace,String method,String url)
	{
		context=c;
		NameSpace=nameSpace;
		MethodName=method;
		request = new SoapObject(NameSpace, MethodName);
		envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
		envelope.setOutputSoapObject(request);
        envelope.dotNet = true;
        URL=url;
        androidHttpTransport = new HttpTransportSE(URL,30000);
	}
	
	public void addProperty(String name,String val)
	{
		request.addProperty(name,val);
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		Login.dlg.dismiss();
	}
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		
		
	}
	@Override
	protected String doInBackground(String... params) {
		try
		{
			androidHttpTransport.call(params[0], envelope);
			SoapObject 	result = (SoapObject)envelope.bodyIn;
			String res = result.getProperty(0).toString();
			Log.d("result", res);
			return 	res;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	void log(String l)
	{
		Log.d("status", l);
	}
}
