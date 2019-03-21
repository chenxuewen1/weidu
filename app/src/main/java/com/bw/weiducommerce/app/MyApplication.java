package com.bw.weiducommerce.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
