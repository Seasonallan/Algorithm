package com.season.algorithm.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.season.algorithm.R;

import java.util.List;

public abstract class MainAdapter extends RecyclerView.Adapter<MainAdapter.VH> {

    private List<Bean> mList;
    public MainAdapter(List<Bean> items){
        this.mList = items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        VH viewHolder = new VH(view);
        return viewHolder;
    }

    /**
     * 判断position对应的Item是否是组的第一项
     *
     * @param position
     * @return
     */
    public boolean isItemHeader(int position) {
        if (position == 0) {
            return true;
        } else {
            //判断上一个数据的组别和下一个数据的组别是否一致，如果不一致则是不同组，也就是为第一项（头部）
            if (mList.get(position - 1).groupName.equals(mList.get(position).groupName)) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, final int position) {
        holder.textView.setText(mList.get(position).name);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemCLicked(position, mList.get(position));
            }
        });
    }

    /**
     * 点击事件
     * @param position
     */
    protected abstract void onItemCLicked(int position, Bean bean);

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public String getGroupName(int position) {
        return mList.get(position).groupName;
    }

    public static class VH extends RecyclerView.ViewHolder {
        TextView textView;

        public VH(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_tv);
        }
    }

}
