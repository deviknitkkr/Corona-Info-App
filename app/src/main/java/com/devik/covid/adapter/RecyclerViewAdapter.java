package com.devik.covid.adapter;

import android.content.*;
import android.graphics.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.devik.covid.*;
import com.devik.covid.model.*;
import java.util.*;
import java.util.function.*;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
	private Context mContext;
	private List<CountryDetail> list;

	public RecyclerViewAdapter(List<CountryDetail> list , Context mContext){
		
		this.mContext=mContext;
		this.list=list;
	}
	
	@Override
	public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup p1, int p2)
	{
		View v=LayoutInflater.from(mContext).inflate(R.layout.row_item,p1,false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(RecyclerViewAdapter.ViewHolder p1, int p2)
	{
		CountryDetail tmp=list.get(p2);
		
		p1.country_name.setText(tmp.getCountry());
		p1.country_case.setText(Integer.toString(tmp.getCases())+" | "+Integer.toString(tmp.getTodayCases()));
		p1.country_death.setText(Integer.toString(tmp.getDeaths())+" | "+Integer.toString(tmp.getTodayDeaths()));
		p1.country_recover.setText(Integer.toString(tmp.getRecovered()));
		p1.country_active.setText(Integer.toString(tmp.getActive()));
		p1.serial_no.setText(Integer.toString(tmp.getRank()));
		p1.setIsRecyclable(true);
	}

	@Override
	public int getItemCount()
	{
		return list.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder{
		
		TextView country_name;
		TextView country_case;
		TextView country_death;
		TextView country_recover;
		TextView country_active;
		TextView serial_no;
		RelativeLayout country_bg;
		
		public ViewHolder(View v)
		{
			super(v);
			country_name=v.findViewById(R.id.country_name);
			country_case=v.findViewById(R.id.country_case);
			country_death=v.findViewById(R.id.country_death);
			country_recover=v.findViewById(R.id.country_recover);
			country_active=v.findViewById(R.id.country_active);
			country_bg=v.findViewById(R.id.country_bg);
			serial_no=v.findViewById(R.id.serial_no);
			
		}
	}
}
