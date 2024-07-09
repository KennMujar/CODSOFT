package com.example.todolistapp.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NAME = "toDoListDatabase";
    private static final String TODO_TABLE = "todo";
    private static final String ID = "id";
    private static final String TASK = "task";
    private static final String STATUS = "status";
    private static final String CREATE_TO_DO_TABLE = "CREATE TABLE " + TODO_TABLE + "(" + ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                    + TASK + "TEXT, " + STATUS + " INTEGER)";
    private SQLiteDatabase db;
    private DatabaseHandler(Context context) {
        super(context, NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
            db.execSQL(CREATE_TO_DO_TABLE);

        }
        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //Drop the older tables
            db.execSQL("DROP TABLE IF EXISTS" + TODO_TABLE);
            //Create tables again
            onCreate(db);


    }

}
