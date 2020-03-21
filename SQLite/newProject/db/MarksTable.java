package br.com.envolvedesenvolve.alcoolaqui.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cristiano M. on 21/03/2020
 */
public class MarksTable {
    private static final String TAG = "MarksTable";

    private static final String TABLE_USER = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_SENHA = "senha";
    private static final String COLUMN_IMEI = "imei";
    private static final String COLUMN_DT_INC = "dt_inc";
    private static final String COLUMN_DT_SYNC = "dt_upd";

    private SQLiteOpenHelper dbHelper = null;

    // Database creation SQL statement
    public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_USER
            + "("
            + COLUMN_ID + " integer PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOME + " text, "
            + COLUMN_EMAIL + " text NOT NULL, "
            + COLUMN_SENHA + " text NOT NULL, "
            + COLUMN_IMEI + " integer, "
            + COLUMN_DT_INC + " text , " // NOT NULL
            + COLUMN_DT_SYNC + " text"
            + ");";

    private final List<String> tableColumns = Arrays.asList(COLUMN_ID);

    public List<String> getColumns() {
        return tableColumns;
    }

    public static String getName() {
        return TABLE_USER;
    }

    public boolean insertData(String nome, String email, String senha) {
        Log.e(TAG, "Inserindo dados");

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", nome);
        cv.put("email", email);
        cv.put("senha", senha);

        long result = db.insert(TABLE_USER, null, cv);
        if (result == -1)
            return false;
        else
            return true;
    }

    public List<String> getAllNotes(Context context) {
        List<String> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM users";

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
//                Note note = new Note();
//                note.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_ID)));
                notes.add(cursor.getString(0));
                notes.add(cursor.getString(1));
                notes.add(cursor.getString(2));
                notes.add(cursor.getString(3));

            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

}