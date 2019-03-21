package com.bw.weiducommerce.model;

import com.bw.weiducommerce.api.Api;
import com.bw.weiducommerce.api.ApiService;
import com.bw.weiducommerce.bean.DetailsBean;
import com.bw.weiducommerce.util.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*Time:2019/3/21
 *Author:chenxuewen
 *Description:详情数据
 */
public class DetailModel {

    public void detailModelData(String id) {
        ApiService apiService = RetrofitUtils.getInstance().getApiService(Api.detailUrl, ApiService.class);
        Call<DetailsBean> call = apiService.getDetail(id);
        call.enqueue(new Callback<DetailsBean>() {
            @Override
            public void onResponse(Call<DetailsBean> call, Response<DetailsBean> response) {
                DetailsBean body = response.body();
                if(detailLinsenter!=null){
                    detailLinsenter.onResult(body);
                }
            }

            @Override
            public void onFailure(Call<DetailsBean> call, Throwable t) {

            }
        });
    }
    //定义接口
    public interface OnDetailLinsenter{

        void onResult(DetailsBean body);
    }
    //声明接口
    private  OnDetailLinsenter detailLinsenter;
    //监听
    public void setDetailLinsenter(OnDetailLinsenter detailLinsenter) {
        this.detailLinsenter = detailLinsenter;
    }
}
