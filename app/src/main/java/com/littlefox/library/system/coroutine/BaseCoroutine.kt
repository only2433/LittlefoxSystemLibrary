package com.littlefox.library.system.coroutine

import android.content.Context
import com.littlefox.library.system.async.listener.AsyncListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.*

abstract class BaseCoroutine(protected var context: Context, protected var code : String)
{
    protected lateinit var mSync : Any;
    protected lateinit var mContext : Context;
    protected lateinit var mCode : String;
    protected var isRunning : Boolean? = false;
    protected var asyncListener : AsyncListener? = null;


    init {
        mContext = context;
        mCode = code;
        mSync = Any();
    }



    abstract fun setData(vararg  `object`: Any?);
    abstract fun doInBackground() : Any;

    fun execute()
    {
        var result: Any? = null;
        CoroutineScope(Dispatchers.Main).launch{

            isRunning = false;
            asyncListener!!.onRunningStart(mCode);

            CoroutineScope(Dispatchers.Default).async {
                result = doInBackground();
            }.await();

            isRunning = false;
            asyncListener!!.onRunningEnd(mCode, result);
        }
    }


}