package com.dvc.mybilibili.mvp.model.api.service.pegasus.entity.modelv2;

import android.support.annotation.Keep;
import android.support.annotation.Nullable;

import com.alibaba.fastjson.annotation.JSONField;
import com.dvc.mybilibili.mvp.model.api.service.pegasus.entity.model.BasicIndexItem;

@Keep
/* compiled from: BL */
public class ParagraphItem extends BasicIndexItem {
    @Nullable
    @JSONField(name = "content")
    public String content;
}
