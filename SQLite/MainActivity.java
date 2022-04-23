public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		HelperDB db = HelperDB.getInstance(getApplicationContext());

        // test
        ContentValues cv = new ContentValues();
        cv.put("name", "teste");
        cv.put("type", "objeto");
        cv.put("price", 99.00);
        db.insertValueOnTable(DataTable.getName(), cv);

        DataTable dt = new DataTable(getApplicationContext());
        Log.e(TAG, "List: " +  Arrays.toString(dt.getAll().toArray()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void gravar(View v){
        HelperDB ch = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            EditText celular = (EditText) findViewById(R.id.cel);
            EditText email = (EditText) findViewById(R.id.email);
            String n = nome.getText().toString();
            String c = celular.getText().toString();
            String e = email.getText().toString();
            if(n.isEmpty() || c.isEmpty() || e.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, preencha os dados.",Toast.LENGTH_LONG).show();
            }
            else {
                bdw.execSQL("INSERT INTO contatos (nome,celular,email) "
                        + "  values ('" + n + "','" + c + "','" + e + "')");
                Toast.makeText(getApplicationContext(),
                        "Inserido com sucesso.",Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. Nome duplicado?\n",
                    Toast.LENGTH_LONG).show();
        }
        finally {
            if(bdw!=null) bdw.close();
            if(ch!=null) ch.close();
        }
    }

    public void listar(View v){
        HelperDB ch1 = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdr1 = null;
        String str= "\nContatos cadastrados\n\n";
        try {
            Context ctx = this;  // ou: Context ctx = v.getContext(); dentro de onClick
            ch1 = new HelperDB(ctx);
            bdr1 = ch1.getReadableDatabase();
            Cursor cursor = bdr1.query("contatos", null, null, null, null, null, null);
            // ou Cursor cursor = bdr.rawQuery("select * from contatos", null);
            while (cursor.moveToNext()) {
                String nom = cursor.getString(0);
                String cel = cursor.getString(1);
                String em = cursor.getString(2);
                str += nom + ", "  + cel + ", "  + em + "\n\n";
            }
            ((TextView)findViewById(R.id.lista)).setText(str);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD.\n", Toast.LENGTH_LONG).show();
        }
        finally {
            if(bdr1!=null) bdr1.close();
            if(ch1!=null) ch1.close();
        }
    }

    public void gravar1(View v){
        HelperDB ch = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            EditText celular = (EditText) findViewById(R.id.cel);
            EditText email = (EditText) findViewById(R.id.email);
            String n = nome.getText().toString();
            String c = celular.getText().toString();
            String e = email.getText().toString();
            if(n.isEmpty() || c.isEmpty() || e.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, preencha os dados.",Toast.LENGTH_LONG).show();
            }
            else {
                bdw.execSQL("INSERT INTO contatos (nome,celular,email) "
                        + "  values ('" + n + "','" + c + "','" + e + "')");
                Toast.makeText(getApplicationContext(),
                        "Inserido com sucesso.",Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. Nome duplicado?\n",
                    Toast.LENGTH_LONG).show();
        }
        finally {
            if(bdw!=null) bdw.close();
            if(ch!=null) ch.close();
        }
    }

    public void gravar2(View v){
        HelperDB ch = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            EditText celular = (EditText) findViewById(R.id.cel);
            EditText email = (EditText) findViewById(R.id.email);
            String n = nome.getText().toString();
            String c = celular.getText().toString();
            String e = email.getText().toString();
            if(n.isEmpty() || c.isEmpty() || e.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, preencha os dados.",Toast.LENGTH_LONG).show();
            }
            else {
                ContentValues cv = new ContentValues();
                cv.put("nome", n);
                cv.put("celular", c);
                cv.put("email", e);
                long id = bdw.insert("contatos", null, cv);
                if(id == -1) {
                    Toast.makeText(getApplicationContext(), "\nNão foi possível inserir. Nome duplicado?\n",
                            Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
                    Toast.LENGTH_LONG).show();
        }
        finally {
            if(bdw!=null) bdw.close();
            if(ch!=null) ch.close();
        }
    }

    public void alterar(View v){
        HelperDB ch = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            EditText celular = (EditText) findViewById(R.id.cel);
            EditText email = (EditText) findViewById(R.id.email);
            String n = nome.getText().toString();
            String c = celular.getText().toString();
            String e = email.getText().toString();
            if(n.isEmpty() || c.isEmpty() || e.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, preencha os dados.",Toast.LENGTH_LONG).show();
            }
            else {
                ContentValues cv = new ContentValues();
                cv.put("nome", n);
                cv.put("celular", c);
                cv.put("email", e);
                long id = bdw.update("contatos", cv , "nome='" + n + "'", null);
                if(id == 0) {
                    Toast.makeText(getApplicationContext(), "\nNão foi possível alterar\n",
                            Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
                    Toast.LENGTH_LONG).show();
        }
        finally {
            if(bdw!=null) bdw.close();
            if(ch!=null) ch.close();
        }
    }

    public void excluir(View v){
        HelperDB ch = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);

            String n = nome.getText().toString();

            if(n.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, preencha os dados.",Toast.LENGTH_LONG).show();
            }
            else {
                ContentValues cv = new ContentValues();
                cv.put("nome", n);

                long id = bdw.delete("contatos", "nome='" + n + "'", null);
                if(id == 0) {
                    Toast.makeText(getApplicationContext(), "\nNão foi possível excluir\n",
                            Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
                    Toast.LENGTH_LONG).show();
        }
        finally {
            if(bdw!=null) bdw.close();
            if(ch!=null) ch.close();
        }
    }
}
