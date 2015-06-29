package com.basis.rakib.icare_hospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
/**
 * Created by Mobile App Develop on 27-6-15.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "iCare";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = null;
    public ArrayList<String>showHospital;



        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE hospital_info(id integer primary key autoincrement,Name TEXT, Address TEXT, Number TEXT )");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public DBHelper(Context context) {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

    public boolean insertAddHospital(Hospital hospital) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("Name", hospital.getName());
            values.put("Address", hospital.getAddress());
            values.put("Number", hospital.getNumber());

            try {
                sqLiteDatabase.insert("hospital", null, values);
                Log.i(TAG, "Success");
                return true;
            } catch (SQLException e) {
                Log.i(TAG, "Error");
                return false;
            }



        }



    public int DeleteAddHospital(int id) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int deleted = sqLiteDatabase.delete(TABLE_NAME, ID_FIELD+ "=?", new String[]{""+id});




        sqLiteDatabase.close();
        return deleted;

    }


    //ArratList..............................................

    public ArrayList<Hospital> showHospital(String category) {
        ArrayList<Hospital> hospitalData = new ArrayList<>();
        Hospital hospital = new Hospital();

        String query = "SELECT * FROM hospital WHERE category ='" + category + "'";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    hospital.setId(cursor.getInt(cursor.getColumnIndex("Id")));
                    hospital.setName(cursor.getString(cursor.getColumnIndex("Name")));
                    hospital.setAddress(cursor.getString(cursor.getColumnIndex("Address")));
                    hospital.setNumber(cursor.getString(cursor.getColumnIndex("Number")));

                    hospitalData.add(hospital);

                    // profileData.add(new Profile(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("age")), cursor.getString(cursor.getColumnIndex("gender")), cursor.getString(cursor.getColumnIndex("bloodGroup")), cursor.getString(cursor.getColumnIndex("height")), cursor.getString(cursor.getColumnIndex("weight")), cursor.getString(cursor.getColumnIndex("phoneNo")), cursor.getString(cursor.getColumnIndex("category"))));
                } while (cursor.moveToNext());
            }


        } else {
            hospitalData.add(new Hospital("NO"));
        }
        sqLiteDatabase.close();
        return hospitalData;
    }

    public int checkId(){
        String query = "SELECT * FROM hospital_info";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String count = "SELECT count(*) FROM table";
        Cursor mcursor = sqLiteDatabase.rawQuery(count, null);
        mcursor.moveToFirst();
        int iCount = mcursor.getInt(0);
        if(iCount>0)
            return 1;
        else
            return 0;

    }


    }
