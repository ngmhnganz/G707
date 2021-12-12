package com.Nhom8.g702;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;


public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION =1;
    private static final String DB_NAME ="sach.sqlite";
    public static final String TBL_NAME = "SACH";

    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_NXS = "NSX";
    private static final String COL_TAIBAN = "TAIBAN";
    private static final String COL_PRICE = "GIA";
    private static final String COL_PHOTO = "PHOTO";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS "+TBL_NAME+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_NAME+ " VARCHAR(100), "+ COL_NXS+ " VARCHAR(200), "+COL_TAIBAN+ " LONG, "+COL_PRICE+" DOUBLE, "+COL_PHOTO+" BLOB)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TBL_NAME);
        onCreate(db);
    }

    public  void queryExcute(String sql){
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sql);
        } catch (Exception e){

        }
    }


    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return  db.rawQuery(sql, null);
    }

    public boolean insertData(String name, String nsx, long taiban, double gia, byte[] photo){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO "+TBL_NAME+" VALUES(null, ?, ?, ?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, name);
            statement.bindString(2, nsx);
            statement.bindLong(3, taiban);
            statement.bindDouble(4, gia);
            statement.bindBlob(5, photo);
            statement.executeInsert();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
