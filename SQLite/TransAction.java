  public class exampleTransAction {
	 private SQLiteOpenHelper dbHelper = null;
	  
    public void insertValueOnTableNTEvent(String tableName, ArrayList<Object> insp) {
//        int count = 1;
//        android.util.Log.e("DatabaseManager", "Teste insert NTEvent INICIO");

        // you can use INSERT only
        String sql = "INSERT OR REPLACE INTO " + tableName + " ( id, name, descricao ) VALUES ( ?,?,? )";

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.beginTransactionNonExclusive();
        // db.beginTransaction();

        SQLiteStatement stmt = db.compileStatement(sql);

        for (int i = 0; i < insp.size(); i++) {
            stmt.bindLong(1, insp.get(i).getId());
            stmt.bindDouble(2, insp.get(i).getName());
            stmt.bindString(3, insp.get(i).getDescription());

            stmt.execute();
            stmt.clearBindings();
//            android.util.Log.e("DatabaseManager", "Teste insert NTEvent PROCESSANDO " + count++);
        }

//        android.util.Log.i("DatabaseManager", "Teste insert NTEvent FIM ");
        db.setTransactionSuccessful();
        db.endTransaction();

        db.close();
    }
}