package com.example.nitish.whattodo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nitish on 31/10/16.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "todoManager";

    // Todo table name
    private static final String TABLE_TODO = "todo";

    // Todo Table Columns names
    private static final String KEY_TITLE = "title";
    private static final String KEY_DETAILS = "details";
    private static final String KEY_IMP = "importance";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TODO_TABLE = "CREATE TABLE " + TABLE_TODO + "("
                + KEY_TITLE + " TEXT PRIMARY KEY," + KEY_DETAILS + " TEXT, "+ KEY_IMP + " INTEGER)";
        db.execSQL(CREATE_TODO_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);

        // Create tables again
        onCreate(db);
    }

    // resetting database
    public void onReset(SQLiteDatabase db) {
        // Drop older table if existed
        db.execSQL("DELETE FROM " + TABLE_TODO);

        // Create tables again
        //onCreate(db);
    }

    // Adding new todo
    public void addToDo(ToDo todo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        System.out.println("Todo inside database :"+todo.getTitle());
        values.put(KEY_TITLE, todo.getTitle()); // Todo text
        values.put(KEY_DETAILS, todo.getDetails()); // Todo text
        values.put(KEY_IMP, todo.getImportance()); // Todo text
        // Inserting Row
        db.insert(TABLE_TODO, null, values);
        db.close(); // Closing database connection

    }

    public ToDo getToDo(String title) {
        SQLiteDatabase db = this.getReadableDatabase();

//        Cursor cursor = db.query(TABLE_QUOTES, new String[] { KEY_ID,
//                        KEY_ID, KEY_TEXT }, KEY_ID + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
        String getquotequery = "SELECT * FROM " + TABLE_TODO + " WHERE "+KEY_TITLE+" = "+title;
        Cursor cursor = db.rawQuery(getquotequery,null);

        if (cursor != null)
            cursor.moveToFirst();

        ToDo todo = new ToDo(cursor.getString(0),cursor.getString(1),Integer.parseInt(cursor.getString(2)));
        // return todo
        return todo;
    }

    public int deleteToDo(String title) {
        SQLiteDatabase db = this.getWritableDatabase();

//        Cursor cursor = db.query(TABLE_QUOTES, new String[] { KEY_ID,
//                        KEY_ID, KEY_TEXT }, KEY_ID + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
        String deletetodoquery = "DELETE FROM " + TABLE_TODO + " WHERE "+KEY_TITLE+" = '"+title+"'";
        try {
            db.execSQL(deletetodoquery);
           // return db.delete(TABLE_TODO, KEY_TITLE + "=" + title, null) ;
            return 1;
        }catch (Exception e)
        {
            return -1;
        }

    }

    // Getting All Todos
    public List<ToDo> getAllToDos() {
        List<ToDo> todos = new ArrayList<ToDo>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TODO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ToDo todo = new ToDo();
                todo.setTitle(cursor.getString(0));
                todo.setDetails(cursor.getString(1));
                todo.setImportance(Integer.parseInt(cursor.getString(2)));
                // Adding todo to list
                todos.add(todo);
            } while (cursor.moveToNext());
        }

        // return todos list
        return todos;
    }

}

