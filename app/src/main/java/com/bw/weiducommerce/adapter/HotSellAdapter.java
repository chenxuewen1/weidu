package com.bw.weiducommerce.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.weiducommerce.R;
import com.bw.weiducommerce.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:热销新品
 */
public class HotSellAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ShowBean.ResultBean.RxxpBean.CommodityListBean> list;

    public HotSellAdapter(Context context, List<ShowBean.ResultBean.RxxpBean.CommodityListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hotsell_adapter_layout,null,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
        int commodityId = list.get(i).getCommodityId();
        int price = list.get(i).getPrice();
        String commodityName = list.get(i).getCommodityName();
        String masterPic = list.get(i).getMasterPic();
        myViewHolder.name.setText(commodityName);
        myViewHolder.price.setText("￥"+price+".00");
        myViewHolder.image.setImageURI(Uri.parse(masterPic));
        //点击条目
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = myViewHolder.getAdapterPosition();
                if(itemLinsenter!=null){
                    itemLinsenter.itemData(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //自定义viewholder
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView image;
        private final TextView name;
        private final TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hot_adapter_image);
            name = itemView.findViewById(R.id.hot_adapter_name);
            price = itemView.findViewById(R.id.hot_adapter_price);
        }
    }
    //定义接口
    public interface OnItemLinsenter{
        void itemData(int position);
    }
    //声明
    private OnItemLinsenter itemLinsenter;
    //监听
    public void setItemLinsenter(OnItemLinsenter itemLinsenter) {
        this.itemLinsenter = itemLinsenter;
    }
}
