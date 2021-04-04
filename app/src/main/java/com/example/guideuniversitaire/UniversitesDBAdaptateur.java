package com.example.guideuniversitaire;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

class UniversitesDBAdaptateur extends SQLiteOpenHelper {
    private static final String BASE_NOM = " universites.db";
    private static final String TABLE_UNIVERSITES = "table_universites";

    private static final String COLONNE_ID = "id";
    private static final String COLONNE_NOM = "nom";
    private static final String COLONNE_VILLE = "ville";

    private static final String REQUETE_CREATION_BD = "create table "
            + TABLE_UNIVERSITES + " (" + COLONNE_ID
            + " integer primary key autoincrement, " + COLONNE_NOM
            + " text not null, " + COLONNE_VILLE + " text not null);";

    public UniversitesDBAdaptateur(Context context) {
        super(context, BASE_NOM, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(REQUETE_CREATION_BD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_UNIVERSITES);
        onCreate(db);
    }

    public boolean insertData(String universite, String ville) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLONNE_NOM, universite);
        contentValues.put(COLONNE_VILLE, ville);

        long result = db.insert(TABLE_UNIVERSITES, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public ArrayList<HashMap<String, String>> getUniversities() {
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<HashMap<String, String>> universities = new ArrayList<>();

        String query = "SELECT * FROM "+TABLE_UNIVERSITES;

        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> universite = new HashMap<>();
            universite.put("id",cursor.getString(cursor.getColumnIndex(COLONNE_ID)));
            universite.put("université",cursor.getString(cursor.getColumnIndex(COLONNE_NOM)));
            universite.put("ville",cursor.getString(cursor.getColumnIndex(COLONNE_VILLE)));
            universities.add(universite);
        }

        return universities;
    }

    public HashMap<String, String> getUniversityById(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        HashMap<String,String> university = new HashMap<>();
        String query = "SELECT "+COLONNE_NOM+", "+COLONNE_VILLE+" FROM "+TABLE_UNIVERSITES+" WHERE "+COLONNE_ID +" = "+id;
//        Cursor cursor = db.rawQuery(query,null);
//        if (cursor.moveToNext()){
//            university.put("name",cursor.getString(cursor.getColumnIndex(COLONNE_ID)));
//            university.put("designation",cursor.getString(cursor.getColumnIndex(COLONNE_NOM)));
//            university.put("location",cursor.getString(cursor.getColumnIndex(COLONNE_VILLE)));
//        }
        return  university;
    }

    public Integer deleteUniversity(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_UNIVERSITES, COLONNE_ID+" = ?",new String[]{String.valueOf(id)});
    }
}
