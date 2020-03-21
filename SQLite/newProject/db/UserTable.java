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

import br.com.envolvedesenvolve.alcoolaqui.model.User;

/**
 * Created by Cristiano M. on 20/03/2020
 */
public class UserTable extends HelperDB{
    private static final String TAG = "UserTable";

    private static final String TABLE_USER = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_SENHA = "senha";
    private static final String COLUMN_IMEI = "imei";
    private static final String COLUMN_DT_INC = "dt_inc";
    private static final String COLUMN_DT_UPD = "dt_upd";

//    private SQLiteOpenHelper dbHelper;

    public UserTable(Context context) {
        super(context);
    }

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
            + COLUMN_DT_UPD + " text"
            + ");";

    private final List<String> tableColumns = Arrays.asList(COLUMN_ID);

    public List<String> getColumns() {
        return tableColumns;
    }

    public static String getName() {
        return TABLE_USER;
    }

    public List<String> getAllNotes() {
        List<String> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
//                Note note = new Note();
//                notes.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_ID)));
                notes.add(cursor.getString(0));
                notes.add(cursor.getString(1));
                notes.add(cursor.getString(2));
                notes.add(cursor.getString(3));

            } while (cursor.moveToNext());
        }

        db.close(); // close db connection
        return notes;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_ID)));
                user.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_NOME)));
                user.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_EMAIL)));
                user.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_SENHA)));
                user.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_IMEI)));
                user.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_DT_INC)));
                user.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_DT_UPD)));

                notes.add(user);

            } while (cursor.moveToNext());
        }

        db.close(); // close db connection
        return notes;
    }
}