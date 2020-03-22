package br.com.envolvedesenvolve.alcoolaqui.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.envolvedesenvolve.alcoolaqui.model.User;

/**
 * Created by Cristiano M. on 20/03/2020
 */
public class UserTable extends HelperDB{
    private static final String TAG = "UserTable";

    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_SENHA = "senha";
    public static final String COLUMN_IMEI = "imei";
    public static final String COLUMN_DT_INC = "dt_inc";
    public static final String COLUMN_DT_UPD = "dt_upd";

    public UserTable(Context context) {
        super(context);
    }

    // Database creation SQL statement
    public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME
            + "("
            + COLUMN_ID + " integer PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOME + " text, "
            + COLUMN_EMAIL + " text NOT NULL, "
            + COLUMN_SENHA + " text NOT NULL, "
            + COLUMN_IMEI + " integer, "
            + COLUMN_DT_INC + " text , " // todo NOT NULL
            + COLUMN_DT_UPD + " text "
            + ");";

    private final List<String> tableColumns = Arrays.asList(COLUMN_ID);

    public List<String> getColumns() {
        return tableColumns;
    }

    public static String getName() {
        return TABLE_NAME;
    }

    public List<String> getAllNotes() {
        List<String> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

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
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_ID)));
                user.setNome(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NOME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_EMAIL)));
                user.setSenha(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_SENHA)));
                user.setImei(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_IMEI)));
                user.setDt_inc(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_DT_INC)));
                user.setDt_upd(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_DT_UPD)));

                notes.add(user);

            } while (cursor.moveToNext());
        }

        db.close(); // close db connection
        return notes;
    }

    public void setValuesDatabase(Context context, ContentValues cv) {

        boolean resp = insertValueOnTable(TABLE_NAME, cv);
        if(resp){
            Toast.makeText(context, "Usuário cadastrado!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "ERRO usuário não cadastrado", Toast.LENGTH_LONG).show();
        }
    }
}