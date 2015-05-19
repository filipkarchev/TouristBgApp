package DataBase;

import java.io.Serializable;

public class Object implements Serializable {

	public static final String TAG = "Object";

	private int mId;
	private String mName;
	private String mDescription;
	private String mPicture;
	private String mHours;
	private String mTelephone;
	private Float mRayting;
	private String mLatitude;
	private String mLongitude;
	private boolean mIsVisited;

	public Object(int id, String name, String description, String picture,
			String hours, String telephone, Float rayting, String Latitude,String Longitude,
			boolean isVisited) {
		// super();
		this.mId = id;
		this.mName = name;
		this.mDescription = description;
		this.mPicture = picture;
		this.mHours = hours;
		this.mTelephone = telephone;
		this.mRayting = rayting;
		this.mLatitude=Latitude;
		this.mLongitude=Longitude;
		this.mIsVisited = isVisited;
	}

	public Object() {
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmDescription() {
		return mDescription;
	}

	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	public String getmPicture() {
		return mPicture;
	}

	public void setmPicture(String mPicture) {
		this.mPicture = mPicture;
	}

	public String getmHours() {
		return mHours;
	}

	public void setmHours(String mHours) {
		this.mHours = mHours;
	}

	public String getmTelephone() {
		return mTelephone;
	}

	public void setmTelephone(String mTelephone) {
		this.mTelephone = mTelephone;
	}

	public Float getmRayting() {
		return mRayting;
	}

	public void setmRayting(Float mRayting) {
		this.mRayting = mRayting;
	}

	

	public String getmLatitude() {
		return mLatitude;
	}

	public void setmLatitude(String mLatitude) {
		this.mLatitude = mLatitude;
	}

	public String getmLongitude() {
		return mLongitude;
	}

	public void setmLongitude(String mLongitude) {
		this.mLongitude = mLongitude;
	}

	public boolean getIsVisited() {
		return mIsVisited;
	}
	public void setIsVisited(boolean isVisted)
	{
		this.mIsVisited=isVisted;
	}

}
