package com.bw.weiducommerce.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:单列模式 懒汉加载
 */
public class OkHttpUtil {
    public static OkHttpUtil okHttpUtil=null;
    private void OkHttpUtil (){}
    public static synchronized OkHttpUtil getInstance(){
        if(okHttpUtil==null){
            //双重锁
            synchronized (OkHttpUtil.class){
                if(okHttpUtil==null){
                    okHttpUtil=new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }
    public OkHttpClient getOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("userId","11249")
                                .addHeader("sessionId","155056366467311249")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
        return okHttpClient;
    }
    public  void doGet(String url, Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(5000, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    public  void doPost(String url,String phone,String pwd, Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(5000, TimeUnit.MILLISECONDS).build();
        FormBody formBody = new FormBody.Builder()
                .add("phone",phone)
                .add("pwd",pwd)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
