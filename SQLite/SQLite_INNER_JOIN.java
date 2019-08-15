String selection = "SELECT DISTINCT b.* FROM branch b INNER JOIN inspection i ON b._ID = i.id_branch";

NTSQLiteHelper ntsqLiteHelper = new NTSQLiteHelper(mContext); // Class extends SQLiteOpenHelper
	ntsqLiteHelper.getDatabaseName();

Cursor cursor = ntsqLiteHelper.getReadableDatabase().rawQuery(selection, null);
return cursor