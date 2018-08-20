package br.com.envolvedesenvolve.cicloactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.minhaempresa.cicloactivity.R;

public class MainActivity extends AppCompatActivity {

    private String msg="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            msg = savedInstanceState.getString("dados");
        }
        setContentView(R.layout.activity_main);
        Log.d("MeuTeste", "Entrou no método onCreate() - valor do msg = "+ msg);
        if (savedInstanceState == null){
            msg="gravando algo";
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MeuTeste", "Entrou no método onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MeuTeste", "Entrou no método onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MeuTeste", "Entrou no método onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MeuTeste", "Entrou no método onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MeuTeste", "Entrou no método onDestroy()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("dados", msg);
        super.onSaveInstanceState(outState);
        Log.d("MeuTeste", "Entrou no método onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("MeuTeste", "Entrou no método onRestoreInstanceState()");
    }

    public void enviarSMS(View v){
        Intent share = new Intent(Intent.ACTION_SEND);
        startActivity(Intent.createChooser(share, "Share using..."));
    }
}
