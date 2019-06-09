package com.dvc.mybilibili.di.module.activity;

import android.arch.lifecycle.Lifecycle;
import android.support.v7.app.AppCompatActivity;

import com.dvc.base.di.PerFragment;
import com.dvc.mybilibili.mvp.ui.activity.LiveRoomActivity;
import com.dvc.mybilibili.mvp.ui.fragment.live.LiveRoomInteractionFragment;
import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle2.LifecycleProvider;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LiveRoomActivityModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract LiveRoomInteractionFragment liveRoomInteractionFragment();

    @Provides
    static AppCompatActivity provideAppComatActivity(LiveRoomActivity activity) {
        return activity;
    }

    @Provides
    static LifecycleProvider<Lifecycle.Event> provideLifecycleProvider(AppCompatActivity mAppCompatActivity) {
        return AndroidLifecycle.createLifecycleProvider(mAppCompatActivity);
    }
}
