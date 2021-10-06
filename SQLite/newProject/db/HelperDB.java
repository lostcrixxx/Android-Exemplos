package br.com.envolvedesenvolve.alcoolaqui.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HelperDB extends SQLiteOpenHelper {

    private static final String TAG = "database";

    static HelperDB mDbHelper;

    public static synchronized HelperDB getInstance(Context context) {
        if (mDbHelper == null) {
            mDbHelper = new HelperDB(context);
        }
        return mDbHelper;
    }

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
        Log.e(TAG, "Criando as tabelas");
        db.execSQL(UserTable.DATABASE_CREATE);
        db.execSQL(ProductTable.DATABASE_CREATE);
        db.execSQL(MarksTable.DATABASE_CREATE);

//        db.execSQL("insert into users (nome,email,senha)"
//                + "values('Teste','teste@teste.com.br','123') ;");
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
        Log.e(TAG, "Inserindo nas tabelas");
//        values.put("dt_inc", mFormat.format(new Date()));
        values.remove("id");
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(table, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }
	
	public int updateValueOnTable(String table, ContentValues values) {
//        Log.i("EventMaintenance", "save update");
        values.put("dt_inc", mFormat.format(new Date()));
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String whereClause = "_ID = ?";
        String[] whereArgs = {values.getAsString("_ID")};
        int result;
        try {
            return db.update(table, values, whereClause, whereArgs);
        } catch (Exception e) {
            Log.e(TAG, "ERRO no updateValueOnTable");
            result = -1;
        }
        return result;
    }

    public int deleteValueOnTable(String table, ContentValues values) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String whereClause = "_ID = ?";
        String[] whereArgs = {values.getAsString("_ID")};
        int result;
        try {
            result = db.delete(table, whereClause, whereArgs);
        } catch (Exception e) {
            result = -1;
        }
        return result;
    }
}
