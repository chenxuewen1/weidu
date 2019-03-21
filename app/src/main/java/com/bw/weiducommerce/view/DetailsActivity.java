package com.bw.weiducommerce.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bw.weiducommerce.R;
import com.bw.weiducommerce.bean.DetailsBean;
import com.bw.weiducommerce.dataface.GeneralInface;
import com.bw.weiducommerce.presenter.DetailPresenter;
/**
 *@time:2019/3/21
 *@author: chenxuewen
 *@description:详情页面
 */
public class DetailsActivity extends AppCompatActivity implements GeneralInface.DetailInface {

    private DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        detailPresenter = new DetailPresenter(this);
        detailPresenter.detailDataPre(id);
    }

    /**
     * 详情数据
     * @param body
     */
    @Override
    public void onResult(DetailsBean body) {
        DetailsBean.ResultBean result = body.getResult();
        Log.i("sss",result.getCommodityName());
    }
}
