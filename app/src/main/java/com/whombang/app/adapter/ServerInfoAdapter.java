package com.whombang.app.adapter;

import com.whombang.app.R;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.entity.ServiceInfoEntity;

/**
 * Created by David on 2017/12/26.
 */

public class ServerInfoAdapter extends BaseQuickAdapter<ServiceInfoEntity.ProviderUserInfoListBean,BaseViewHolder> {
    public ServerInfoAdapter() {
        super(R.layout.wb_service_info_item_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, ServiceInfoEntity.ProviderUserInfoListBean item, int position) {

    }
}
