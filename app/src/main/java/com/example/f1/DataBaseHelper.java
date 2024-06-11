package com.example.f1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

   static SQLiteDatabase sqLiteDatabase;
    public DataBaseHelper(@Nullable Context context) {
        super(context,"Profile.db",null,1);
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table info(name text,email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean createUser(String name,String email){
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        SQLiteDatabase database = getWritableDatabase();
        long res = database.insert("info",null,cv);
        if(res==-1)
            return false;
        else
            return true;
    }
    public boolean updateUser(String email, String newName) {
        ContentValues cv = new ContentValues();
        cv.put("name", newName);

        SQLiteDatabase database = getWritableDatabase();
        int rowsAffected = database.update("info", cv, "email = ?", new String[]{email});

        return rowsAffected > 0;
    }

    public boolean deleteUser(String email) {
        SQLiteDatabase database = getWritableDatabase();
        int rowsAffected = database.delete("info", "email = ?", new String[]{email});
        return rowsAffected > 0;
    }

    public Cursor getUser() {
        SQLiteDatabase database = this.getReadableDatabase();
        return database.rawQuery("SELECT * FROM info LIMIT 1", null);
    }


}
