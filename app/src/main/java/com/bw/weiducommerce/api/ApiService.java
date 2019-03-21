package com.bw.weiducommerce.api;

import com.bw.weiducommerce.bean.DetailsBean;
import com.bw.weiducommerce.bean.ShowBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:接口拼接
 */
public interface ApiService {
    //展示列表
    @GET("commodityList")
    Call<ShowBean> getShows();
    //详情findCommodityDetailsById
    @GET("findCommodityDetailsById")
    Call<DetailsBean> getDetail(@Query("commodityId")String commodityId);
}
