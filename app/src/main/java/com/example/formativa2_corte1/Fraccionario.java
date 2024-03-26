package com.example.formativa2_corte1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Fraccionario extends AppCompatActivity {
    EditText fracc1, fracc2;
    Button calcular;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraccionario);

        fracc1 = findViewById(R.id.edtfraccionario1);
        fracc2 = findViewById(R.id.edtfraccionario2);
        calcular = findViewById(R.id.btncalcular2);
        resultado = findViewById(R.id.txtresultado2);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String[] inputFracc1 = fracc1.getText().toString().split("/");
                    String[] inputFracc2 = fracc2.getText().toString().split("/");
                    if (inputFracc1.length == 2 && inputFracc2.length == 2) {
                        int num1 = Integer.parseInt(inputFracc1[0]);
                        int den1 = Integer.parseInt(inputFracc1[1]);
                        int num2 = Integer.parseInt(inputFracc2[0]);
                        int den2 = Integer.parseInt(inputFracc2[1]);

                        if (den1 == 0 || den2 == 0) {
                            resultado.setText("Error: El denominador no puede ser cero.");
                        } else {
                            resultado.setText("La suma de las fracciones es: " + sumaFraccion(num1, den1, num2, den2));
                        }
                    } else {
                        resultado.setText("Por favor, ingrese las fracciones en el formato 'numerador/denominador'.");
                    }
                } catch (NumberFormatException e) {
                    resultado.setText("Por favor, asegúrese de que solo haya números en las fracciones.");
                }
            }
        });
    }

    public String sumaFraccion(int num1, int den1, int num2, int den2) {
        int resultadoNumerador = num1 * den2 + den1 * num2;
        int resultadoDenominador = den1 * den2;

        return simplificar(resultadoNumerador, resultadoDenominador);
    }

    public String simplificar(int num1, int num2) {
        int divisor = 2;

        while (true) {
            int mcd1 = (int) (num1 % divisor);
            int mcd2 = (int) (num2 % divisor);

            if (mcd1 == 0 && mcd2 == 0) {
                num1 /= divisor;
                num2 /= divisor;
            } else if (divisor > Math.max(num1, num2)) {
                break;
            } else {
                divisor++;
            }
        }
        return num1 + "/" + num2;
    }
}
