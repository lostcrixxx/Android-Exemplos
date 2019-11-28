package br.com.envolvedesenvolve.buttons;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.HashMap;

public class AddSwitchListActivity extends DialogFragment {

    Activity parent;

    public AddSwitchListActivity() {
    }

    public class MenuMapsTypeClass extends BaseAdapter {

        Context context;
        private String[] values;

        private final ArrayList<String> titles = new ArrayList<>();
        private final ArrayList<String> imgs = new ArrayList<>();
        private final ArrayList<Boolean> alert = new ArrayList<>();

        public MenuMapsTypeClass(Context context, String[] values) {
//            super(context, R.layout.activity_maps_menu_type, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public int getCount() {
            return values.length;
        }

        @Override
        public Object getItem(int i) {
            return values[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            Log.e(TAG, "getView ");
            View rowView = inflater.inflate(R.layout.activity_maps_switch, parent, false);
            try {
//                Log.e(TAG, "rowView ");
//                TextView t = (TextView) rowView.findViewById(R.id.textView9);
                Switch s = (Switch) rowView.findViewById(R.id.switchType);
//            s.setChecked(alert.get(position));
                s.setChecked(true);
//                s.setText(titles.get(position)); // ArrayList
                s.setText(values[position]); // Vetor
//                s.setText("teste");
//                t.setText("teste");

                s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        alert.set(position, isChecked);
                    }
                });
            } catch (Exception e) {
//                Log.e(TAG, "getView ");
                e.printStackTrace();
            }


            return rowView;
        }
    }

    private View view;
    private ListView lv;
    private SearchView sv;
    private String[] players = {"Lionel Messi", "Christiano Ronaldo", "Neymar", "Gareth Bale"};

    public static HashMap<Integer, Boolean> map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_add_switch_list, container, false);
        this.getDialog().setTitle("Seleção");

//        sv = (SearchView) view.findViewById(R.id.searchSwitchType);
        lv = (ListView) view.findViewById(R.id.listSwitchType);

        try {
            lv.setAdapter(new MenuMapsTypeClass(getContext(), players));
//            Log.e(TAG, "lv.setAdapter ");
        } catch (Exception e) {
//            Log.e(TAG, "ERROR lv.setAdapter ");
            e.printStackTrace();
        }

        Button btnSave = (Button) view.findViewById(R.id.btn_fab_save);
        Button btnCancel = (Button) view.findViewById(R.id.btn_fab_cancel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
