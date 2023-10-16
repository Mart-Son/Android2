package com.example.l2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import android.util.SparseBooleanArray;
public class MainActivity extends AppCompatActivity {
    private ArrayList<String> stringArray = new ArrayList<String>();
    private ArrayList<String> strs = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringArray.add("123456789");
        stringArray.add("23456789");
        stringArray.add("3456789");
        stringArray.add("456789");
        stringArray.add("56789");
        stringArray.add("6789");
        stringArray.add("789");
        stringArray.add("89");
        stringArray.add("9");
        stringArray.add("0");

        ArrayAdapter<String> TxtAdapter = new ArrayAdapter<String>(
        this, android.R.layout.simple_list_item_multiple_choice,stringArray);

        ListView listView = findViewById(R.id.text_list);
        listView.setAdapter(TxtAdapter);

        Button B_Add = findViewById(R.id.add);
        Button B_Delete = findViewById(R.id.delete);

        EditText entry = findViewById(R.id.editt);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SparseBooleanArray selected = listView.getCheckedItemPositions();

                B_Delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for(int i=stringArray.size();i>=0;i--)
                        {
                            if(selected.get(i))
                            {
                                stringArray.remove(i);
                            }
                        }
                        listView.setAdapter(TxtAdapter);
                    }
                });
            }
        });

        B_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = entry.getText().toString();
                if(!res.isEmpty())
                {
                    stringArray.add(res);
                    listView.setAdapter(TxtAdapter);
                }
            }
        });



    }
}