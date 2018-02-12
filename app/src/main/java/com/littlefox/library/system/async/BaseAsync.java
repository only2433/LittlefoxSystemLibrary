package com.littlefox.library.system.async;

import android.content.Context;
import android.os.AsyncTask;

import com.littlefox.library.system.async.listener.AsyncListener;

public abstract class BaseAsync extends AsyncTask<Void, Integer, Object>
{
	protected Object mSync = new Object();
	
	protected boolean isRunning = false;
	protected AsyncListener mAsyncListener;
	protected Context mContext;
	protected String mCode;
	
	public BaseAsync(Context context, String code)
	{
		mContext 	= context;
		mCode		= code;
	}

	public abstract void setData(Object... object);
	
	public void setAsyncListener (AsyncListener asyncListener)
	{
		mAsyncListener = asyncListener;
	}
	
	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
		
		if(mAsyncListener != null)
		{
			mAsyncListener.onRunningStart(mCode);
		}
		
		isRunning = false;
	}
	

	@Override
	protected void onPostExecute(Object result)
	{
		super.onPostExecute(result);
		
		if(mAsyncListener != null && result != null)
		{
			mAsyncListener.onRunningEnd(mCode, result);
		}
		
		isRunning = false;
	}


	@Override
	protected void onProgressUpdate(Integer... values)
	{
		super.onProgressUpdate(values);
		
		if(mAsyncListener != null )
		{
			mAsyncListener.onRunningProgress(mCode, values[0]);
		}
	}


	@Override
	protected void onCancelled()
	{
		super.onCancelled();
		
		if(mAsyncListener != null )
		{
			mAsyncListener.onRunningCanceled(mCode);
		}
	}
	
	

}
