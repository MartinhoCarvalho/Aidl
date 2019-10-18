package com.example.martinhocarvalho.myaidlproject;

import android.os.Parcelable;

public interface Callback {
    void printCallback();

    void printCallback(String value);

    interface invokeCallback{
        void returnValue(Callback iCallback, String value);
    }
}
