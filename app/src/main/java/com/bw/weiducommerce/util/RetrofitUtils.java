package com.bw.weiducommerce.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:单列模式 懒汉
 */
public class RetrofitUtils {
    public static RetrofitUtils retrofitUtils;
    private void RetrofitUtils(){}
    public static RetrofitUtils getInstance(){
        if(retrofitUtils==null){
            //双重锁
            synchronized (RetrofitUtils.class){
                if(retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }
    //返回retrofit
    public static Retrofit getRetrofit(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())//gson工厂
                .build();
        return retrofit;
    }
    public <T> T getApiService (String url,Class<T> service){
        Retrofit retrofit = getRetrofit(url);
        //通过java动态代理获取代理对象
        T t = retrofit.create(service);
        return t;
    }
}
