package com.devik.covid.model;

public class CountryDetail
{
	private String country;
	private int cases;
	private int todayCases;
	private int deaths;
	private int todayDeaths;
	private int recovered;
	private int active;
	private int critical;
	private int casesPerOneMillion;
	private int deathsPerOneMillion;
	private int totalTests;
	private int testsPerOneMillion;
	private int rank;

	public void setRank(int rank)
	{
		this.rank = rank;
	}

	public int getRank()
	{
		return rank;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCases(int cases)
	{
		this.cases = cases;
	}

	public int getCases()
	{
		return cases;
	}

	public void setTodayCases(int todayCases)
	{
		this.todayCases = todayCases;
	}

	public int getTodayCases()
	{
		return todayCases;
	}

	public void setDeaths(int deaths)
	{
		this.deaths = deaths;
	}

	public int getDeaths()
	{
		return deaths;
	}

	public void setTodayDeaths(int todayDeaths)
	{
		this.todayDeaths = todayDeaths;
	}

	public int getTodayDeaths()
	{
		return todayDeaths;
	}

	public void setRecovered(int recovered)
	{
		this.recovered = recovered;
	}

	public int getRecovered()
	{
		return recovered;
	}

	public void setActive(int active)
	{
		this.active = active;
	}

	public int getActive()
	{
		return active;
	}

	public void setCritical(int critical)
	{
		this.critical = critical;
	}

	public int getCritical()
	{
		return critical;
	}

	public void setCasesPerOneMillion(int casesPerOneMillion)
	{
		this.casesPerOneMillion = casesPerOneMillion;
	}

	public int getCasesPerOneMillion()
	{
		return casesPerOneMillion;
	}

	public void setDeathsPerOneMillion(int deathsPerOneMillion)
	{
		this.deathsPerOneMillion = deathsPerOneMillion;
	}

	public int getDeathsPerOneMillion()
	{
		return deathsPerOneMillion;
	}

	public void setTotalTests(int totalTests)
	{
		this.totalTests = totalTests;
	}

	public int getTotalTests()
	{
		return totalTests;
	}

	public void setTestsPerOneMillion(int testsPerOneMillion)
	{
		this.testsPerOneMillion = testsPerOneMillion;
	}

	public int getTestsPerOneMillion()
	{
		return testsPerOneMillion;
	}
}
