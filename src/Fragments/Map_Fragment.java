package Fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DataBase.Object;
import DataBase.ObjectDAO;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.touristbg.Places;
import com.example.touristbg.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map_Fragment extends Fragment implements OnMapReadyCallback {

	List<DataBase.Object> list = new ArrayList<>();
	DataBase.ObjectDAO obj;
	HashMap<Marker, Integer> hashmap;
	static View view;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		
		obj = new ObjectDAO(getActivity());
		list = obj.getAllObjects();
	
		if (view != null) {
			ViewGroup parent = (ViewGroup) view.getParent();
			if (parent != null)
				parent.removeView(view);
		}
		try {
			view = inflater.inflate(R.layout.fragment_map, container, false);
			SupportMapFragment mapfragment = (SupportMapFragment) getChildFragmentManager()
					.findFragmentById(R.id.map);
			mapfragment.getMapAsync(this);
		} catch (InflateException e) {
			
		}
		return view;

	}

	// When the map is ready ,i put markers for all of the objects in the list
	// and save their id
	// in hashmap to use it for Click Listener
	@Override
	public void onMapReady(GoogleMap map) {
		// TODO Auto-generated method stub
		hashmap = new HashMap<Marker, Integer>();
		double latitude, longitude;
		map.setMyLocationEnabled(true);
		LatLng myCoordinates = new LatLng(42.733883, 25.48583);
		CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
				myCoordinates, 6);
		map.animateCamera(location);
		for (int i = 0; i < list.size(); i++) {
			latitude = Double.parseDouble(list.get(i).getmLatitude());
			longitude = Double.parseDouble(list.get(i).getmLongitude());
			Marker marker = map.addMarker(new MarkerOptions().title(
					list.get(i).getmName()).position(
					new LatLng(latitude, longitude)));
			hashmap.put(marker, list.get(i).getmId());
		}

		// When the user click on marker information will be open new activity
		map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			@Override
			public void onInfoWindowClick(Marker marker) {
				// TODO Auto-generated method stub
				int id = hashmap.get(marker)-1;
				Bundle bundle = new Bundle();
				DataBase.Object object = new Object();
				object = list.get(id);

				bundle.putSerializable("ob", object);

				Intent intent = new Intent(getActivity(), Places.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});

	}

}
