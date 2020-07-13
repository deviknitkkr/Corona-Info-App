package com.devik.covid.fragments;

import android.content.*;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import com.devik.covid.*;
import com.devik.covid.model.*;
import com.github.ybq.android.spinkit.sprite.*;
import com.github.ybq.android.spinkit.style.*;
import java.util.*;
import android.support.v7.widget.*;
import com.devik.covid.etc.*;
import com.devik.covid.adapter.*;

public class CountryFragment extends Fragment
{
	private Context mContext;
	private ProgressBar progresbar;
	private RecyclerView mRecyclerView;
	private List<CountryDetail> list;
	private RecyclerViewAdapter adapter;
	private CountryDetailLoader loader;
	
	public CountryFragment()
	{}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		mContext = container.getContext();
		View v=inflater.inflate(R.layout.fragment_country, container, false);
		init(v);
		return v;
	}

	private void init(View v)
	{
		progresbar = v.findViewById(R.id.progresbar);
		Sprite doubleBounce = new DoubleBounce();
		progresbar.setIndeterminateDrawable(doubleBounce);

		mRecyclerView = v.findViewById(R.id.recyclerview);
		mRecyclerView.addItemDecoration(new SpaceItemDecoration(24, mRecyclerView));
		
		list=new ArrayList<CountryDetail>();
		adapter=new RecyclerViewAdapter(list,mContext);
		mRecyclerView.setAdapter(adapter);
		
		loader=new CountryDetailLoader(mContext);
		loader.setCallBackListener(new CallBackListener(){

				@Override
				public void onComplete(List<CountryDetail> response)
				{
					list.addAll(response);
					progresbar.setVisibility(View.GONE);
					adapter.notifyDataSetChanged();
				}

				@Override
				public void onUpdate(List<CountryDetail> response)
				{	
					list.clear();
					list.addAll(response);
					adapter.notifyDataSetChanged();
				}

				@Override
				public void onError(Exception e)
				{
					Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
				}
			});
	}
	
	public SearchListener getSearchListener()
	{
		return new SearchListener(){

			@Override
			public void onSearch(String str)
			{
				loader.searchItems(str);
			}
		};
	}


}

