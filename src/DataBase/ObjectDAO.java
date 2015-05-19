package DataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ObjectDAO implements Serializable {

	public static final String TAG = "ObjectDAO";

	// Database fields
	private DBTools mDbHelper=null;
	private static SQLiteDatabase mDatabase=null;
	
	private  Context mContext;
	private String[] mAllColumns = { DBTools.COLUMN_OBJECT_ID,
			DBTools.COLUMN_OBJECT_NAME, DBTools.COLUMN_OBJECT_DESCRIPTION,
			DBTools.COLUMN_OBJECT_PICTURE, DBTools.COLUMN_OBJECT_WORKING_HOURS,
			DBTools.COLUMN_OBJECT_TELEPHONE, DBTools.COLUMN_OBJECT_RAYTING,
			DBTools.COLUMN_OBJECT_LATITUDE,DBTools.COLUMN_OBJECT_LONGITUDE, DBTools.COLUMN_OBJECT_IsVisited };

	public ObjectDAO(Context context) {
		this.mContext = context;
		mDbHelper = new DBTools(context);
		// open the database
		try {
			open();
		} catch (SQLException e) {
			Log.e(TAG, "SQLException on openning database " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void open() throws SQLException {
		mDatabase = mDbHelper.getWritableDatabase();
	}

	public void close() {
		mDbHelper.close();
	}

	public Object createObject(String name, String description, String picture,
			String hours, String telephone, Float rayting, String latitude,String longitude,
			String isVisited) {
		ContentValues values = new ContentValues();

		values.put(DBTools.COLUMN_OBJECT_NAME, name);
		values.put(DBTools.COLUMN_OBJECT_DESCRIPTION, description);
		values.put(DBTools.COLUMN_OBJECT_PICTURE, picture);
		values.put(DBTools.COLUMN_OBJECT_WORKING_HOURS, hours);
		values.put(DBTools.COLUMN_OBJECT_TELEPHONE, telephone);
		values.put(DBTools.COLUMN_OBJECT_RAYTING, rayting);
		values.put(DBTools.COLUMN_OBJECT_LATITUDE, latitude);
		values.put(DBTools.COLUMN_OBJECT_LONGITUDE, longitude);
		values.put(DBTools.COLUMN_OBJECT_IsVisited, isVisited);
		long insertId = mDatabase.insert(DBTools.TABLE_OBJECT, null, values);
		Cursor cursor = mDatabase.query(DBTools.TABLE_OBJECT, mAllColumns,
				DBTools.COLUMN_OBJECT_ID + " = " + insertId, null, null,
				null, null);
		cursor.moveToFirst();
		Object newObject = cursorToObject(cursor);
		cursor.close();
		return newObject;
	}

	/*
	 * public void deleteComment(Comment comment) { int id = comment.getmId();
	 * // delete all employees of this company ObjectDAO employeeDao = new
	 * ObjectDAO(mContext); List<Object> listEmployees =
	 * employeeDao.getEmployeesOfCompany(id); if (listEmployees != null &&
	 * !listEmployees.isEmpty()) { for (Object o : listObjects) {
	 * employeeDao.deleteEmployee(o); } }
	 * 
	 * System.out.println("the deleted company has the id: " + id);
	 * mDatabase.delete(DBTools.TABLE_COMPANIES, DBTools.COLUMN_COMPANY_ID +
	 * " = " + id, null); }
	 */
	public static  void changeIsVisited(int objID,boolean visited) {
		String strSQL = "UPDATE "+DBTools.TABLE_OBJECT+" SET "+DBTools.COLUMN_OBJECT_IsVisited+" = '"+ String.valueOf(visited)+"' WHERE "+DBTools.COLUMN_OBJECT_ID+"= "+ objID;
		mDatabase.execSQL(strSQL);
	}
	
		public List<Object> getAllVisitedObjects() {
			List<Object> listObjects = new ArrayList<Object>();

			Cursor cursor = mDatabase.query(DBTools.TABLE_OBJECT, mAllColumns,
					DBTools.COLUMN_OBJECT_IsVisited + "= 'true'", null, null, null, null);
			if (cursor != null) {
				cursor.moveToFirst();
				while (!cursor.isAfterLast()) {
					Object object = cursorToObject(cursor);
					listObjects.add(object);
					cursor.moveToNext();
				}

				// make sure to close the cursor
				cursor.close();
			}
			return listObjects;
		}
	public Object getObjectById(int objID) {
		Object object = null;

		Cursor cursor = mDatabase.query(DBTools.TABLE_OBJECT, mAllColumns,
				DBTools.COLUMN_OBJECT_ID + "= ?",
				new String[] { String.valueOf(objID) }, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
			object = cursorToObject(cursor);
			cursor.close();
		}
		return object;
	}

	public List<Object> getAllObjects() {
		List<Object> listObjects = new ArrayList<Object>();

		Cursor cursor = mDatabase.query(DBTools.TABLE_OBJECT, mAllColumns,
				null, null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				Object object = cursorToObject(cursor);
				listObjects.add(object);
				cursor.moveToNext();
			}

			// make sure to close the cursor
			cursor.close();
		}
		return listObjects;
	}

	protected Object cursorToObject(Cursor cursor) {
		Object object = new Object();
		object.setmId(cursor.getInt(0));
		object.setmName(cursor.getString(1));
		object.setmDescription(cursor.getString(2));
		object.setmPicture(cursor.getString(3));
		object.setmHours(cursor.getString(4));
		object.setmTelephone(cursor.getString(5));
		object.setmRayting(cursor.getFloat(6));
		object.setmLatitude(cursor.getString(7));
		object.setmLongitude(cursor.getString(8));
		object.setIsVisited(Boolean.parseBoolean(cursor.getString(9)));

		return object;
	}

}
