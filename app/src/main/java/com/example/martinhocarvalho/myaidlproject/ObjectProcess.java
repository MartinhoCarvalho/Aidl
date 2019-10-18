package com.example.martinhocarvalho.myaidlproject;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class ObjectProcess implements Parcelable, Callback{

    private String mValue;
    private Callback mCallback;



    /**
     * .CTOR
     * @param mCallback
     */
    public ObjectProcess(Callback mCallback) {
        this.mCallback = mCallback;
    }

    private ObjectProcess() { }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {

    }

    public static final Parcelable.Creator<ObjectProcess> CREATOR
            = new Parcelable.Creator<ObjectProcess>() {
        public ObjectProcess createFromParcel(Parcel in) {
            return new ObjectProcess();
        }

        public ObjectProcess[] newArray(int size) {
            return new ObjectProcess[size];
        }
    };

    @Override
    public void printCallback() {
        Log.i("Valor","Teste-------------");
    }

    @Override
    public void printCallback(String value) {
        mValue = value;
        Log.i("Valor","Teste------------- " + "Conn");
    }

    public String getmValue() {
        return mValue;
    }

    public Callback getmCallback() {
        return mCallback;
    }
}
