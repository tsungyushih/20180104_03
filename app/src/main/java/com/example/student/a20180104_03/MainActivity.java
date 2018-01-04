package com.example.student.a20180104_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> x;
    TextView tv,tv2,tv3;
    Spinner s, s2;
    EditText ed;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s=findViewById(R.id.spinner);
        s2 = findViewById(R.id.spinner2);
        tv=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        tv3=findViewById(R.id.textView3);
        ed=findViewById(R.id.editText);

        x=new ArrayList<>();
        x.add("AAA");
        x.add("BBB");
        x.add("CCC");

        adapter=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                x
        );
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(x.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                String str[]=getResources().getStringArray(R.array.cities);
                tv3.setText(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void click1(View v)
    {
        int pos=s.getSelectedItemPosition();
        tv2.setText(x.get(pos));
    }
    public void clickAdd(View v)
    {
        x.add(ed.getText().toString());
        adapter.notifyDataSetChanged();
    }
    public void clickDelete(View v)
    {
        x.remove(s.getSelectedItemPosition());
        adapter.notifyDataSetChanged();
    }
}
