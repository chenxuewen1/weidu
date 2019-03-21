package com.bw.weiducommerce.presenter;

import com.bw.weiducommerce.bean.DetailsBean;
import com.bw.weiducommerce.dataface.GeneralInface;
import com.bw.weiducommerce.model.DetailModel;

/*Time:2019/3/21
 *Author:chenxuewen
 *Description:详情逻辑
 */
public class DetailPresenter {

    private final DetailModel detailModel;
    private final GeneralInface.DetailInface detailInface;

    public DetailPresenter(GeneralInface.DetailInface onResult){
        detailModel = new DetailModel();
        detailInface = onResult;
    }
    public void detailDataPre(String id) {
        detailModel.detailModelData(id);
        detailModel.setDetailLinsenter(new DetailModel.OnDetailLinsenter() {
            @Override
            public void onResult(DetailsBean body) {
                detailInface.onResult(body);
            }
        });
    }
}
