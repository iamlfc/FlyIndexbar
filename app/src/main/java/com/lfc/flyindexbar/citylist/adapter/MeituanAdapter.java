package com.lfc.flyindexbar.citylist.adapter;

import android.content.Context;

import com.lfc.flyindexbar.R;
import com.lfc.flyindexbar.citylist.model.MeiTuanBean;
import com.lfc.flyindexbar.citylist.utils.CommonAdapter;
import com.lfc.flyindexbar.citylist.utils.ViewHolder;

import java.util.List;


/**
 * Created by zhangxutong .
 * Date: 16/08/28
 */

public class MeituanAdapter extends CommonAdapter<MeiTuanBean> {
    public MeituanAdapter(Context context, int layoutId, List<MeiTuanBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, final MeiTuanBean cityBean) {
        holder.setText(R.id.tvCity, cityBean.getCity());
    }
}