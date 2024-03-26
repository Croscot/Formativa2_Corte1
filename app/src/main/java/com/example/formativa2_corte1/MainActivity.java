package com.example.formativa2_corte1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView operacionesOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operacionesOption = (ListView) findViewById(R.id.list_view);
        String[] items = new String[] { "Potenciacion", "Fraccionario", "Ecuacion cuadratica" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        operacionesOption.setAdapter(adapter);
        operacionesOption.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;

                switch (position) {
                    case 0:
                        i = new Intent(getApplicationContext(), Potenciacion.class);
                        break;
                    case 1:
                        i = new Intent(getApplicationContext(), Fraccionario.class);
                        break;
                    case 2:
                        i = new Intent(getApplicationContext(), EcuacionCuadratica.class);
                        break;
                    default:
                        return;
                }

                startActivity(i);
            }
        });
    }

}