package com.example.administrator.testapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.nineoldandroids.view.ViewHelper;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SimpleFragmentPagerAdapter pagerAdapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //必须使用集合
        final ArrayList<ScrollAbleFragment> fragmentList = new ArrayList<>();
        fragmentList.add(new PageFragment());
        fragmentList.add(new PageFragment());
        fragmentList.add(new PageFragment());


        pagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this,fragmentList);
        final ScrollableLayout scrollableLayout = (ScrollableLayout) findViewById(R.id.scrollableLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        final ImageView   imageHeader = (ImageView)findViewById(R.id.iv);

        //进来的时候要默认选中一个
        scrollableLayout.getHelper().setCurrentScrollableContainer(fragmentList.get(0));

        scrollableLayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                ViewHelper.setTranslationY(imageHeader, (float) (currentY * 0.5));
            }
        });

//======================================================================================================

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override public void onPageSelected(int position) {
                Log.e("asaa",pagerAdapter.getItem(position)+"");
                //设置当前container
                // 这里比较坑的是必须用ArrayList集合来封装要显示的fragment，并且详情界面的fragment要实现接口
                scrollableLayout.getHelper().setCurrentScrollableContainer(fragmentList.get(position));
            }

            @Override public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
