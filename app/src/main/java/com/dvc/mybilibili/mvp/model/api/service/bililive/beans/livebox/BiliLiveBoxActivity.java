package com.dvc.mybilibili.mvp.model.api.service.bililive.beans.livebox;

import com.alibaba.fastjson.annotation.JSONField;

import org.jetbrains.annotations.NotNull;




////////@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/bilibili/bililive/videoliveplayer/net/beans/livebox/BiliLiveBoxActivity;", "", "()V", "activityId", "", "activityPic", "", "haveActivityBox", "", "bililiveLiveVideoPlayer_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: BL */
public final class BiliLiveBoxActivity {
    @JSONField(name = "ACTIVITY_ID")
    //@JvmField
    public int activityId;
    @JSONField(name = "ACTIVITY_PIC")
    @NotNull
    //@JvmField
    public String activityPic = "";

    public final boolean haveActivityBox() {
        return this.activityId > 0;
    }
}
