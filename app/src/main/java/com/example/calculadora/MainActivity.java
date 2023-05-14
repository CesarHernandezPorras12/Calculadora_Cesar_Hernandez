    package com.example.calculadora;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    import net.objecthunter.exp4j.Expression;
    import net.objecthunter.exp4j.ExpressionBuilder;

    import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        TextView tvResultado;
        String cadenaOperaciones = "";
        boolean nuevaOperacion = true;

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
            if (nuevaOperacion) {
                tvResultado.setText(nuevoValor);
                nuevaOperacion = false;
            } else {
                tvResultado.setText(currentValue + nuevoValor);
            }
        }

        public void EscribirComa(View view) {
            String currentValue = tvResultado.getText().toString();

            if (!currentValue.contains(".")) {
                tvResultado.setText(currentValue + ".");
            }
        }

        public void LimpiarResultado(View view) {
            tvResultado.setText("0");
        }

        public void CambiarSigno(View view) {
            String currentValue = tvResultado.getText().toString();

            if (!currentValue.isEmpty() && !currentValue.equals("0")) {
                float valorActual = Float.parseFloat(currentValue);
                float valorNegativo = valorActual * (-1);
                tvResultado.setText(valorNegativo + "");
            }
        }

        public void AplicarPorcentaje(View view) {
            String valorActual = tvResultado.getText().toString();

            if (!valorActual.isEmpty()) {
                double valor = Double.parseDouble(valorActual);
                double valorPorcentaje = valor / 100;
                tvResultado.setText(String.valueOf(valorPorcentaje));
                cadenaOperaciones = tvResultado.getText().toString();
                nuevaOperacion = true;
            } else {
                Toast.makeText(this, "Por favor ingresa un número", Toast.LENGTH_SHORT).show();
            }
        }

        public void RealizarOperacion(View view) {
            String valorActual = tvResultado.getText().toString();

            switch (view.getId()) {
                case R.id.btnmas:
                    cadenaOperaciones += valorActual + "+";
                    tvResultado.setText(cadenaOperaciones);
                    break;
                case R.id.btnmenos:
                    cadenaOperaciones += valorActual + "-";
                    tvResultado.setText(cadenaOperaciones);
                    break;
                case R.id.btnproducto:
                    cadenaOperaciones += valorActual + "*";
                    tvResultado.setText(cadenaOperaciones);
                    break;
                case R.id.btndivision:
                    cadenaOperaciones += valorActual + "/";
                    tvResultado.setText(cadenaOperaciones);
                    break;
            }
            nuevaOperacion = true;
            tvResultado.setText(cadenaOperaciones);
        }
        public void MostrarResultado(View view) {
            cadenaOperaciones += tvResultado.getText().toString();

            try {
                Expression e = new ExpressionBuilder(cadenaOperaciones).build();
                double result = e.evaluate();
                tvResultado.setText(String.valueOf(result)); // Solo mostramos el resultado
            } catch (Exception e) {
                Toast.makeText(this, "Error al calcular el resultado", Toast.LENGTH_SHORT).show();
            }

            cadenaOperaciones = "";
            nuevaOperacion = true;
        }
        // ...
    }
