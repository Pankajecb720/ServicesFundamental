package com.example.pankajbagariya.servicesfundamental;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyStartedService extends Service {
    private static final String TAG = MyStartedService.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate, Thread name: "+ Thread.currentThread().getName());


    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        checkMaintThread(intent);
        Log.i(TAG,"on startCommand, Thread name: "+Thread.currentThread().getName());
        int SleepTime= intent.getIntExtra("sleepTime",1);
        return START_STICKY;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind, Thread name: "+Thread.currentThread().getName());

        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy, Thread name: "+Thread.currentThread().getName());
        super.onDestroy();
    }
    class  MyAsyncTask extends AsyncTask<Integer,String,Void>{
    private  final String TAG = MyAsyncTask.class.getSimpleName();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i(TAG,"on startCommand, Thread name: "+Thread.currentThread().getName());
        }
        @Override
        protected Void doInBackground(Integer... params) {
            Log.i(TAG,"on startCommand, Thread name: "+Thread.currentThread().getName());
            int sleepTime = params[0];
            int ctr = 1;

            while (ctr < sleepTime){
                publishProgress("Counter is " + ctr);
                try {
                    Thread.sleep(1000);}catch (InterruptedException e){
                    e.printStackTrace();
                }ctr++;
                }return  null;
            }

        @Override
        protected void onProgressUpdate(String... values) {
            Log.i(TAG,"onProgressUpdate, Thread name: "+Thread.currentThread().getName());
            Toast.makeText(MyStartedService.this, ""+values[0], Toast.LENGTH_SHORT).show();
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            stopSelf();
            Log.i(TAG,"onPostExecute, Thread name: "+Thread.currentThread().getName());
            super.onPostExecute(aVoid);
        }
    }
    protected  void checkMaintThread(Intent intent){
        int sleepTime = intent.getIntExtra("sleepTime: ",1);
        int ctr = 1;


            Log.i(TAG,"Counter is " + ctr);
            try {
                Thread.sleep(sleepTime*10000);
                Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();}catch (InterruptedException e){
                e.printStackTrace();
        }
    }

    }


