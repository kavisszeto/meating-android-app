package com.example.meating;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MeatingOrders.db";
    private static final int DATABASE_VERSION = 2;

    // 表名和列名
    public static final String TABLE_ORDERS = "orders";
    public static final String TABLE_USERS = "users"; // 新增的用戶表
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TOTAL = "total";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_USER_ID = "user_id"; // 新增的列

    // 創建表的SQL語句
    private static final String TABLE_CREATE_ORDERS =
            "CREATE TABLE " + TABLE_ORDERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TOTAL + " REAL, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_PHONE + " TEXT, " +
                    COLUMN_ADDRESS + " TEXT, " +
                    COLUMN_USER_ID + " INTEGER);"; // 新增的列

    private static final String TABLE_CREATE_USERS =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "username TEXT UNIQUE NOT NULL, " +
                    "password TEXT NOT NULL);"; // 新增的用戶表

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_USERS); // 先創建用戶表
        db.execSQL(TABLE_CREATE_ORDERS); // 再創建訂單表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // 再次創建新的用戶表和訂單表
        onCreate(db);
    }
}