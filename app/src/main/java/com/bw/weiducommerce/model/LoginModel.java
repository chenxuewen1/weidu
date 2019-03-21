package com.bw.weiducommerce.model;

import android.os.Handler;
import android.os.Message;

import com.bw.weiducommerce.api.Api;
import com.bw.weiducommerce.util.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:登录获取数据
 */
public class LoginModel {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json = (String) msg.obj;
                    if(loginLinsenter!=null){
                        loginLinsenter.onResult(json);
                    }
                    break;
            }
        }
    };
    public void loginModelData(String phone, String pwd) {
        OkHttpUtil.getInstance().doPost(Api.loginUrl, phone, pwd, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message = new Message();
                message.what=0;
                message.obj=json;
                handler.sendMessage(message);
            }
        });
    }
    //定义接口
    public interface OnLoginLinsenter{

        void onResult(String dada);
    }
    //声明接口
    private  OnLoginLinsenter loginLinsenter;
    //监听
    public void setLoginLinsenter(OnLoginLinsenter loginLinsenter) {
        this.loginLinsenter = loginLinsenter;
    }
}
