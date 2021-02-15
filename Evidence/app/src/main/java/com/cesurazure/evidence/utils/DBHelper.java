package com.cesurazure.evidence.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import com.cesurazure.evidence.model.User;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "userDB";
    private static final int VERSION = 1;


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
        Log.v("dbhelper", "DB Called");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "Create table users(id INTEGER PRIMARY KEY, username TEXT, password TEXT)";
        sqLiteDatabase.execSQL(sql);
        Log.v("db oncreate", "Table created");
    }

    public void addUser(User u){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("username", u.getUsername());
        values.put("password", u.getPassword());
        db.insert("users", null, values);
        db.close();
        Log.v("done................ " , "Data Inserted");
    }

    public User getUser(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from users where username = '"+username+"'";
        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();
        if(c !=null){
            User u = new User();
            u.setUsername(c.getString(c.getColumnIndex("username")));
            u.setPassword(c.getString(c.getColumnIndex("password")));
            return u;
        }else{
            return null;
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<User> getUser(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<User> users = new ArrayList<User>();
        String sql = "select * from users";
        Cursor c = db.rawQuery(sql, null);
        if(c.moveToFirst()){
            do{
                User u = new User();
                u.setId(Integer.parseInt(c.getString(0)));
                u.setUsername(c.getString(1));
                u.setPassword(c.getString(2));
                users.add(u);
            }while(c.moveToNext());
        }

        return users;
    }
}

