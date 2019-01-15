package com.example.pankajbagariya.servicesfundamental;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String TAG = MyIntentService.class.getSimpleName();
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     *
     */
    public MyIntentService() {
        super("My worker Thread");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate, Thread name: "+ Thread.currentThread().getName());

    }

    @Override
    protected void onHandleIntent( @Nullable Intent intent) {
        Log.i(TAG,"onHandledIntent, Thread name: "+ Thread.currentThread().getName());
        int sleepTime = intent.getIntExtra("sleepTime: ",1);
        int ctr = 1;

        while (ctr < sleepTime){
            Log.i(TAG,"Counter is " + ctr);
            try {
                Thread.sleep(1000);}catch (InterruptedException e){
                e.printStackTrace();
            }ctr++;
    }
}}
