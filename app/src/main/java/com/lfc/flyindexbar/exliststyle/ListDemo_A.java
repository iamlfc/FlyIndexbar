package com.lfc.flyindexbar.exliststyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lfc.flyindexbar.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.lfc.flyindexbar.exliststyle.Adapter_List.SPAN_COUNT_ONE;
import static com.lfc.flyindexbar.exliststyle.Adapter_List.SPAN_COUNT_THREE;

public class ListDemo_A extends AppCompatActivity {

    private TextView mTvEx;
    private RecyclerView mRlv;
    private TextView mTvTop;

    private List<DataInfoM> list_data = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;
    private Adapter_List adapter_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo);
        initView();
        initData();
    }

    private void initData() {
        for (int i = 0; i < new Random().nextInt(20) + 6; i++) {
//            list_data.add(new DataInfoM());
            list_data.add(new DataInfoM(i, i + "个", i % 2, System.currentTimeMillis() + ""));
        }
        adapter_list.notifyDataSetChanged();
    }

    private void initView() {
        mTvEx = (Button) findViewById(R.id.tv_ex);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mTvTop = (TextView) findViewById(R.id.tv_top);
        mTvEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchLayout();
            }
        });
        mTvTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//回到顶部
                mRlv.scrollToPosition(0);
            }
        });
        gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT_ONE);
        adapter_list = new Adapter_List(list_data, gridLayoutManager, ListDemo_A.this);
        mRlv.setAdapter(adapter_list);
        mRlv.setLayoutManager(gridLayoutManager);

    }

    private void switchLayout() {
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_ONE) {
            gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
        } else {
            gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);
        }
        adapter_list.notifyItemRangeChanged(0, adapter_list.getItemCount());
    }

}
