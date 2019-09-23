package com.sinothk.treeView.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.sinothk.treeView.Node;
import com.sinothk.treeView.TreeRecyclerAdapter;
import com.sinothk.treeView.demo.R;

import java.util.List;

/**
 * Created by zhangke on 2017-1-14.
 */
public class SimpleTreeRecyclerAdapter extends TreeRecyclerAdapter {

    public SimpleTreeRecyclerAdapter(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel, int iconExpand, int iconNoExpand) {
        super(mTree, context, datas, defaultExpandLevel, iconExpand, iconNoExpand);
    }

    public SimpleTreeRecyclerAdapter(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel) {
        super(mTree, context, datas, defaultExpandLevel);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.list_item, null));
    }

    @Override
    public void onBindViewHolder(final Node node, RecyclerView.ViewHolder holder, int position) {

        final MyHolder viewHolder = (MyHolder) holder;

        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChecked(node, viewHolder.cb.isChecked());
            }
        });

        if (node.isChecked()) {
            viewHolder.cb.setChecked(true);
        } else {
            viewHolder.cb.setChecked(false);
        }

        if (node.getIcon() == -1) {
            viewHolder.cb.setVisibility(View.VISIBLE);
            viewHolder.icon.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.cb.setVisibility(View.INVISIBLE);

            viewHolder.icon.setVisibility(View.VISIBLE);
            viewHolder.icon.setImageResource(node.getIcon());
        }

        viewHolder.label.setText(node.getName());
    }

    class MyHolder extends RecyclerView.ViewHolder {

        CheckBox cb;
        TextView label;
        ImageView icon;

        MyHolder(View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.cb_select_tree);
            label = itemView.findViewById(R.id.id_treenode_label);
            icon = itemView.findViewById(R.id.icon);
        }
    }
}
