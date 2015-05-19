package com.example.touristbg;

import tabs.SlidingTabLayout;
import tabs.TabsPagerAdapter;

import DataBase.FillDB;

import android.content.SharedPreferences;

import android.os.Bundle;

import android.support.v4.app.FragmentActivity;

import android.support.v4.view.ViewPager;
import android.view.WindowManager;

public class MainActivity extends FragmentActivity {
TabsPagerAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//don't show the keybord when the app starts
		this.getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
		adapter=new TabsPagerAdapter(getSupportFragmentManager(),
				MainActivity.this);
		viewPager.setAdapter(adapter);

		SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);

		slidingTabLayout.setViewPager(viewPager);

		FillDB fill = new FillDB(getBaseContext());

		// fill the database is the application is started for the first time
		final String PREFS_NAME = "MyPrefsFile";

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

		if (settings.getBoolean("my_first_time", true)) {
			fill.fill();
			settings.edit().putBoolean("my_first_time", false).commit();

		}

		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		adapter.notifyDataSetChanged();
	}

}