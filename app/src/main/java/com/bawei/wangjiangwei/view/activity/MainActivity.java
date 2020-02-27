package com.bawei.wangjiangwei.view.activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.base.BaseActivity;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
import com.bawei.wangjiangwei.view.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IHomeContract.IView {

    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.vp)
    ViewPager vp;
    List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void initData() {

        HomeFragment instance = HomeFragment.getInstance(1);
        HomeFragment instance1 = HomeFragment.getInstance(2);

        fragments.add(instance);
        fragments.add(instance1);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                }
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void Success(HomeEntity homeEntity) {

    }

    @Override
    public void Error(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}
