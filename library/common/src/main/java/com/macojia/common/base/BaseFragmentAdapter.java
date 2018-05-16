package com.macojia.common.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import com.macojia.common.commonutils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类内的每一个生成的 Fragment 都将保存在内存之中，
 * 因此适用于那些相对静态的页，数量也比较少的那种；
 * 如果需要处理有很多页，并且数据动态性较大、占用内存较多的情况，
 * 应该使用FragmentStatePagerAdapter。
 */
public class BaseFragmentAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private List<String> mTitles;

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> nFragmentList) {
        super(fm);
        this.mFragmentList = nFragmentList;
    }

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> nFragmentList, List<String> mTitles) {
        super(fm);
        this.mTitles = mTitles;
        setFragments(fm, nFragmentList,mTitles);
    }
    //刷新fragment
    public void setFragments(FragmentManager fm,List<Fragment> fragments,List<String> mTitles) {
        this.mTitles = mTitles;
        if (this.mFragmentList != null) {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment f : this.mFragmentList) {
                ft.remove(f);
            }
            ft.commitAllowingStateLoss();
            ft = null;
            fm.executePendingTransactions();
        }
        this.mFragmentList = fragments;
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return !CollectionUtils.isNullOrEmpty(mTitles) ? mTitles.get(position) : "";
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

}
