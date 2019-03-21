package com.bw.weiducommerce.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:判断网络
 */
public class NetWork {
    public static boolean isNetWork(Context context){
        ConnectivityManager conn= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();
        if(info!=null){
            return info.isAvailable();
        }
        return false;
    }
}
