package com.littlefox.library.system.version_check;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MarketVersionCheck extends AsyncTask<Void, Void, Boolean>
{
	private final String URL = "https://play.google.com/store/apps/details?id=";

	private MarketVersionCheckListener mMarketVersionCheckListener;
	private String mReceivePackageVersion 	= "";
	private String mSearchPackageUrl 		= "";
	
	
	public MarketVersionCheck(String packageName)
	{
		mSearchPackageUrl = URL + packageName;
	}
	
	public void setMarketVersionCheckListener(MarketVersionCheckListener marketVersionCheckListener)
	{
		mMarketVersionCheckListener = marketVersionCheckListener;
	}
	
	@Override
	protected void onPreExecute()
	{
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	@Override
	protected Boolean doInBackground(Void... params)
	{
		String result = "";
		StringBuilder html = new StringBuilder();
		HttpURLConnection conn=null;

		try {
			URL url = new URL(mSearchPackageUrl);
			conn = (HttpURLConnection) url.openConnection();

			if (conn != null) {
				conn.setConnectTimeout(1000);
				conn.setUseCaches(false);
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));

					for (;;) {
						String line = br.readLine();
						if (line == null)
							break;
						html.append(line + '\n');
					}

					br.close();
				}
				//conn.disconnect();
			}

		 } catch (Exception e) {
			   // TODO Auto-generated catch block
			   
			   mMarketVersionCheckListener.onFail(e.getMessage());
			   
			  }finally{
			   conn.disconnect(); //접속 종료
			  }
		
		int start, end;
		// return html.toString();
		try{
			
		start = html.indexOf("softwareVersion")+"softwareVersion".length() + 2;
		end=html.indexOf("</div>", start);
		result=html.substring(start, end);
		result=result.replace(" ", "");
		}catch(Exception e){
			e.printStackTrace();
			result="";
		}
		mReceivePackageVersion = result;
		return true;
	}
	
	@Override
	protected void onPostExecute(Boolean result)
	{
		super.onPostExecute(result);
		
		if(result)
		{
			mMarketVersionCheckListener.onSuccess(mReceivePackageVersion);
		}
	}

	@Override
	protected void onCancelled()
	{
		super.onCancelled();
	}

}
