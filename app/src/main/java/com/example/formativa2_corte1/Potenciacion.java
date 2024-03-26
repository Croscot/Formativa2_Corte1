package com.example.formativa2_corte1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Potenciacion extends AppCompatActivity {

    EditText base, exponente;
    Button calcular;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potenciacion);

        base = (EditText) findViewById(R.id.edtbase);
        exponente = (EditText) findViewById(R.id.edtexponente);
        calcular = (Button) findViewById(R.id.btncalcular1);
        resultado = (TextView) findViewById(R.id.txtresultado1);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double valorBase = Double.parseDouble(base.getText().toString()),
                            valorExponente = Double.parseDouble(exponente.getText().toString());
                    resultado.setText("La potencia del " + valorBase + " elevado a " + valorExponente + " es: " + calcularPotencia(valorBase, valorExponente));
                } catch (NumberFormatException e) {
                    resultado.setText("Por favor, ingrese números válidos.");
                }
            }
        });
    }

    public double calcularPotencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }
}