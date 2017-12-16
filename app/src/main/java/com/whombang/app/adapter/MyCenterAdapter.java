package com.whombang.app.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.whombang.app.R;
import com.whombang.app.common.entity.MyCenterEntity;
import com.whombang.app.listener.BannerClickListener;
import com.whombang.app.listener.ItemOnClickListener;

import java.util.List;

/**
 * 个人中心适配器
 * Created by sundy.jiang on 2017/11/22.
 */

public class MyCenterAdapter extends VirtualLayoutAdapter{
    int oneFuncs, twoFuncs;
    public List<MyCenterEntity> oneFunctions;
    public List<MyCenterEntity> twoFunctions;
    int totalCount = 0;
    public ItemOnClickListener listener;

    public BannerClickListener bannerClickListener;

    public static final int BANNER_VIEW_TYPE = 0;
    public static final int DIVIDER_VIEW_TYPE = 1;
    public static final int FUN_VIEW_TYPE = 2;
    public MyCenterAdapter(@NonNull VirtualLayoutManager layoutManager,
                       List<MyCenterEntity> oneFunctions,
                       List<MyCenterEntity> twoFunctions,
                       ItemOnClickListener listener,
                       BannerClickListener bannerClickListener) {
        super(layoutManager);
        this.oneFunctions = oneFunctions;
        this.twoFunctions = twoFunctions;
        this.listener = listener;
        this.bannerClickListener = bannerClickListener;

        oneFuncs = oneFunctions.size();
        twoFuncs = twoFunctions.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case BANNER_VIEW_TYPE:
                return new BannerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work_banner, parent, false));
            case DIVIDER_VIEW_TYPE:
                return new DividerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work_divider, parent, false));
            case FUN_VIEW_TYPE:
                return new FuncViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work_func, parent, false));
            default:
                return null;

        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DividerViewHolder) {
            if (position == 1) {
                ((DividerViewHolder) holder).dividerTitle.setText("我的服务");
                ((DividerViewHolder) holder).colorView.setBackgroundColor(Color.parseColor("#F9C025"));
            } else {
                ((DividerViewHolder) holder).dividerTitle.setText("我的功能");
                ((DividerViewHolder) holder).colorView.setBackgroundColor(Color.parseColor("#35A7FF"));
            }
        } else if (holder instanceof FuncViewHolder) {
            if (position > 1 && position < 2 + oneFuncs) {

//                MyCenterEntity fb = oneFunctions.get(position - 2);
//                ((FuncViewHolder) holder).name.setText(fb.name);
//                ((FuncViewHolder) holder).image.setImageResource(fb.image);
            } else if (position > 2 + oneFuncs) {
//                MyCenterEntity fb = twoFunctions.get(position - 2 - 1 - oneFunctions.size());
//                ((FuncViewHolder) holder).name.setText(fb.name);
//                ((FuncViewHolder) holder).image.setImageResource(fb.image);
            }
        }
    }

    @Override
    public int getItemCount() {


        List<LayoutHelper> helpers = getLayoutHelpers();
        if (helpers == null) {
            return 0;
        }
        for (int i = 0; i < helpers.size(); i++) {
            totalCount += helpers.get(i).getItemCount();
        }
        return totalCount;
    }

    @Override
    public int getItemViewType(int position) {
        Log.i("wwwww","position="+position);
        if (position == 0) {
            return BANNER_VIEW_TYPE;
        } else if (position ==5) {
            return DIVIDER_VIEW_TYPE;
        } else {
            return FUN_VIEW_TYPE;
        }
    }
    class BannerViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv;

        public BannerViewHolder(View view) {
            super(view);

           // tv = (TextView) view.findViewById(R.id.login_out);
         //   iv = (ImageView) view.findViewById(R.id.banner_image);
//            tv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    bannerClickListener.onClick(v);
//                }
//            });

        }
    }


    private class DividerViewHolder extends RecyclerView.ViewHolder {

        public TextView dividerTitle;
        public View colorView;


        public DividerViewHolder(View view) {
            super(view);
            colorView = view;
            dividerTitle = (TextView) view.findViewById(R.id.dividerTitle);
        }

        public TextView getText() {
            return dividerTitle;
        }
    }

    private class FuncViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageView image;

        public FuncViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.function_name);
            image = (ImageView) view.findViewById(R.id.function_image);
            if (listener != null)
                view.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        listener.onItemClick(v, getAdapterPosition());
                    }
                });
        }

        public TextView getText() {
            return name;
        }
    }
}
