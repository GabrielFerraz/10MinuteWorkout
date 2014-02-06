package com.example.utils;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{
 
  private String[] sqlCreate;
 
  SQLiteHelper(Context c,String dataBaseName,int version,String[]createSQL){
 
    super(c,dataBaseName,null,version);
 
    this.sqlCreate=createSQL;
 
  }
 
  @Override
 
  public void onCreate (SQLiteDatabase db) {
 
    for(int i=0;i<this.sqlCreate.length;i++){
 
      String sql=sqlCreate[i];
 
      try{
 
        db.execSQL(sql);
 
      }catch(SQLException e){
 
        e.printStackTrace();
 
      }
 
    }
 
  } 


@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	onCreate(db);
	
}}