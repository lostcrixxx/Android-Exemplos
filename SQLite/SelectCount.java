public long getCount(Context context){
    long count = 0;

    HelperDB helperDB = new HelperDB(context);
    SQLiteDatabase db = helperDB.getReadableDatabase();

    count = DatabaseUtils.queryNumEntries(db,"nameTable");

    db.close();
    return count;
}