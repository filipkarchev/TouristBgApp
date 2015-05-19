package Fragments;


import java.util.ArrayList;
import java.util.List;

import DataBase.Object;
import DataBase.ObjectDAO;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


import com.example.touristbg.Places;
import com.example.touristbg.R;
import com.example.touristbg.myCustomObjectAdapter;

public class Regions_Fragment extends Fragment {
	ListView lv;
	List<DataBase.Object> list = new ArrayList<>();
	DataBase.ObjectDAO obj;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_regions, container,
				false);
		lv = (ListView) view.findViewById(R.id.lvObjects);

		obj = new ObjectDAO(getActivity());

		list = obj.getAllObjects();
		myCustomObjectAdapter adapter = new myCustomObjectAdapter(
				getActivity(), list);

		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Bundle bundle = new Bundle();
				DataBase.Object object = new Object();
				object = list.get(position);
				bundle.putSerializable("ob", object);
				Intent intent = new Intent(getActivity(), Places.class);
				intent.putExtras(bundle);
				startActivity(intent);

			}
		});
		return view;
	}

}
