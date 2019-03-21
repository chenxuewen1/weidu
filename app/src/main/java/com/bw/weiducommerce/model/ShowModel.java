package com.bw.weiducommerce.model;

import com.bw.weiducommerce.api.Api;
import com.bw.weiducommerce.api.ApiService;
import com.bw.weiducommerce.bean.ShowBean;
import com.bw.weiducommerce.util.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:获取网络数据
 */
public class ShowModel {

    public void showModelData() {
        ApiService apiService = RetrofitUtils.getInstance().getApiService(Api.showUrl, ApiService.class);
        Call<ShowBean> call = apiService.getShows();
        call.enqueue(new Callback<ShowBean>() {
            @Override
            public void onResponse(Call<ShowBean> call, Response<ShowBean> response) {
                //成功
                ShowBean body = response.body();
                if(showLisenter!=null){
                    showLisenter.onResult(body);
                }
            }

            @Override
            public void onFailure(Call<ShowBean> call, Throwable t) {
                //失败的数据
            }
        });
    }
    //定义接口
    public interface OnShowLisenter{

        void onResult(ShowBean body);
    }
    //声明
    private OnShowLisenter showLisenter;
    //监听
    public void setShowLisenter(OnShowLisenter showLisenter) {
        this.showLisenter = showLisenter;
    }
}
