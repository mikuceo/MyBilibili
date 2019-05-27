package com.dvc.mybilibili.mvp.model.api.service.column.entity;

import android.support.annotation.Keep;

import com.alibaba.fastjson.annotation.JSONField;
import com.dvc.mybilibili.mvp.model.api.response.BaseResponse;

@Keep
/* compiled from: BL */
public class ColumnDraftCountData extends BaseResponse {
    @JSONField(name = "count")
    public int count;
}
