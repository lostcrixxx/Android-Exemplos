public class HelperDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String TABELA = "contatos";    //nome da tabela
    private static final String DATABASE_NAME = "db_agenda";   //nome do BD

    private static final String TABLE_CREATE = "create table " + TABELA +
            " (nome String PRIMARY KEY, celular String, email String);";

    HelperDB(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}
