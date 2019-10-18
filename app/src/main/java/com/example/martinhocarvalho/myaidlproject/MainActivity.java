package com.example.martinhocarvalho.myaidlproject;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    IRemoteService mIRemoteService;
    private  ServiceConnection mConnection = new ServiceConnection() {
        // Called when the connection with the service is established
        public void onServiceConnected(ComponentName className, IBinder service) {
            // Following the example above for an AIDL interface,
            // this gets an instance of the IRemoteInterface, which we can use to call on the service
            mIRemoteService = IRemoteService.Stub.asInterface(service);

            Log.e("Valor", "Service has unexpectedly connected");

            try {
                Log.i("Valor","MainActivity ----> "+ mIRemoteService.getPid());
                Log.i("Valor","MainActivity ----> "+ mIRemoteService.add(2,10));

                mIRemoteService.set(new Product("Teste1",10, 10));


                ObjectProcess objectProcess = new ObjectProcess(new teste());

                mIRemoteService.setObjectProcess(objectProcess);


                Log.i("Valor","MainActivity ----> "+ objectProcess.getmValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        // Called when the connection with the service disconnects unexpectedly
        public void onServiceDisconnected(ComponentName className) {
            Log.e("Valor", "Service has unexpectedly disconnected");
            mIRemoteService = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Valor","MainActivity ----> "+ android.os.Process.myPid());


        Intent intent = new Intent(this, RemoteService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }



    public class teste implements Callback, Parcelable{

        public teste() {
        }

        public final Parcelable.Creator<teste> CREATOR
                = new Parcelable.Creator<teste>() {
            public teste createFromParcel(Parcel in) {
                return new teste();
            }

            public teste[] newArray(int size) {
                return new teste[size];
            }
        };


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {

        }

        @Override
        public void printCallback() {
            Log.i("Valor","Teste---> in MainActivity");
        }

        @Override
        public void printCallback(String value) {

        }
    }
}
