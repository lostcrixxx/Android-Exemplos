    public void dropTable(ArrayList<String> tables) {
        SQLiteDatabase database = this.getWritableDatabase();
        for(String nameTable : tables) {
            try {
                database.execSQL("DELETE FROM " + nameTable);
//                android.util.Log.d("NTSQLiteHelper", "deletando... tabela: " + nameTable);
            } catch(Exception e){
                android.util.Log.e("NTSQLiteHelper", "ERRO delete tabela: " + nameTable);
                e.printStackTrace();
            }
            try{
                // Limpar os ID's de cada tabela, se existir auto increment
                database.execSQL("DELETE FROM sqlite_sequence where name='" + nameTable + "'");
//                android.util.Log.d("NTSQLiteHelper", "clean sqlite_sequence tabela: " + nameTable);
            } catch(Exception e){
                android.util.Log.e("NTSQLiteHelper", "ERRO sqlite_sequence tabela: " + nameTable);
//                e.printStackTrace();
            }
        }
//        database.execSQL("DELETE FROM sqlite_sequence where name='layout'");
//        database.execSQL("DELETE FROM sqlite_sequence where name='component'");
        database.execSQL("VACUUM "); // para limpar o espaço não utilizado
    }