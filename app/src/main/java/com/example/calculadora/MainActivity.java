package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvResultado;
    ArrayList<Float> numeros = new ArrayList<>();
    String operacionActual = "";
    float resultadoActual = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setText("0");
    }

    public void EscribirNumero(View view) {
        String currentValue = tvResultado.getText().toString();
        String nuevoValor = "";

        switch (view.getId()) {
            case R.id.btncero:
                nuevoValor = "0";
                break;
            case R.id.btnuno:
                nuevoValor = "1";
                break;
            case R.id.btndos:
                nuevoValor = "2";
                break;
            case R.id.btntres:
                nuevoValor = "3";
                break;
            case R.id.btncuatro:
                nuevoValor = "4";
                break;
            case R.id.btncinco:
                nuevoValor = "5";
                break;
            case R.id.btnseis:
                nuevoValor = "6";
                break;
            case R.id.btnsiete:
                nuevoValor = "7";
                break;
            case R.id.btnocho:
                nuevoValor = "8";
                break;
            case R.id.btnnueve:
                nuevoValor = "9";
                break;
        }

        if (currentValue.equals("0") && !nuevoValor.equals(".")) {
            tvResultado.setText(nuevoValor);
        } else {
            tvResultado.setText(currentValue + nuevoValor);
        }
    }

    public void EscribirPunto(View view) {
        String currentValue = tvResultado.getText().toString();

        if (!currentValue.contains(".")) {
            tvResultado.setText(currentValue + ".");
        }
    }

    public void LimpiarResultado(View view) {
        tvResultado.setText("0");
        numeros.clear();
        operacionActual = "";
        resultadoActual = 0f;
    }

    public void CambiarSigno(View view) {
        String currentValue = tvResultado.getText().toString();

        if (!currentValue.isEmpty() && !currentValue.equals("0")) {
            float valorActual = Float.parseFloat(currentValue);
            float valorNegativo = valorActual * (-1);
            tvResultado.setText(valorNegativo + "");
        }
    }

    public void RealizarOperacion(View view) {
        float valorActual = Float.parseFloat(tvResultado.getText().toString());
        numeros.add(valorActual);
        tvResultado.setText("0");

        switch (view.getId()) {
            case R.id.btnmas:
                operacionActual = "+";
                break;
            case R.id.btnmenos:
                operacionActual = "-";
                break;
            case R.id.btnproducto:
                operacionActual = "*";
                break;
            case R.id.btndivision:
                operacionActual = "/";
                break;
        }
    }

    public void MostrarResultado(View view) {
        float valorActual = Float.parseFloat(tvResultado.getText().toString());
        numeros.add(valorActual);

        for (int i = 0; i < numeros.size(); i++) {
            float numeroActual = numeros.get(i);

            if (operacionActual.equals("+")) {
                resultadoActual += numeroActual;
            }
        }
    }
}
