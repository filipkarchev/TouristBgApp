package Fragments;

import java.util.ArrayList;
import java.util.List;

import DataBase.Object;
import DataBase.ObjectDAO;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.touristbg.Places;
import com.example.touristbg.R;
import com.example.touristbg.myCustomObjectAdapter;

public class Profile_Fragment extends Fragment {
	 private static int RESULT_LOAD_IMAGE = 1;
	ListView lvVisitedPlaces;
	EditText etxtUsername;
	ImageView image;
	Button btnSave;
	List<DataBase.Object> list = new ArrayList<>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_profile, container,
				false);
		
		lvVisitedPlaces = (ListView) view.findViewById(R.id.lv_visited_places);
		etxtUsername = (EditText) view.findViewById(R.id.ed_profile_name);
		image=(ImageView) view.findViewById(R.id.imgProfile);
		LoadUserNameAndImage();
		DataBase.ObjectDAO obj = new ObjectDAO(getActivity());
		list = obj.getAllVisitedObjects();

		myCustomObjectAdapter adapter = new myCustomObjectAdapter(
				getActivity(), list);

		lvVisitedPlaces.setAdapter(adapter);
		lvVisitedPlaces.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Bundle bundle = new Bundle();
				DataBase.Object object = new Object();
				object = list.get(position);

				bundle.putSerializable("ob", object);

				Intent intent = new Intent(getActivity(), Places.class);
				intent.putExtras(bundle);
		//		getActivity().finish();
				startActivity(intent);

			}
		});

		// взема се текста от edit text и се запомня.
		btnSave = (Button) view.findViewById(R.id.btn_save_username);
		btnSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String name = etxtUsername.getText().toString();
				SharedPreferences sp = PreferenceManager
						.getDefaultSharedPreferences(getActivity());
				Editor edit = sp.edit();

				edit.putString("user_name", name).commit();
				Toast.makeText(getActivity(), "Името е запаметено",
						Toast.LENGTH_LONG).show();
			}
		});
		
		//запреди картинка от галерия,като профилна снимка
		
		image.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				 Intent i = new Intent(
	                        Intent.ACTION_PICK,
	                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	                 
	                startActivityForResult(i, RESULT_LOAD_IMAGE);
				
				
				return false;
			}
		});
		
		return view;
	}

	// Зарежда потребителско име ,което е запомнено да този момент
	private void LoadUserNameAndImage() {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());

		String name = sp.getString("user_name", "Анонимен потребител");
		etxtUsername.setText(name);
		String picturePath=sp.getString("picture_path", null);
		if(picturePath==null) image.setImageResource(R.drawable.profile);
		else image.setImageBitmap(BitmapFactory.decodeFile(picturePath));
	}
	
	 @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	         
	        getActivity();
			if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK && null != data) {
	            Uri selectedImage = data.getData();
	            String[] filePathColumn = { MediaStore.Images.Media.DATA };
	 
	            Cursor cursor = getActivity().getContentResolver().query(selectedImage,
	                    filePathColumn, null, null, null);
	            cursor.moveToFirst();
	 
	            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	            String picturePath = cursor.getString(columnIndex);
	            
	            cursor.close();
	             
	            SharedPreferences sp = PreferenceManager
						.getDefaultSharedPreferences(getActivity());
				Editor edit = sp.edit();

				edit.putString("picture_path", picturePath).commit();
	            image.setImageBitmap(BitmapFactory.decodeFile(picturePath));
	         
	        }
}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		
		super.onResume();
	}


}