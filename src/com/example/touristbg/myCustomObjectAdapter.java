package com.example.touristbg;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class myCustomObjectAdapter extends BaseAdapter {
	private Context context;
	private List<DataBase.Object> objects;

	public myCustomObjectAdapter(Context context,List<DataBase.Object> obj) {
		super();
		this.context=context;
		objects=obj;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View v = convertView;
		  if (v == null) {

		        LayoutInflater vi;
		        vi = LayoutInflater.from(context);
		        v = vi.inflate(R.layout.lv_item, null);

		    }
	
		
		DataBase.Object obj = objects.get(position);
		
		if (obj != null) {

			TextView txtNumber=(TextView) v.findViewById(R.id.txtNumber);
			TextView txtName=(TextView) v.findViewById(R.id.txtName);
			RatingBar rb = (RatingBar) v.findViewById(R.id.rbItem);
	        if (txtNumber != null) {
	        
	            txtNumber.setText(String.valueOf(obj.getmId()));
	        }
	        if (txtName != null) {

	            txtName.setText(obj.getmName());
	        }
	        if (rb != null) {
             
	           rb.setRating(obj.getmRayting());
	        }
	    }

		return v;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return objects.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return objects.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

}
