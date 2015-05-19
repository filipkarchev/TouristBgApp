package tabs;

import Fragments.Map_Fragment;

import Fragments.Profile_Fragment;
import Fragments.Regions_Fragment;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	private String tabs[] = { "Профил", "Търсене по Области", "Търсене по Карта"};
	private Context context;

	public TabsPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		this.context = context;
	}

	 @Override
	public int getItemPosition(Object object) {
		 return POSITION_NONE;
	}

	@Override
	    public Fragment getItem(int position) {
	        if(position == 0){
	            return new Profile_Fragment();
	        } else if(position == 1) {
	            return new Regions_Fragment();
	        } else if(position == 2) {
	            return new Map_Fragment();
	        }
	       
	 
	        return null;
	    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return tabs[position];
	}
}