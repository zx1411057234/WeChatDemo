package com.example.zhongxiong.com.wechatdemo.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import java.util.ArrayList;

/**
 * Created by 牧羊人 on 2018/6/25.
 */

public class FragmentCollector {
    private int containerId;
    private FragmentManager fm;
private ArrayList<Fragment> fragments=null;

    private static FragmentCollector fragmentCollector;

    public FragmentCollector(FragmentActivity activity, int containerId) {
        this.containerId = containerId;
        fm = activity.getSupportFragmentManager();
        intiFragment();
    }

    private void intiFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new UserFragment());
        fragments.add(new SearchFragment());
        fragments.add(new MessageFragment());

        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments) {
            ft.add(containerId, fragment);
        }
        ft.commit();
    }



    public static FragmentCollector getIntance(FragmentActivity activity, int containerId) {
        if (fragmentCollector == null) {
            fragmentCollector = new FragmentCollector(activity, containerId);
        }
        return fragmentCollector;
    }

    public void hideFragment(){
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                ft.hide(fragment);
            }
        }
        ft.commit();
    }
    public void showFragment(int position){
        hideFragment();
        Fragment fragment = fragments.get(position);
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commit();
    }

    public Fragment getFragment(int position){
        return fragments.get(position);
    }
}
