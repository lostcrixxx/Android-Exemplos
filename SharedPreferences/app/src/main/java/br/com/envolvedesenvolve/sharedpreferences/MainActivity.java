package br.com.envolvedesenvolve.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nome = (EditText) findViewById(R.id.edtNome);
        final EditText email = (EditText) findViewById(R.id.edtEmail);
        final CheckBox check = (CheckBox) findViewById(R.id.checkBox);

        Button gravar = (Button) findViewById(R.id.btnGravar);
        Button limpar = (Button) findViewById(R.id.btnLimpar);
        Button recuperar = (Button) findViewById(R.id.btnRecuperar);

        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = prefs.edit();

                ed.putString("nome", nome.getText().toString());
                ed.putString("email", email.getText().toString());
                ed.putBoolean("guardar", check.isChecked());

                ed.apply();
                Toast.makeText(getBaseContext(), "gravado com sucesso!", Toast.LENGTH_LONG).show();
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome.setText("");
                email.setText("");
                check.setChecked(false);
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                nome.setText(prefs.getString("nome", "Não encontrado"));
                email.setText(prefs.getString("email", "Não encontrado"));
                check.setChecked(prefs.getBoolean("guardar", Boolean.parseBoolean("Não encontrado")));
            }
        });
    }
}
