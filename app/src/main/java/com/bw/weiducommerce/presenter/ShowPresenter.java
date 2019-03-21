package com.bw.weiducommerce.presenter;

import com.bw.weiducommerce.bean.ShowBean;
import com.bw.weiducommerce.dataface.GeneralInface;
import com.bw.weiducommerce.model.ShowModel;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:展示逻辑
 */
public class ShowPresenter {

    private final ShowModel showModel;
    private final GeneralInface.ShowInface showInface;

    public ShowPresenter(GeneralInface.ShowInface onResult){
        showModel = new ShowModel();
        showInface = onResult;
    }
    public void showDataPre() {
        showModel.showModelData();
        showModel.setShowLisenter(new ShowModel.OnShowLisenter() {
            @Override
            public void onResult(ShowBean body) {
                showInface.onResult(body);
            }
        });
    }
}
