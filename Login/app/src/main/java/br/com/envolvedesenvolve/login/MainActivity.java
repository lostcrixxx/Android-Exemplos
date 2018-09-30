package br.com.envolvedesenvolve.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btnAcessar;

    EditText email, senha;
    RequestQueue requestQueue;
    private static final String URL = "http://site/user_control.php";
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAcessar = findViewById(R.id.btnAcessar);
        email = findViewById(R.id.txtEmail);
        senha = findViewById(R.id.txtSenha);

        requestQueue = Volley.newRequestQueue(this);

        btnAcessar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.i("login", "Apertou no login");
                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject.names().get(0).equals("ok")){
                                Log.i("login", "Verificou o login");
                                Toast.makeText(getApplicationContext(),"Login realizado com sucesso ! ", Toast.LENGTH_SHORT).show();
                                //finish();
                                //startActivity(new Intent(getApplicationContext(),PrincipalActivity.class));
                            }else if(jsonObject.names().get(0).equals("erro")) {
                                Toast.makeText(getApplicationContext(), "Email ou senha incorreto !", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> hashMap = new HashMap<String, String>();
                        hashMap.put("email",email.getText().toString());
                        hashMap.put("senha",senha.getText().toString());

                        return hashMap;
                    }
                };

                requestQueue.add(request);
            }
        });

    }


    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
}
