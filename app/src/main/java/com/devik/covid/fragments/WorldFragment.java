package com.devik.covid.fragments;

import android.content.*;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.devik.covid.*;
import com.devik.covid.etc.*;
import me.everything.android.ui.overscroll.*;
import org.json.*;

public class WorldFragment extends Fragment
{
	private Context mContext;
	private SingletonRequestQueue mSingletonRequestQueue;
	private RequestQueue mRequestQueue;
	private TextView total_case;
	private TextView total_death;
	private TextView total_recover;
	private String url;
	public WorldFragment()
	{}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		mContext=container.getContext();
		View v=inflater.inflate(R.layout.fragment_world,container,false);
		
		init(v);
		
		return v;
	}
	
	public void init(View v)
	{
		mSingletonRequestQueue=SingletonRequestQueue.getInstance(mContext);
		mRequestQueue=mSingletonRequestQueue.getRequestQueue();
		
		ScrollView scrollview=v.findViewById(R.id.scrollview);
		OverScrollDecoratorHelper.setUpOverScroll(scrollview);
		total_case=v.findViewById(R.id.total_case);
		total_death=v.findViewById(R.id.total_death);
		total_recover=v.findViewById(R.id.total_recover);
		url=UrlUtils.GLOBAL_INFO_URL;
		loadData();
		
	}
	
	public void loadData ()
	{
		JsonObjectRequest 
			jsonObjectRequest 
			= new JsonObjectRequest( 
			Request.Method.GET, 
			url, 
			null, 
			new Response.Listener<JSONObject>() { 
				@Override
				public void onResponse(JSONObject response) 
				{ 
					try
					{   total_case.setVisibility(View.VISIBLE);
						total_case.setText(response.get("cases").toString());
						
						total_death.setVisibility(View.VISIBLE);
						total_death.setText(response.get("deaths").toString());
						
						total_recover.setVisibility(View.VISIBLE);
						total_recover.setText(response.get("recovered").toString());
						//Toast.makeText(mContext,"success",Toast.LENGTH_SHORT).show();
					}
					catch (JSONException e)
					{}
				} 
			}, 
			new Response.ErrorListener() { 
				@Override
				public void onErrorResponse(VolleyError error) 
				{ 
					Toast.makeText(mContext,error.getMessage(),Toast.LENGTH_SHORT).show();
				} 
			}); 
		mRequestQueue.add(jsonObjectRequest);
	}
}
