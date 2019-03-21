package com.bw.weiducommerce.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.weiducommerce.R;
import com.bw.weiducommerce.presenter.LoginPresenter;
import com.bw.weiducommerce.dataface.GeneralInface;
import com.bw.weiducommerce.util.PhoneUtil;

import org.json.JSONException;
import org.json.JSONObject;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginView extends AppCompatActivity implements View.OnClickListener, GeneralInface {

    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_checkbox)
    CheckBox loginCheckbox;
    @BindView(R.id.login_reg)
    TextView loginReg;
    @BindView(R.id.login_log)
    Button loginLog;
    private SharedPreferences sp;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        ButterKnife.bind(this);
        //sp
        sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        initData();
        loginPresenter = new LoginPresenter(this);
    }

    /**
     * 数据
     */
    private void initData() {
        loginLog.setOnClickListener(this);
        loginReg.setOnClickListener(this);
        String phone1 = sp.getString("loginPhone", "");
        String pwd1 = sp.getString("loginPwd", "");
        if(sp.getBoolean("记住密码",false)){
            loginPwd.setText(pwd1);
        }
        loginPhone.setText(phone1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_log:
                String phone = loginPhone.getText().toString().trim();
                String pwd = loginPwd.getText().toString().trim();
                boolean b = PhoneUtil.isMobile(phone);
                //进行非空判断
                if(phone.equals("") && pwd.equals("")){
                    Toast.makeText(this, "手机号或密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!b){
                    if(phone.length()!=11){
                        Toast.makeText(this, "手机号应为十一位", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        Toast.makeText(this, "手机格式不正确", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }  if(pwd.length()<3){
                Toast.makeText(this, "最少输入三位数", Toast.LENGTH_SHORT).show();
                return;
            }
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("记住密码",loginCheckbox.isChecked());
                edit.putString("loginPhone",phone);
                edit.putString("loginPwd",pwd);
                edit.commit();
                loginPresenter.loginDataPre(phone,pwd);
                //跳转
                startActivity(new Intent(LoginView.this,RegisterActivity.class));
                finish();
                break;
        }
    }

    /**
     * 返回来的数据
     * @param dada
     */
    @Override
    public void onResult(String dada) {
        try {
            JSONObject jsonObject = new JSONObject(dada);
            String message = jsonObject.getString("message");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
