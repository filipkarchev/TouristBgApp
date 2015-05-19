package DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class DBTools extends SQLiteOpenHelper {

	
	private static final String DATABASE_NAME = "tourist.db";
	private static final int DATABASE_VERSION = 1;

	// Costants for Object table
	public static final String TABLE_OBJECT = "object";
	public static final String COLUMN_OBJECT_ID = "_id";
	public static final String COLUMN_OBJECT_NAME = "name";
	public static final String COLUMN_OBJECT_DESCRIPTION = "description";
	public static final String COLUMN_OBJECT_PICTURE = "picture";
	public static final String COLUMN_OBJECT_WORKING_HOURS = "working_hours";
	public static final String COLUMN_OBJECT_TELEPHONE = "telephone";
	public static final String COLUMN_OBJECT_RAYTING = "rayting";
	public static final String COLUMN_OBJECT_LATITUDE = "latitude";
	public static final String COLUMN_OBJECT_LONGITUDE = "longitude";
	public static final String COLUMN_OBJECT_IsVisited = "isVisited";


	// SQL statement of the object table creation
	private static final String SQL_CREATE_TABLE_OBJECTS = "CREATE TABLE "
			+ TABLE_OBJECT + "(" + COLUMN_OBJECT_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_OBJECT_NAME
			+ " TEXT NOT NULL, " + COLUMN_OBJECT_DESCRIPTION
			+ " TEXT NOT NULL, " + COLUMN_OBJECT_PICTURE + " TEXT NOT NULL, "
			+ COLUMN_OBJECT_WORKING_HOURS + " TEXT NOT NULL, "
			+ COLUMN_OBJECT_TELEPHONE + " TEXT NOT NULL, "
			+ COLUMN_OBJECT_RAYTING + " REAL NOT NULL, " + COLUMN_OBJECT_LATITUDE
			+ " TEXT NOT NULL, " + COLUMN_OBJECT_LONGITUDE
			+ " TEXT NOT NULL, "+ COLUMN_OBJECT_IsVisited
			+ " TEXT NOT NULL " + ");";

	

	public DBTools(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	
	public DBTools(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_CREATE_TABLE_OBJECTS);
	

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	
		// clear all data
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_OBJECT);
	

		// recreate the tables
		onCreate(db);
	}

}
