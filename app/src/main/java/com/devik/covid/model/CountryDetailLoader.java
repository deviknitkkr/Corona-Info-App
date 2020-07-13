package com.devik.covid.model;
import android.content.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.devik.covid.etc.*;
import com.google.gson.*;
import com.google.gson.reflect.*;
import java.util.*;
import org.json.*;
import java.util.function.*;
import java.util.stream.*;

public class CountryDetailLoader
{
	private CallBackListener listener;
	private String url;
	private Context mContext;
	private List<CountryDetail> list;
	private SingletonRequestQueue mSingletonRequestQueue;
	private RequestQueue mRequestQueue;

	public CountryDetailLoader(Context mContext)
	{
		this.mContext = mContext;
		
	}

	public void setCallBackListener(CallBackListener listener)
	{
		this.listener = listener;
		init();
	}

	public void init()
	{
		url = UrlUtils.ALL_COUNTRIES_INFO_URL;
		mSingletonRequestQueue = SingletonRequestQueue.getInstance(mContext);
		mRequestQueue = mSingletonRequestQueue.getRequestQueue();
		list=new ArrayList<CountryDetail>();
		startLoadingFromApi();
	}

	public void startLoadingFromApi()
	{
		//listener.onStartLoading();
		JsonArrayRequest jsonArrayRequest 
			= new JsonArrayRequest( 
			Request.Method.GET, 
			url, 
			null, 
			new Response.Listener<JSONArray>() { 
				@Override
				public void onResponse(JSONArray response) 
				{
					list=(new Gson()).fromJson(response.toString(),new TypeToken<List<CountryDetail>>(){}.getType());
					for(int i=0;i<list.size();i++)
					{
						list.get(i).setRank(i);
					}
					listener.onComplete(list);
				} 
			}, 
			new Response.ErrorListener() { 
				@Override
				public void onErrorResponse(VolleyError error) 
				{ 
					listener.onError(error);		
				} 
			}); 
		mRequestQueue.add(jsonArrayRequest);

	}
	
	public void searchItems(final String str)
	{
		Predicate predicate=new Predicate<CountryDetail>(){

			@Override
			public boolean test(CountryDetail p1)
			{
				if(p1.getCountry().toLowerCase().contains(str.toLowerCase()))
				{
					return true;
				}
				return false;
			}	
		};
		
		listener.onUpdate((List<CountryDetail>)list.stream().filter(predicate).collect(Collectors.toList()));
	}
}
