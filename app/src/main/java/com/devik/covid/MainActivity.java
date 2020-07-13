package com.devik.covid;

import android.os.*;
import android.support.design.widget.*;
import android.support.v4.view.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import com.devik.covid.*;
import com.devik.covid.adapter.*;
import com.devik.covid.fragments.*;
import android.support.v4.app.*;

public class MainActivity extends AppCompatActivity implements android.support.v7.widget.SearchView.OnQueryTextListener
{
	private ViewPagerAdapter mViewPagerAdapter;
	private ViewPager mViewPager;
	private SearchListener mSearchListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
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
		mViewPagerAdapter.addFragment(new WorldFragment(), "World");
		CountryFragment f=new CountryFragment();
		mSearchListener = f.getSearchListener();
		mViewPagerAdapter.addFragment(f, "Countries");
		mViewPagerAdapter.addFragment(new SymtomsFragment(), "Symtoms");
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu)
	{
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
		MenuItem menuitem=menu.findItem(R.id.menu_search);
		android.support.v7.widget.SearchView searchView=(android.support.v7.widget.SearchView)menuitem.getActionView();
		searchView.setOnQueryTextListener(this);
		
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
        int id = item.getItemId();
		if (id == R.id.menu_search){
			return true;
		}

        return super.onOptionsItemSelected(item);
    }

	@Override
	public boolean onQueryTextSubmit(String p1)
	{
		mSearchListener.onSearch(p1);
		return false;
	}

	@Override
	public boolean onQueryTextChange(String p1)
	{
		mSearchListener.onSearch(p1);
		return false;
	}
}
