package br.com.envolvedesenvolve.alcoolaqui.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.envolvedesenvolve.alcoolaqui.model.Marks;
import br.com.envolvedesenvolve.alcoolaqui.model.User;

/**
 * Created by Cristiano M. on 21/03/2020
 */
public class MarksTable extends HelperDB{
    private static final String TAG = "MarksTable";

    public static final String TABLE_NAME = "geography_marks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FK_PRODUCT = "fk_product";
    public static final String COLUMN_LAT = "lat";
    public static final String COLUMN_LON = "lon";

    public MarksTable(Context context) {
        super(context);
    }

    // Database creation SQL statement
    public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME
            + "("
            + COLUMN_ID + " integer PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FK_PRODUCT + " integer, " // todo not null
            + COLUMN_LAT + " real NOT NULL, "
            + COLUMN_LON + " real NOT NULL "
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
//                notes.setId(cursor.getInt(cursor.getColumnIndex(MarksTable.COLUMN_ID)));
                notes.add(cursor.getString(0));
                notes.add(cursor.getString(1));
                notes.add(cursor.getString(2));
                notes.add(cursor.getString(3));

            } while (cursor.moveToNext());
        }

        db.close(); // close db connection
        return notes;
    }

    public ArrayList<Marks> getAllUsers() {
        ArrayList<Marks> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Marks mark = new Marks();
                mark.setId(cursor.getInt(cursor.getColumnIndex(MarksTable.COLUMN_ID)));
                mark.setFk_product(cursor.getInt(cursor.getColumnIndex(MarksTable.COLUMN_FK_PRODUCT)));
                mark.setLat(cursor.getDouble(cursor.getColumnIndex(MarksTable.COLUMN_LAT)));
                mark.setLon(cursor.getDouble(cursor.getColumnIndex(MarksTable.COLUMN_LON)));

                notes.add(mark);

            } while (cursor.moveToNext());
        }

        db.close(); // close db connection
        return notes;
    }

    public void setValuesDatabase(ContentValues cv) {
        insertValueOnTable(TABLE_NAME, cv);
    }
}