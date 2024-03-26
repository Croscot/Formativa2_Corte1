package com.example.formativa2_corte1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EcuacionCuadratica extends AppCompatActivity {
    EditText coeficienteA, coeficienteB, coeficienteC;
    Button calcular;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuacion);

        coeficienteA = (EditText) findViewById(R.id.edtinputA);
        coeficienteB = (EditText) findViewById(R.id.edtinputB);
        coeficienteC = (EditText) findViewById(R.id.edtinputC);
        calcular = (Button) findViewById(R.id.btncalcular3);
        resultado = (TextView) findViewById(R.id.txtresultado3);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(coeficienteA.getText().toString()),
                           b = Double.parseDouble(coeficienteB.getText().toString()),
                           c = Double.parseDouble(coeficienteC.getText().toString());

                    calcularRaices(a, b, c);
                } catch (NumberFormatException e) {
                    resultado.setText("Error: El número ingresado no es válido");
                }
            }
        });
    }

    public void calcularRaices(double a, double b, double c) {
        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            resultado.setText("La ecuación tiene dos raíces reales y distintas: \nx1 = " + x1 + ", \nx2 = " + x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            resultado.setText("La ecuación tiene una única raíz real (raíces iguales): x = " + x);
        } else {
            double parteReal = -b / (2 * a);
            double parteImaginaria = Math.sqrt(-discriminante) / (2 * a);
            resultado.setText("La ecuación no tiene raíces reales. Raíces complejas: \n" +
                    "\nx1 = " + parteReal + " + " + parteImaginaria + "i, \nx2 = " +
                    parteReal + " - " + parteImaginaria + "i");
        }
    }
}
