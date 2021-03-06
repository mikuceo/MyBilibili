package com.dvc.mybilibili.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 为ViewPager添加布局（Fragment），绑定和处理fragments和viewpager之间的逻辑关系
 *
 * Created with IntelliJ IDEA.
 * Author: wangjie  email:tiantian.china.2@gmail.com
 * Date: 13-10-11
 * Time: 下午3:03
 */
public class ViewPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener{
    private List<Fragment> fragments; // 每个Fragment对应一个Page
    private ViewPager viewPager; // viewPager对象
    private int currentPageIndex = 0; // 当前page索引（切换之前）
    private List<String> titles = new ArrayList<>();


    private OnExtraPageChangeListener onExtraPageChangeListener; // ViewPager切换页面时的额外功能添加接口

    public ViewPagerAdapter(FragmentManager fragmentManager, ViewPager viewPager , List<Fragment> fragments) {
        super(fragmentManager);
        this.fragments = fragments;
        this.viewPager = viewPager;
        this.viewPager.setAdapter(this);
        this.viewPager.setOnPageChangeListener(this);
    }
    public ViewPagerAdapter(FragmentManager fragmentManager, ViewPager viewPager , List<Fragment> fragments, List<String> titles) {
        super(fragmentManager);
        this.titles = titles;
        this.fragments = fragments;
        this.viewPager = viewPager;
        this.viewPager.setAdapter(this);
        this.viewPager.setOnPageChangeListener(this);
    }
    
    public List<Fragment> replace(int location,Fragment fragment){
    	this.fragments.add(location, fragment);
    	return fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    //坑：fragmentPagerAdapter不可以重写这个，不然会显示不出来
    /*@Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }*/
    
    
    @Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public void setTabTitle(int pos, String title) {
        this.titles.set(pos, title);
    }

    /*@Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    	if(fragments.get(position)!=null){
    		 container.removeView(fragments.get(position).getView()); // 移出viewpager两边之外的page布局
    	}
       
    }*/

    /*@Override
    public Object instantiateItem(ViewGroup container, int position) {
        View fragment = fragments.get(position);
        if(fragment==null){
        	return null;
        }
        if(!fragment.isAdded()){ // 如果fragment还没有added
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(fragment, fragment.getClass().getSimpleName());
            ft.commit();
            *//**
             * 在用FragmentTransaction.commit()方法提交FragmentTransaction对象后
             * 会在进程的主线程中，用异步的方式来执行。
             * 如果想要立即执行这个等待中的操作，就要调用这个方法（只能在主线程中调用）。
             * 要注意的是，所有的回调和相关的行为都会在这个调用中被执行完成，因此要仔细确认这个方法的调用位置。
             *//*
            fragmentManager.executePendingTransactions();
        }

        if(fragment.getView().getParent() == null){
            container.addView(fragment.getView()); // 为viewpager增加布局
        }

        return fragment.getView();
    }*/

    /**
     * 当前page索引（切换之前）
     * @return
     */
    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public OnExtraPageChangeListener getOnExtraPageChangeListener() {
        return onExtraPageChangeListener;
    }

    /**
     * 设置页面切换额外功能监听器
     * @param onExtraPageChangeListener
     */
    public void setOnExtraPageChangeListener(OnExtraPageChangeListener onExtraPageChangeListener) {
        this.onExtraPageChangeListener = onExtraPageChangeListener;
    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {
        if(null != onExtraPageChangeListener){ // 如果设置了额外功能接口
            onExtraPageChangeListener.onExtraPageScrolled(i, v, i2);
        }
    }

    @Override
    public void onPageSelected(int i) {
        /*fragments.get(currentPageIndex).onPause(); // 调用切换前Fargment的onPause()
//        fragments.get(currentPageIndex).onStop(); // 调用切换前Fargment的onStop()
        if(fragments.get(i).isAdded()){
//            fragments.get(i).onStart(); // 调用切换后Fargment的onStart()
            fragments.get(i).onResume(); // 调用切换后Fargment的onResume()
        }*/
        currentPageIndex = i;

        if(null != onExtraPageChangeListener){ // 如果设置了额外功能接口
            onExtraPageChangeListener.onExtraPageSelected(i);
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        if(null != onExtraPageChangeListener){ // 如果设置了额外功能接口
            onExtraPageChangeListener.onExtraPageScrollStateChanged(i);
        }
    }


    /**
     * page切换额外功能接口
     */
    static class OnExtraPageChangeListener{
        public void onExtraPageScrolled(int i, float v, int i2){}
        public void onExtraPageSelected(int i){}
        public void onExtraPageScrollStateChanged(int i){}
    }


}
