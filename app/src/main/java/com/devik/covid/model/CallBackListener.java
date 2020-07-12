package com.devik.covid.model;

import java.util.*;

public interface CallBackListener
{
	//public void onStartLoading();
	public void onComplete(List<CountryDetail> list);
	public void onUpdate(List<CountryDetail> list);
	public void onError(Exception e);
}
