package com.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.UserDictionary;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyHelper extends SQLiteOpenHelper {

    private static  final String databaseName="DictionaryDB";
    private static final int dbVersion=1;



    public MyHelper(Context context) {
        super(context, databaseName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     String query="CREATE TABLE WORDS"
        +"("+
             "WordID INTEGER PRIMARY KEY AUTOINCREMENT,"+
             "Word TEXT,"+
             "Meaning TEXT)";

     db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    public boolean InsertData(String word, String meaning, SQLiteDatabase db){
//        try {
//            String query="insert into Words(Word, Meaning) values('"+word+"','"+meaning+"')";
//            db.execSQL(query);
//            return true;
//
//        }catch (Exception e){
//            Log.d("Error: ",e.toString());
//            return false;
//        }
//    }


    public long InsertData(String word,String meaning, SQLiteDatabase db){
        long id;
        ContentValues contentValues=new ContentValues();
        contentValues.put("Word" ,word);
        contentValues.put("Meaning", meaning);
        id=db.insert("WORDS",null,contentValues);
        return id;
    }

    public List<Word> GetAllWords(SQLiteDatabase db){
        List<Word> dictionaryList=new ArrayList<>();
        Cursor cursor=db.rawQuery("Select * from Words",null);
        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                dictionaryList.add(new Word(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }
        }
        return dictionaryList;


    }

    public List<Word> GetWordByName(String word, SQLiteDatabase db) {
        List<Word> dictionaryList = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from Words where Word='" + word + "'", null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                dictionaryList.add(new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));

            }
        }
        return dictionaryList;

    }



}
