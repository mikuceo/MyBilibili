package com.dvc.mybilibili.mvp.model.api.service.bililive.beans;

import com.alibaba.fastjson.annotation.JSONField;

import org.jetbrains.annotations.NotNull;




////////@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/bilibili/bililive/videoliveplayer/net/beans/BiliLiveBlsLotteryWin;", "", "()V", "aid", "", "delay", "roomId", "toString", "", "bililiveLiveVideoPlayer_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: BL */
public final class BiliLiveBlsLotteryWin {
    @JSONField(name = "aid")
    //@JvmField
    public int aid;
    @JSONField(name = "delay")
    //@JvmField
    public int delay;
    @JSONField(name = "room_id")
    //@JvmField
    public int roomId;

    @NotNull
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("aid:");
        stringBuilder.append(this.aid);
        stringBuilder.append(", roomId:");
        stringBuilder.append(this.roomId);
        stringBuilder.append(", delay:");
        stringBuilder.append(this.delay);
        return stringBuilder.toString();
    }
}
