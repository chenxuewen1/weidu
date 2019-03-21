package com.bw.weiducommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bw.weiducommerce.R;


/*Time:2019/3/20
 *Author:chenxuewen
 *Description:自定义搜索框
 */
public class SearchView extends LinearLayout {

    private EditText data;
    private ImageView feilei;
    private Button search;

    public SearchView(Context context) {
        super(context);
    }

    public SearchView(Context context,AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.custom_search_layout,null,false);
        addView(view);
        initView();
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 控件数据
     */
    private void initView() {
        data = findViewById(R.id.custom_search_data);
        feilei = findViewById(R.id.custom_search_fenlei);
        search = findViewById(R.id.custom_search_search);
        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String dada = data.getText().toString().trim();
                //回调
                if(searchLinsenter!=null){
                    searchLinsenter.searchData(dada);
                }
            }
        });
        feilei.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "别点我，再点我就生气了啊！", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //定义接口
    public interface OnSearchLinsenter{

        void searchData(String dada);
    }
    //声明接口
    private  OnSearchLinsenter searchLinsenter;
    //监听
    public void setSearchLinsenter(OnSearchLinsenter searchLinsenter) {
        this.searchLinsenter = searchLinsenter;
    }
}
