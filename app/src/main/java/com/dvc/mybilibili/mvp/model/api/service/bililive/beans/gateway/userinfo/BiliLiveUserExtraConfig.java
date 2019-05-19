package com.dvc.mybilibili.mvp.model.api.service.bililive.beans.gateway.userinfo;

import android.support.annotation.Keep;

import com.alibaba.fastjson.annotation.JSONField;




@Keep
////////@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/userinfo/BiliLiveUserExtraConfig;", "", "()V", "showBag", "", "showVipBroadCast", "bililiveLiveVideoPlayer_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: BL */
public final class BiliLiveUserExtraConfig {
    @JSONField(name = "show_bag")
    //@JvmField
    public boolean showBag;
    @JSONField(name = "show_vip_broadcast")
    //@JvmField
    public boolean showVipBroadCast;
}
