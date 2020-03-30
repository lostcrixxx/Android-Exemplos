// Table
public String[] getAllFieldsTable() {

	SQLiteDatabase db = dbHelper.getReadableDatabase();

	String[] columnNames;
	Cursor c = db.rawQuery("SELECT * FROM 'tableName' WHERE 0", null);
	try {
		columnNames = c.getColumnNames();
	} finally {
		c.close();
	}

	db.close();
	return columnNames;
}
	
// Database
public getAllFieldsDatabase() {

    SQLiteDatabase db = dbHelper.getReadableDatabase();
	Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

	if (c.moveToFirst()) {
		while ( !c.isAfterLast() ) {
			Toast.makeText(activityName.this, "Table Name=> "+c.getString(0), Toast.LENGTH_LONG).show();
			c.moveToNext();
		}
	}
}