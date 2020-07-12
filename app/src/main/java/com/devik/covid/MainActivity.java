package com.devik.covid;

import android.os.*;
import android.support.design.widget.*;
import android.support.v4.view.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import com.devik.covid.adapter.*;
import com.devik.covid.fragments.*;

public class MainActivity extends AppCompatActivity {

	private ViewPagerAdapter mViewPagerAdapter;
	private ViewPager mViewPager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
		
		init();
    }
	
	private void init()
	{
		mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
		addPageInViewPager();
		mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mViewPagerAdapter);
		mViewPager.setOffscreenPageLimit(3);

		TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
	}
	
	private void addPageInViewPager()
	{
		mViewPagerAdapter.addFragment(new WorldFragment(),"World");
		mViewPagerAdapter.addFragment(new CountryFragment(),"Countries");
		mViewPagerAdapter.addFragment(new SymtomsFragment(),"Symtoms");
	}
}
