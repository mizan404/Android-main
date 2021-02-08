package com.mizanthecoder.projectfile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.mizanthecoder.projectfile.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USERNAME";
    public static final String COL_3 = "PASSWORD";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

        Log.v("dbhelper", "DB Called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)";
        db.execSQL(sql);
        Log.v("db oncreate", "Table created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
    }

    public void addUser(Student u) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("username", u.getUsername());
        values.put("password", u.getPassword());
        db.insert("student_table", null, values);
        db.close();
        Log.v("done................ ", "Data Inserted");
    }

//    public void updateUser(Student student) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("id", student.getId());
//        values.put("username", student.getUsername());
//        values.put("password", student.getPassword());
//
//        db.update(TABLE_NAME, values, "id = ?",new String[] { id });
//
//    }

    public Student getStudent(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from student_table where username = '" + username + "'";
        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();
        if (c != null) {
            Student u = new Student();
            u.setUsername(c.getString(c.getColumnIndex("username")));
            u.setPassword(c.getString(c.getColumnIndex("password")));
            return u;
        } else {
            return null;
        }
    }

    public List<Student> getStudent(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<Student> users = new ArrayList<Student>();
        String sql = "select * from student_table";
        Cursor c = db.rawQuery(sql, null);
        if(c.moveToFirst()){
            do{
                Student u = new Student();
                u.setId(Integer.parseInt(c.getString(0)));
                u.setUsername(c.getString(1));
                u.setPassword(c.getString(2));
                users.add(u);
            }while(c.moveToNext());
        }

        return users;
    }
}
