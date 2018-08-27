package com.lfc.flyindexbar.exliststyle;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lfc.flyindexbar.R;

import java.util.List;

/**
 * Created by LFC
 * on 2018/8/27.
 */

public class Adapter_List extends RecyclerView.Adapter<Adapter_List.ItemViewHolder> {
    public static final int SPAN_COUNT_ONE = 1;
    public static final int SPAN_COUNT_THREE = 3;

    private static final int VIEW_TYPE_LIST = 1;
    private static final int VIEW_TYPE_Grid = 2;

    private List<DataInfoM> mItems;
    private GridLayoutManager mLayoutManager;
    private Activity baseContext;

    public Adapter_List(List<DataInfoM> mItems, GridLayoutManager mLayoutManager, Activity baseContext) {
        this.mItems = mItems;
        this.mLayoutManager = mLayoutManager;
        this.baseContext = baseContext;
    }

    @Override
    public int getItemViewType(int position) {
        int spanCount = mLayoutManager.getSpanCount();
        if (spanCount == SPAN_COUNT_ONE) {
            return VIEW_TYPE_LIST;

        } else {
            return VIEW_TYPE_Grid;
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_LIST) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_type1, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_type2, parent, false);
        }

        return new ItemViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        DataInfoM item = mItems.get(position);
        holder.title.setText(item.get名字());
        holder.note.setText(item.get数量()+"");
        if (getItemViewType(position) == VIEW_TYPE_LIST) {
            holder.info.setText(item.get时间());
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView title;
        TextView note;
        TextView info;

        ItemViewHolder(View itemView, int viewType) {
            super(itemView);
            if (viewType == VIEW_TYPE_LIST) {
                iv = (ImageView) itemView.findViewById(R.id.img_item1);
                title = (TextView) itemView.findViewById(R.id.tv_title_item1);
                note = (TextView) itemView.findViewById(R.id.tv_note_item1);
                info = (TextView) itemView.findViewById(R.id.tv_info_item1);
            } else {
                iv = (ImageView) itemView.findViewById(R.id.img_item2);
                title = (TextView) itemView.findViewById(R.id.tv_title_item2);
                note = (TextView) itemView.findViewById(R.id.tv_note_item2);
            }
        }
    }

}
