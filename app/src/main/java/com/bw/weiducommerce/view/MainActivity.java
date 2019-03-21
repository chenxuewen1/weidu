package com.bw.weiducommerce.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bw.weiducommerce.R;
import com.bw.weiducommerce.fragment.CircleFragment;
import com.bw.weiducommerce.fragment.HomeFragment;
import com.bw.weiducommerce.fragment.MyFragment;
import com.bw.weiducommerce.fragment.OrderFragment;
import com.bw.weiducommerce.fragment.ShoppingFragment;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radio;
    private HomeFragment homeFragment;
    private MyFragment myFragment;
    private OrderFragment orderFragment;
    private ShoppingFragment shoppingFragment;
    private CircleFragment circleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //管理者
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        radio = findViewById(R.id.radiogroup);
        homeFragment = new HomeFragment();
        myFragment = new MyFragment();
        orderFragment = new OrderFragment();
        shoppingFragment = new ShoppingFragment();
        circleFragment = new CircleFragment();
        transaction.add(R.id.frag,homeFragment);
        transaction.add(R.id.frag,circleFragment);
        transaction.add(R.id.frag,shoppingFragment);
        transaction.add(R.id.frag,orderFragment);
        transaction.add(R.id.frag,myFragment);
        transaction.show(homeFragment).hide(circleFragment).hide(shoppingFragment).hide(orderFragment).hide(myFragment);
        //提交
        transaction.commit();
//默认第一个
        radio.check(radio.getChildAt(0).getId());
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //管理者
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (checkedId){
                    case R.id.radio0:
                        transaction.show(homeFragment).hide(circleFragment).hide(shoppingFragment).hide(orderFragment).hide(myFragment).commit();
                        break;
                    case R.id.radio1:
                        transaction.hide(homeFragment).show(circleFragment).hide(shoppingFragment).hide(orderFragment).hide(myFragment).commit();
                        break;
                    case R.id.radio2:
                        transaction.hide(homeFragment).hide(circleFragment).show(shoppingFragment).hide(orderFragment).hide(myFragment).commit();
                        break;
                    case R.id.radio3:
                        transaction.hide(homeFragment).hide(circleFragment).hide(shoppingFragment).show(orderFragment).hide(myFragment).commit();
                        break;
                    case R.id.radio4:
                        transaction.hide(homeFragment).hide(circleFragment).hide(shoppingFragment).hide(orderFragment).show(myFragment).commit();
                        break;
                }
            }
        });

    }
}
