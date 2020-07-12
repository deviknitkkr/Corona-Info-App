package com.devik.covid.model;
import android.content.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.devik.covid.etc.*;
import com.google.gson.*;
import com.google.gson.reflect.*;
import java.util.*;
import org.json.*;

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
					listener.onUpdate(list);
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


}
