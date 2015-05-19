package com.example.touristbg;


import DataBase.Object;
import DataBase.ObjectDAO;

import Internet.DownloadImageTask;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class Places extends Activity {
	TextView name, hours, description, number;
	ImageView img;
	RatingBar rating;
	DataBase.Object object;

	Button btnVisitedPlaces;

	boolean find;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_places);
		btnVisitedPlaces = (Button) findViewById(R.id.btn_visit_place);

		Bundle bundle = getIntent().getExtras();

		object = (Object) bundle.getSerializable("ob");
		find = object.getIsVisited();
		setButtonText();
	//	objDao = (ObjectDAO) bundle.getSerializable("obDAO");

		name = (TextView) findViewById(R.id.txtObjectName);
		hours = (TextView) findViewById(R.id.tv_working_time);
		description = (TextView) findViewById(R.id.tv_information);
		number = (TextView) findViewById(R.id.tv_telephone_number);
		rating = (RatingBar) findViewById(R.id.rating);
		img = (ImageView) findViewById(R.id.imgObject);

		new DownloadImageTask(img).execute(object.getmPicture());
		name.setText(object.getmName());
		hours.setText(object.getmHours());
		description.setText(object.getmDescription());
		number.setText(object.getmTelephone());
		rating.setRating(object.getmRayting());
		number.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts(
						"tel", object.getmTelephone(), null));
	
				startActivity(intent);

			}
		});

		btnVisitedPlaces.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(find==false){
				ObjectDAO.changeIsVisited(object.getmId(), true);
			find=true;
				btnVisitedPlaces.setText("Отмени");
				} else if(find==true){
					find=false;
					ObjectDAO.changeIsVisited(object.getmId(), false);
					btnVisitedPlaces.setText("Посети");
					}
			}
		});
              
	}

	
	public void setButtonText() {
		if (find == false) {
			btnVisitedPlaces.setText("Посети");
		} else if (find == true)
			btnVisitedPlaces.setText("Отмени");
	}
}
