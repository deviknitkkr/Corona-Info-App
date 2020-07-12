package com.devik.covid.fragments;
import android.content.*;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import com.devik.covid.*;

public class SymtomsFragment extends Fragment
{
	private Context mContext;
	
	public SymtomsFragment()
	{}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		mContext=container.getContext();
		View v=inflater.inflate(R.layout.fragment_symtoms,container,false);
		
		return v;
	}
	
	
}
