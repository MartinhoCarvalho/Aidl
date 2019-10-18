package com.example.martinhocarvalho.myaidlproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Return the interface

        return mBinder;
    }

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {

        Product mProduct;

        public int getPid(){
            return android.os.Process.myPid();
        }
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) {
            // Does nothing
        }

        @Override
        public int add(int value1,int value2) throws RemoteException {
            return value1 + value2;
        }

        @Override
        public void set(Product obj) throws RemoteException {
            mProduct = obj;
        }

        @Override
        public Product getProduct(){
            return  mProduct;
        }

        @Override
        public void setObjectProcess(ObjectProcess obj) throws RemoteException {
            listener.returnValue(obj, "xxxxxxxxxx");

            //obj.getmCallback().printCallback();
        }

    };



    Callback.invokeCallback  listener = new Callback.invokeCallback(){

        @Override
        public void returnValue(Callback iCallback, String value) {
            iCallback.printCallback(value);
        }
    };

}

