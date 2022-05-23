package com.farazzz.visitease;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(Context context) {
        super(context, "Visitor", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String create = "CREATE TABLE " + Params.table_name + "("
//                + Params.name + " TEXT PRIMARY KEY, "+ Params.destination + " TEXT, "
//                + Params.comments + " TEXT)";
//        Log.d("dbFaraz","Query: "+create);
//        db.execSQL(create);
        db.execSQL("CREATE TABLE VisitorTable(name TEXT PRIMARY KEY, destination TEXT, comments TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        String drop = String.valueOf("DROP TABLE IF EXISTS");
//        db.execSQL(drop, new String[]{"visitor"});
//        onCreate(db);
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
        if(insert==-1) {
            return false;
        }
        else{
            return true;
        }
    }



    public boolean updateVisitor(String name,String destination, String comments) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("destination", destination);
        values.put("comments ", comments);

        Cursor cursor = db.rawQuery("SELECT * FROM VisitorTable WHERE NAME=?",new String[]{name});
        long insert = db.update("VisitorTable", values,"name=?",new String[]{name});
        if(cursor.getCount()>0) {


            db.close();
            if (insert == -1) {
                return false;
            } else {
                return true; 
            }
        }
        else{
            return false;
        }

    }



    public boolean deleteVisitor(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM VisitorTable WHERE NAME=?",new String[]{name});

        if(cursor.getCount()>0) {
            long insert = db.delete("VisitorTable","name=?",new String[]{name});
            if (insert == -1) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return false;
        }
    }

    public Cursor getVisitor() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM VisitorTable", null);
        return cursor;
    }






//
//    public void getVisitor(String name) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query("visitor", new String[]{"name", "destination", "comments"}, "name=?", new String[]{String.valueOf("name")}, null, null, null);
//
//        if (cursor != null && cursor.moveToFirst())
//        {
//            Log.d("mytag",cursor.getString(1));
//            //Log.d("mytag",cursor.getString(2));
//           //Log.d("mytag",cursor.getString(3));
//        }
//        else
//        {
//            Log.v("mytag","Error");
//        }
//
//
//    }

}
