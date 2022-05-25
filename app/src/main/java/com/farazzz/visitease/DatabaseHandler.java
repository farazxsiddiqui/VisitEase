package com.farazzz.visitease;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(Context context) {
        super(context, "Visitor", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE VisitorTable(name TEXT PRIMARY KEY, destination TEXT, comments TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS VisitorTable");
    }

    public boolean addVisitor(String name, String destination, String comments) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("destination", destination);
        values.put("comments ", comments);
        long insert = db.insert("VisitorTable", null, values);
        db.close();
        return insert != -1;
    }

    public boolean updateVisitor(String name, String destination, String comments) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("destination", destination);
        values.put("comments ", comments);

        Cursor cursor = db.rawQuery("SELECT * FROM VisitorTable WHERE NAME=?", new String[]{name});
        long insert = db.update("VisitorTable", values, "name=?", new String[]{name});
        if (cursor.getCount() > 0) {


            db.close();
            return insert != -1;
        } else {
            return false;
        }

    }

    public boolean deleteVisitor(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM VisitorTable WHERE NAME=?", new String[]{name});

        if (cursor.getCount() > 0) {
            long insert = db.delete("VisitorTable", "name=?", new String[]{name});
            return insert != -1;
        } else {
            return false;
        }
    }

    public Cursor getVisitor() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM VisitorTable", null);
        return cursor;
    }
    public Cursor getVisitor(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM VisitorTable WHERE NAME=?", new String[]{name});
        return cursor;
    }
    void clearTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM VisitorTable");

    }
}
