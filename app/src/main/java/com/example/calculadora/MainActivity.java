package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResultado;
    private float numero1;
    float valor = numero1;

    private float numero2;
    float valor2 = numero2;
    String operacion = "";

    float valorPorcentaje = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.tvResultado);
        numero1 = 0f;
        numero2 = 0f;
    }

    public void EscribiSiete(View view) {
        String currentValue = tvResultado.getText().toString();
        if (currentValue.equals("-")) {
            tvResultado.setText("-7");
        } else {
            numero1 = Float.parseFloat(currentValue);
            if (numero1 == 0.0f){
                tvResultado.setText("7");
            }else {
                tvResultado.setText(tvResultado.getText() + "7");
            }
        }
    }

    public void EscribiOcho(View view) {
        String currentValue = tvResultado.getText().toString();
        if (currentValue.equals("-")) {
            tvResultado.setText("-8");
        } else {
            numero1 = Float.parseFloat(currentValue);
            if (numero1 == 0.0f){
                tvResultado.setText("8");
            }else {
                tvResultado.setText(tvResultado.getText() + "8");
            }
        }
    }

    public void Escribircero(View view) {
        String currentValue = tvResultado.getText().toString();
        if (currentValue.equals("-")) {
            tvResultado.setText("-0");
        } else {
            numero1 = Float.parseFloat(currentValue);
            if (numero1 == 0.0f){
                tvResultado.setText("0");
            }else {
                tvResultado.setText(tvResultado.getText() + "0");
            }
        }
    }


    public void EscribirNueve(View view) {
        String currentValue = tvResultado.getText().toString();
        if (currentValue.equals("-")) {
            tvResultado.setText("-9");
        } else {
            numero1 = Float.parseFloat(currentValue);
            if (numero1 == 0.0f){
                tvResultado.setText("9");
            }else {
                tvResultado.setText(tvResultado.getText() + "9");
            }
        }
    }

    public void EscribirCuatro(View view) {
        String currentValue = tvResultado.getText().toString();
        if (currentValue.equals("-")) {
            tvResultado.setText("-4");
        } else {
            numero1 = Float.parseFloat(currentValue);
            if (numero1 == 0.0f){
                tvResultado.setText("4");
            }else {
                tvResultado.setText(tvResultado.getText() + "4");
            }
        }
    }

    public void EscribirCinco(View view) {
        String currentValue = tvResultado.getText().toString();
        if (currentValue.equals("-")) {
            tvResultado.setText("-5");
        } else {
            numero1 = Float.parseFloat(currentValue);
            if (numero1 == 0.0f){
                tvResultado.setText("5");
            }else {
                tvResultado.setText(tvResultado.getText() + "5");
            }
        }
    }

    public void EscribirSeis(View view) {
        String currentValue = tvResultado.getText().toString();
        if (currentValue.equals("-")) {
            tvResultado.setText("-6");
        } else {
            numero1 = Float.parseFloat(currentValue);
            if (numero1 == 0.0f){
                tvResultado.setText("6");
            }else {
                tvResultado.setText(tvResultado.getText() + "6");
            }
        }
    }

    public void EscribirUno(View view) {
        String currentValue = tvResultado.getText().toString();
        if (currentValue.equals("-")) {
            tvResultado.setText("-1");
        } else {
            numero1 = Float.parseFloat(currentValue);
            if (numero1 == 0.0f){
                tvResultado.setText("1");
            }else {
                tvResultado.setText(tvResultado.getText() + "1");
            }
        }
    }

    public void EscribirDos(View view) {
        String currentValue = tvResultado.getText().toString();
        if (currentValue.equals("-")) {
            tvResultado.setText("-2");
        } else {
            numero1 = Float.parseFloat(currentValue);
            if (numero1 == 0.0f){
                tvResultado.setText("2");
            }else {
                tvResultado.setText(tvResultado.getText() + "2");
            }
        }
    }

    public void EscribirTres(View view) {
        String currentValue = tvResultado.getText().toString();
        if (currentValue.equals("-")) {
            tvResultado.setText("-3");
        } else {
            numero1 = Float.parseFloat(currentValue);
            if (numero1 == 0.0f){
                tvResultado.setText("3");
            }else {
                tvResultado.setText(tvResultado.getText() + "3");
            }
        }
    }

    public void LimpiarResultado(View view) {
        tvResultado.setText("0");
        numero1 = 0f;
        numero2 = 0f;
        operacion = "";
    }

    public void OperacionDividir(View view) {
        valor = Float.parseFloat(tvResultado.getText().toString());
        operacion = "/";
        tvResultado.setText("0");

    }
    public void OperacionProducto(View view){
        valor = Float.parseFloat(tvResultado.getText().toString());
        operacion = "*";
        tvResultado.setText("0");
    }
    public void OperacionResta(View view){
        valor = Float.parseFloat(tvResultado.getText().toString());
        operacion = "-";
        tvResultado.setText("-");
    }

    public void OperacionSuma(View view){
        valor = Float.parseFloat(tvResultado.getText().toString());
        operacion = "+";
        tvResultado.setText("0");
    }

    public void OperacionPorcentaje(View view) {
        float valorActual = Float.parseFloat(tvResultado.getText().toString());
        valorPorcentaje = valorActual / 100f;
        operacion = "%";
        tvResultado.setText("0");
    }

    public void EscribirComa(View view) {
        String currentValue = tvResultado.getText().toString();
        if (!currentValue.contains(".")) {
            if (currentValue.equals("0")) {
                tvResultado.setText("0.");
            } else {
                tvResultado.setText(currentValue + ".");
            }
        }
    }

    public void CambiarSigno(View view) {
        String currentValue = tvResultado.getText().toString();
        if (!currentValue.isEmpty() && !currentValue.equals("0")) {
            float valorActual = Float.parseFloat(currentValue);
            float valorNegativo = valorActual * (-1);
            tvResultado.setText(valorNegativo + "");
        }
    }

    public void MostrarResultado(View view) {
        valor2 = Float.parseFloat(tvResultado.getText().toString());
        if (operacion.equals("-")){
            float result = valor - valor2;
            tvResultado.setText(result + "");
        } else if (operacion.equals("*")) {
            float result = valor * valor2;
            tvResultado.setText(result + "");
        } else if (operacion.equals("+")) {
            float result = valor + valor2;
            tvResultado.setText(result + "");
        } else if (operacion.equals("%")) {
            float result = valor * valorPorcentaje;
            tvResultado.setText(result + "");
        } else if (operacion.equals("/")) {
            if (valor2 == 0f){
                tvResultado.setText("0");
                Toast.makeText(this, "Reingresa Operación", Toast.LENGTH_LONG).show();
            } else{
                float result = valor / valor2;
                tvResultado.setText(result + "");
            }
        }
    }
}


