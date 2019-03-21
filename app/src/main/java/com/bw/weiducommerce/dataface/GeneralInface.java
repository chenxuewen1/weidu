package com.bw.weiducommerce.dataface;

import com.bw.weiducommerce.bean.DetailsBean;
import com.bw.weiducommerce.bean.ShowBean;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:m层的数据
 */
public interface GeneralInface {
    void onResult(String dada);
    interface ShowInface{
        void onResult(ShowBean body);
    }
    interface DetailInface{
        void onResult(DetailsBean body);
    }
}
