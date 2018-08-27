package com.lfc.flyindexbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lfc.flyindexbar.citylist.CitySelect_A;
import com.lfc.flyindexbar.exliststyle.ListDemo_A;
import com.lfc.flyindexbar.flylayout.FlowLayout_A;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCitylist;
    private Button mBtnFlylayout;
    private Button mBtnRlvex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnCitylist = (Button) findViewById(R.id.btn_citylist);
        mBtnFlylayout = (Button) findViewById(R.id.btn_flylayout);
        mBtnCitylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                城市列表
                startActivity(new Intent(MainActivity.this, CitySelect_A.class));

            }
        });
        mBtnFlylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//流布局
                startActivity(new Intent(MainActivity.this, FlowLayout_A.class));
            }
        });
        mBtnRlvex = (Button) findViewById(R.id.btn_rlvex);
        mBtnRlvex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//流布局
                startActivity(new Intent(MainActivity.this, ListDemo_A.class));
            }
        });
    }
}
