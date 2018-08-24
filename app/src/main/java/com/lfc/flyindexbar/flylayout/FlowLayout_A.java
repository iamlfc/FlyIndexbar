package com.lfc.flyindexbar.flylayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lfc.flyindexbar.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.Set;

public class FlowLayout_A extends AppCompatActivity {

    private TagFlowLayout mFlow01;
    private String[] mVals = new String[]
            {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextViewTextViewTextViewTextViewTextViewTextViewTextViewTextViewTextView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text"};
    private Button mBtnOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);

        initView();
    }

    private void initView() {
        mFlow01 = (TagFlowLayout) findViewById(R.id.flow_01);
        mBtnOver = (Button) findViewById(R.id.btn_over);
        //预先设置选中
        TagAdapter mAdapter = new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                final LayoutInflater mInflater = LayoutInflater.from(FlowLayout_A.this);
                TextView tv = (TextView) mInflater.inflate(R.layout.tv, mFlow01, false);
                tv.setText(s);
                return tv;

            }

        };
        mAdapter.setSelectedList(1, 3, 5);
        mFlow01.setAdapter(mAdapter);
        mBtnOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得所有选中的pos集合
                Set<Integer> setok = mFlow01.getSelectedList();
                StringBuffer sb = new StringBuffer();

                for (Integer integer : setok) {
                    sb.append(integer + ",");

//                    Log.e("--lfc", integer + "");
                }
                Toast.makeText(FlowLayout_A.this, sb.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
