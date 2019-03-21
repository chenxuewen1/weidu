package com.bw.weiducommerce.presenter;


import com.bw.weiducommerce.model.LoginModel;
import com.bw.weiducommerce.dataface.GeneralInface;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:登录逻辑
 */
public class LoginPresenter {

    private final LoginModel loginModel;
    private final GeneralInface generalInface;

    public LoginPresenter(GeneralInface onResult){
        loginModel = new LoginModel();
        generalInface = onResult;
    }
    public void loginDataPre(String phone, String pwd) {
        loginModel.loginModelData(phone,pwd);
        loginModel.setLoginLinsenter(new LoginModel.OnLoginLinsenter() {
            @Override
            public void onResult(String dada) {
                generalInface.onResult(dada);
            }
        });
    }
}
