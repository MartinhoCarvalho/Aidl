// IRemoteService.aidl
package com.example.martinhocarvalho.myaidlproject;

import com.example.martinhocarvalho.myaidlproject.Product;
//import com.example.martinhocarvalho.myaidlproject.Callback;
import com.example.martinhocarvalho.myaidlproject.ObjectProcess;
// Declare any non-default types here with import statements

interface IRemoteService{

      /** Request the process ID of this service, to do evil things with it. */
      int getPid();

      /** Demonstrates some basic types that you can use as parameters
       * and return values in AIDL.
       */
      void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString);

     /**
      * Add nb(24864)
      */
      int add(in int value1, in int value2);

      void set(in Product obj);

      Product getProduct();

      void setObjectProcess(in ObjectProcess obj);
}
