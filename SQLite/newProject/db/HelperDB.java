package br.com.envolvedesenvolve.alcoolaqui.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static br.com.envolvedesenvolve.alcoolaqui.db.UserTable.DATABASE_CREATE;

//public class HelperDB extends SQLiteOpenHelper {
//    private static final String TAG = "database";
//
//    private static final int DATABASE_VERSION = 1;
//    private static final String TABELA = "contatos";
//    private static final String DATABASE_NAME = "db_agenda.db";
//
//    private static final String TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + TABELA +
//            " (id Integer PRIMARY KEY AUTOINCREMENT, nome String , email String, celular String);";
//
//    public HelperDB(Context context) {
//
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        Log.e(TAG, "Criando tabelas");
//        db.execSQL(TABLE_CREATE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
////        Log.e(TAG, "Atualizando tabelas");
////        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
////        onCreate(db);
//    }
//
//    public boolean insertData(String nome, String email) {
//        Log.e(TAG, "Inserindo dados");
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("nome", nome);
//        cv.put("email", email);
//
//        long result = db.insert(TABELA, null, cv);
//        if (result == -1)
//            return false;
//        else
//            return true;
//    }
//
//    public List<String> getAllNotes() {
//        List<String> notes = new ArrayList<>();
//
//        // Select All Query
//        String selectQuery = "SELECT  * FROM contatos";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
////                Note note = new Note();
////                note.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_ID)));
//                notes.add(cursor.getString(0));
//                notes.add(cursor.getString(1));
//                notes.add(cursor.getString(2));
//
//            } while (cursor.moveToNext());
//        }
//
//        // close db connection
//        db.close();
//
//        // return notes list
//        return notes;
//    }
//}

public class HelperDB extends SQLiteOpenHelper {

    private static final String TAG = "database";

    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_database.db";
    private static final String TABLE_USER = UserTable.getName();
    private static final String TABLE_PRODUCT = ProductTable.getName();
    private static final String TABLE_MARKS = MarksTable.getName();

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserTable.DATABASE_CREATE);
//        db.execSQL(ProductTable.DATABASE_CREATE);
//        db.execSQL(MarksTable.DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "Atualizando tabelas");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARKS);
        onCreate(db);
    }

    public boolean insertValueOnTable(String table, ContentValues values) {
//        values.put("dt_inc", mFormat.format(new Date()));
        values.remove("id");
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(table, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }
}
