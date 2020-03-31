package br.com.envolvedesenvolve.radiogroupdynamic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText=(EditText)findViewById(R.id.et_no);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                int number=Integer.parseInt(editText.getText().toString());
                addRadioButtons(number);
            }
        });
    }

    public void addRadioButtons(int number) {
        for (int row = 0; row < 1; row++) {
            RadioGroup ll = new RadioGroup(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            for (int i = 1; i <= number; i++) {
                RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId(View.generateViewId());
                rdbtn.setText("Radio " + rdbtn.getId());
                ll.addView(rdbtn);
            }
            ((ViewGroup) findViewById(R.id.radiogroup)).addView(ll);
        }
    }
}
