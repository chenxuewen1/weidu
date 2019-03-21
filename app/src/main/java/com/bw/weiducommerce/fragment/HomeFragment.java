package com.bw.weiducommerce.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.weiducommerce.R;
import com.bw.weiducommerce.adapter.HotSellAdapter;
import com.bw.weiducommerce.adapter.MagicAdapter;
import com.bw.weiducommerce.adapter.QualityAdapter;
import com.bw.weiducommerce.bean.ShowBean;
import com.bw.weiducommerce.dataface.GeneralInface;
import com.bw.weiducommerce.presenter.ShowPresenter;
import com.bw.weiducommerce.view.DetailsActivity;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/*Time:2019/3/20
 *Author:chenxuewen
 *Description:首页
 */
public class HomeFragment extends Fragment implements GeneralInface.ShowInface {
    @BindView(R.id.home_re)
    RecyclerView homeRe;
    @BindView(R.id.home_mlsh)
    RecyclerView homeMlsh;
    @BindView(R.id.home_pzsh)
    RecyclerView homePzsh;
    Unbinder unbinder;
    private FlyBanner banner;
    private ShowPresenter showPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        banner = view.findViewById(R.id.home_banner);
        //创建集合
        ArrayList<String> list = new ArrayList<>();
        list.add("http://172.17.8.100/images/small/banner/cj.png");
        list.add("http://172.17.8.100/images/small/banner/hzp.png");
        list.add("http://172.17.8.100/images/small/banner/lyq.png");
        list.add("http://172.17.8.100/images/small/banner/px.png");
        list.add("http://172.17.8.100/images/small/banner/wy.png");
        banner.setImagesUrl(list);
        showPresenter = new ShowPresenter(this);
        showPresenter.showDataPre();
        //创建布局
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        homeRe.setLayoutManager(gridLayoutManager);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        homeMlsh.setLayoutManager(linearLayoutManager);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getActivity(), 2);
        homePzsh.setLayoutManager(gridLayoutManager1);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 返回来的数据
     * @param body
     */
    @Override
    public void onResult(ShowBean body) {
        //热销magic
        ShowBean.ResultBean result = body.getResult();
        ShowBean.ResultBean.RxxpBean rxxp = result.getRxxp();
        final List<ShowBean.ResultBean.RxxpBean.CommodityListBean> commodityList = rxxp.getCommodityList();
        //Log.i("sss",commodityList.toString()+"");
        HotSellAdapter hotSellAdapter = new HotSellAdapter(getActivity(), commodityList);
        hotSellAdapter.setItemLinsenter(new HotSellAdapter.OnItemLinsenter() {
            @Override
            public void itemData(int position) {
                int commodityId = commodityList.get(position).getCommodityId();
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("id",commodityId+"");
                startActivity(intent);
            }
        });
        homeRe.setAdapter(hotSellAdapter);
        //魔力时尚
        ShowBean.ResultBean.MlssBean mlss = result.getMlss();
        final List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList1 = mlss.getCommodityList();
        MagicAdapter magicAdapter = new MagicAdapter(getActivity(), commodityList1);
        magicAdapter.setItemLinsenter(new MagicAdapter.OnItemLinsenter() {
            @Override
            public void itemData(int position) {
                int commodityId = commodityList1.get(position).getCommodityId();
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("id",commodityId+"");
                startActivity(intent);
            }
        });
        homeMlsh.setAdapter(magicAdapter);
        //品质生活
        ShowBean.ResultBean.PzshBean pzsh = result.getPzsh();
        final List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> commodityList2 = pzsh.getCommodityList();
        QualityAdapter qualityAdapter = new QualityAdapter(getActivity(), commodityList2);
        qualityAdapter.setItemLinsenter(new QualityAdapter.OnItemLinsenter() {
            @Override
            public void itemData(int position) {
                int commodityId = commodityList2.get(position).getCommodityId();
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("id",commodityId+"");
                startActivity(intent);
            }
        });
        homePzsh.setAdapter(qualityAdapter);
    }
}
